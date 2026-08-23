package dev.reuss.tmdb.core.http

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.exception.TmdbApiException
import dev.reuss.tmdb.core.exception.TmdbClientException
import dev.reuss.tmdb.core.exception.TmdbErrorResponse
import dev.reuss.tmdb.core.exception.TmdbExceptions
import dev.reuss.tmdb.core.exception.TmdbMappingException
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import org.slf4j.LoggerFactory
import java.io.IOException
import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets
import java.time.Duration

/**
 * [TmdbHttpClient] implementation based on Java's built-in [HttpClient].
 *
 * This client applies the configured TMDB authentication, builds absolute
 * request URIs from [TmdbRequest] instances, sends HTTP GET requests and
 * maps successful JSON responses to the requested Java type.
 *
 * Non-successful HTTP responses are translated into SDK-specific runtime
 * exceptions.
 */
class JavaNetTmdbHttpClient(
    private val config: TmdbClientConfig,
) : TmdbHttpClient {
    private val httpClient: HttpClient =
        HttpClient
            .newBuilder()
            .connectTimeout(config.connectTimeout)
            .build()

    private val objectMapper: ObjectMapper =
        ObjectMapper()
            .registerModule(
                KotlinModule
                    .Builder()
                    .enable(KotlinFeature.NullToEmptyCollection)
                    .enable(KotlinFeature.NullToEmptyMap)
                    .build(),
            ).findAndRegisterModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    private val metricsRecorder: TmdbMetricsRecorder = config.metricsRecorder

    /**
     * Sends a GET request to TMDB and maps the JSON response body to the given type.
     */
    override fun <T> get(
        request: TmdbRequest,
        responseType: Class<T>,
    ): T {
        log.debug(
            "Sending TMDB request: method=GET, path={}, responseType={}",
            request.path,
            responseType.simpleName,
        )

        val uri = buildUri(request)
        log.trace("Resolved TMDB request URI: {}", uri)

        val httpRequest =
            HttpRequest
                .newBuilder(uri)
                .timeout(config.requestTimeout)
                .header("Authorization", config.auth.authorizationHeaderValue())
                .header("Accept", "application/json")
                .GET()
                .build()

        val method = httpRequest.method()
        val path = request.path
        val startedAt = System.nanoTime()

        metricsRecorder.recordRequestStarted(method, path)

        try {
            val response =
                httpClient.send(
                    httpRequest,
                    HttpResponse.BodyHandlers.ofString(),
                )

            val durationMillis = elapsedMillis(startedAt)

            metricsRecorder.recordRequestFinished(
                method,
                path,
                response.statusCode(),
                Duration.ofMillis(durationMillis),
                responseBytes(response.body()),
            )

            return handleResponse(
                response,
                responseType,
                method,
                path,
                durationMillis,
            )
        } catch (exception: IOException) {
            val duration = Duration.ofNanos(System.nanoTime() - startedAt)

            metricsRecorder.recordRequestFailed(
                method,
                path,
                exception,
                duration,
            )

            throw TmdbClientException(
                "Failed to execute TMDB request",
                exception,
            )
        } catch (exception: InterruptedException) {
            val duration = Duration.ofNanos(System.nanoTime() - startedAt)

            metricsRecorder.recordRequestFailed(
                method,
                path,
                exception,
                duration,
            )

            Thread.currentThread().interrupt()

            throw TmdbClientException(
                "TMDB request was interrupted",
                exception,
            )
        }
    }

    private fun buildUri(request: TmdbRequest): URI {
        val baseUrl = config.baseUrl.removeSuffix("/")

        val url =
            buildString {
                append(baseUrl)
                append(request.path)

                if (request.queryParams.isNotEmpty()) {
                    append("?")
                    append(toQueryString(request.queryParams))
                }
            }

        return URI.create(url)
    }

    private fun toQueryString(queryParams: Map<String, String>): String =
        queryParams.entries.joinToString("&") { (name, value) ->
            "${encode(name)}=${encode(value)}"
        }

    private fun encode(value: String): String = URLEncoder.encode(value, StandardCharsets.UTF_8)

    private fun <T> handleResponse(
        response: HttpResponse<String>,
        responseType: Class<T>,
        method: String,
        path: String,
        durationMillis: Long,
    ): T {
        val httpStatus = response.statusCode()
        val body = response.body()

        log.debug(
            "Received TMDB response: status={}, path={}, responseType={}, duration={}ms",
            httpStatus,
            path,
            responseType.simpleName,
            durationMillis,
        )

        if (httpStatus in 200..299) {
            return mapBody(
                body,
                responseType,
                method,
                path,
            )
        }

        logNonSuccessfulResponse(
            httpStatus,
            path,
            durationMillis,
        )

        throw mapErrorResponse(httpStatus, body)
    }

    private fun mapErrorResponse(
        httpStatus: Int,
        body: String,
    ): TmdbApiException =
        try {
            val errorResponse =
                objectMapper.readValue(
                    body,
                    TmdbErrorResponse::class.java,
                )

            TmdbExceptions.from(
                httpStatus,
                errorResponse.statusCode,
                errorResponse.statusMessage,
                body,
            )
        } catch (exception: Exception) {
            TmdbExceptions.fromHttpStatus(
                httpStatus,
                "TMDB request failed with status code $httpStatus",
                body,
            )
        }

    private fun <T> mapBody(
        body: String,
        responseType: Class<T>,
        method: String,
        path: String,
    ): T =
        try {
            objectMapper.readValue(body, responseType)
        } catch (exception: Exception) {
            metricsRecorder.recordMappingFailed(
                method,
                path,
                responseType,
                exception,
            )

            throw TmdbMappingException(
                "Failed to map TMDB response to ${responseType.simpleName}",
                exception,
            )
        }

    private fun logNonSuccessfulResponse(
        httpStatus: Int,
        path: String,
        durationMillis: Long,
    ) {
        when {
            httpStatus == 429 -> {
                log.warn(
                    "TMDB rate limit response received: status={}, path={}, duration={}ms",
                    httpStatus,
                    path,
                    durationMillis,
                )
            }

            httpStatus >= 500 -> {
                log.warn(
                    "TMDB server error response received: status={}, path={}, duration={}ms",
                    httpStatus,
                    path,
                    durationMillis,
                )
            }
        }
    }

    private fun elapsedMillis(startedAt: Long): Long = (System.nanoTime() - startedAt) / 1_000_000

    private fun responseBytes(body: String?): Long = body?.toByteArray(StandardCharsets.UTF_8)?.size?.toLong() ?: 0L

    companion object {
        private val log = LoggerFactory.getLogger(JavaNetTmdbHttpClient::class.java)
    }
}
