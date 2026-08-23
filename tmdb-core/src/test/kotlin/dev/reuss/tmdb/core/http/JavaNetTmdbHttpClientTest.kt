package dev.reuss.tmdb.core.http

import com.sun.net.httpserver.HttpServer
import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.exception.TmdbApiException
import dev.reuss.tmdb.core.exception.TmdbClientException
import dev.reuss.tmdb.core.exception.TmdbMappingException
import dev.reuss.tmdb.core.exception.TmdbNotFoundException
import dev.reuss.tmdb.core.exception.TmdbRateLimitException
import dev.reuss.tmdb.core.exception.TmdbServerException
import dev.reuss.tmdb.core.exception.TmdbUnauthorizedException
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.movie.model.MovieVideos
import dev.reuss.tmdb.domain.movie.model.MovieWatchProviders
import dev.reuss.tmdb.value.language.Language
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.net.InetSocketAddress
import java.net.http.HttpTimeoutException
import java.time.Duration

class JavaNetTmdbHttpClientTest {
    private var server: HttpServer? = null
    private var lastRequestUri: String? = null
    private var lastAuthorizationHeader: String? = null
    private var lastAcceptHeader: String? = null
    private var lastMethod: String? = null

    @AfterEach
    fun stopServer() {
        server?.stop(0)
        server = null
    }

    @Test
    fun mapsHttpErrorResponsesToSdkExceptions() {
        assertHttpStatusMapsTo(401, TmdbUnauthorizedException::class.java)
        assertHttpStatusMapsTo(403, TmdbUnauthorizedException::class.java)
        assertHttpStatusMapsTo(404, TmdbNotFoundException::class.java)
        assertHttpStatusMapsTo(429, TmdbRateLimitException::class.java)
        assertHttpStatusMapsTo(500, TmdbServerException::class.java)
        assertHttpStatusMapsTo(502, TmdbServerException::class.java)
        assertHttpStatusMapsTo(503, TmdbServerException::class.java)
        assertHttpStatusMapsTo(504, TmdbServerException::class.java)
        assertHttpStatusMapsTo(418, TmdbApiException::class.java)
    }

    @Test
    fun mapsInvalidJsonFromSuccessfulResponseToMappingException() {
        startServer(200, "{ invalid-json")

        val metrics = RecordingMetricsRecorder()
        val client = JavaNetTmdbHttpClient(config(serverBaseUrl(), metrics))

        assertThrows<TmdbMappingException> {
            client.get(
                TmdbRequest.get("/movie/550"),
                SuccessResponse::class.java,
            )
        }

        assertEquals(1, metrics.started)
        assertEquals(1, metrics.finished)
        assertEquals(1, metrics.mappingFailed)
        assertEquals("/movie/550", metrics.path)
        assertEquals(SuccessResponse::class.java, metrics.responseType)
    }

    @Test
    fun wrapsIoFailuresInClientException() {
        val metrics = RecordingMetricsRecorder()
        val client =
            JavaNetTmdbHttpClient(
                config("http://127.0.0.1:9", metrics),
            )

        assertThrows<TmdbClientException> {
            client.get(
                TmdbRequest.get("/movie/550"),
                SuccessResponse::class.java,
            )
        }

        assertEquals(1, metrics.started)
        assertEquals(1, metrics.failed)
        assertEquals(0, metrics.finished)
    }

    @Test
    fun requestTimeout_shouldBeAppliedAndReportedAsIoFailure() {
        startServer(
            200,
            """{"id":550}""",
            responseDelayMillis = 250,
        )
        val metrics = RecordingMetricsRecorder()
        val client =
            JavaNetTmdbHttpClient(
                config(
                    serverBaseUrl(),
                    metrics,
                    requestTimeout = Duration.ofMillis(50),
                ),
            )

        val exception =
            assertThrows<TmdbClientException> {
                client.get(
                    TmdbRequest.get("/movie/550"),
                    SuccessResponse::class.java,
                )
            }

        assertInstanceOf(HttpTimeoutException::class.java, exception.cause)
        assertEquals(1, metrics.started)
        assertEquals(1, metrics.failed)
        assertEquals(0, metrics.finished)
    }

    @Test
    fun interruptedRequest_shouldRestoreInterruptFlagAndRecordFailure() {
        startServer(200, """{"id":550}""")
        val metrics = RecordingMetricsRecorder()
        val client = JavaNetTmdbHttpClient(config(serverBaseUrl(), metrics))

        Thread.currentThread().interrupt()

        try {
            val exception =
                assertThrows<TmdbClientException> {
                    client.get(
                        TmdbRequest.get("/movie/550"),
                        SuccessResponse::class.java,
                    )
                }

            assertInstanceOf(InterruptedException::class.java, exception.cause)
            assertTrue(Thread.currentThread().isInterrupted)
            assertEquals(1, metrics.started)
            assertEquals(1, metrics.failed)
            assertEquals(0, metrics.finished)
        } finally {
            Thread.interrupted()
        }
    }

    @Test
    fun sendsAuthorizationHeaderAndEncodesQuery() {
        startServer(200, """{"id":550}""")

        val metrics = RecordingMetricsRecorder()
        val client = JavaNetTmdbHttpClient(config("${serverBaseUrl()}/", metrics))

        val response =
            client.get(
                TmdbRequest.get(
                    "/movie/550",
                    QueryParams
                        .create()
                        .add("search query", "Fight Club / Part?"),
                ),
                SuccessResponse::class.java,
            )

        assertEquals(550, response.id)
        assertEquals(
            "/movie/550?language=en-US&search+query=Fight+Club+%2F+Part%3F",
            lastRequestUri,
        )
        assertEquals("Bearer test-token", lastAuthorizationHeader)
        assertEquals("application/json", lastAcceptHeader)
        assertEquals("GET", lastMethod)
        assertEquals(1, metrics.started)
        assertEquals(1, metrics.finished)
        assertEquals(200, metrics.statusCode)
        assertEquals(10L, metrics.responseBytes)
        assertTrue(metrics.duration?.isNegative == false)
    }

    @Test
    fun mapsMalformedErrorBodyToStatusSpecificException() {
        startServer(404, "not-json")

        val exception =
            assertThrows<TmdbNotFoundException> {
                JavaNetTmdbHttpClient(config(serverBaseUrl())).get(
                    TmdbRequest.get("/missing"),
                    SuccessResponse::class.java,
                )
            }

        assertEquals(0, exception.tmdbStatusCode)
        assertEquals("TMDB request failed with status code 404", exception.message)
        assertEquals("not-json", exception.responseBody)
    }

    @Test
    fun jacksonConfiguration_shouldIgnoreUnknownPropertiesAndNormalizeNullCollectionsAndMaps() {
        startServer(200, """{"id":550,"results":null,"unknown":"ignored"}""")
        val client = JavaNetTmdbHttpClient(config(serverBaseUrl()))

        val videos = client.get(TmdbRequest.get("/movie/550/videos"), MovieVideos::class.java)

        assertTrue(videos.results.isEmpty())

        startServer(200, """{"id":550,"results":null}""")
        val providers =
            JavaNetTmdbHttpClient(config(serverBaseUrl())).get(
                TmdbRequest.get("/movie/550/watch/providers"),
                MovieWatchProviders::class.java,
            )

        assertTrue(providers.results.isEmpty())

        startServer(200, """{"id":550}""")
        val missingCollection =
            JavaNetTmdbHttpClient(config(serverBaseUrl())).get(
                TmdbRequest.get("/movie/550/videos"),
                MovieVideos::class.java,
            )

        assertTrue(missingCollection.results.isEmpty())
    }

    @Test
    fun jacksonConfiguration_shouldHonorJsonPropertyWireNames() {
        startServer(
            200,
            """{"iso_3166_1":"DE","english_name":"Germany","native_name":"Deutschland"}""",
        )

        val country =
            JavaNetTmdbHttpClient(config(serverBaseUrl())).get(
                TmdbRequest.get("/configuration/country"),
                Country::class.java,
            )

        assertEquals("DE", country.iso31661)
        assertEquals("Germany", country.englishName)
        assertEquals("Deutschland", country.nativeName)
    }

    @Test
    fun emptySuccessfulResponse_shouldBeReportedAsMappingFailure() {
        startServer(200, "")
        val metrics = RecordingMetricsRecorder()
        val client = JavaNetTmdbHttpClient(config(serverBaseUrl(), metrics))

        assertThrows<TmdbMappingException> {
            client.get(
                TmdbRequest.get("/movie/550"),
                SuccessResponse::class.java,
            )
        }

        assertEquals(1, metrics.finished)
        assertEquals(1, metrics.mappingFailed)
        assertEquals(0L, metrics.responseBytes)
    }

    private fun assertHttpStatusMapsTo(
        status: Int,
        exceptionType: Class<out TmdbApiException>,
    ) {
        startServer(
            status,
            """
            {
              "success": false,
              "status_code": $status,
              "status_message": "mapped error"
            }
            """.trimIndent(),
        )

        val client = JavaNetTmdbHttpClient(config(serverBaseUrl()))

        val exception =
            assertThrows<TmdbApiException> {
                client.get(
                    TmdbRequest.get("/failing"),
                    SuccessResponse::class.java,
                )
            }

        assertInstanceOf(exceptionType, exception)
        assertEquals(status, exception.httpStatus)

        stopServer()
    }

    private fun startServer(
        status: Int,
        body: String,
        responseDelayMillis: Long = 0,
    ) {
        stopServer()

        val newServer =
            HttpServer.create(
                InetSocketAddress("127.0.0.1", 0),
                0,
            )

        newServer.createContext("/") { exchange ->
            if (responseDelayMillis > 0) {
                Thread.sleep(responseDelayMillis)
            }

            lastRequestUri = exchange.requestURI.toString()
            lastAuthorizationHeader =
                exchange.requestHeaders.getFirst("Authorization")
            lastAcceptHeader = exchange.requestHeaders.getFirst("Accept")
            lastMethod = exchange.requestMethod

            val bytes = body.toByteArray(Charsets.UTF_8)

            exchange.responseHeaders.add(
                "Content-Type",
                "application/json",
            )
            exchange.sendResponseHeaders(status, bytes.size.toLong())

            exchange.responseBody.use {
                it.write(bytes)
            }
        }

        newServer.start()
        server = newServer
    }

    private fun serverBaseUrl(): String {
        val server = checkNotNull(server)

        return "http://127.0.0.1:${server.address.port}"
    }

    private fun config(
        baseUrl: String,
        metricsRecorder: TmdbMetricsRecorder = TmdbMetricsRecorder.NOOP,
        requestTimeout: Duration = Duration.ofSeconds(1),
    ): TmdbClientConfig =
        TmdbClientConfig(
            TmdbAuth.bearerToken("test-token"),
            baseUrl,
            Language.of("en-US"),
            null,
            Duration.ofSeconds(1),
            requestTimeout,
            metricsRecorder,
        )

    private data class SuccessResponse(
        val id: Int,
    )

    private class RecordingMetricsRecorder : TmdbMetricsRecorder {
        var started: Int = 0
        var finished: Int = 0
        var failed: Int = 0
        var mappingFailed: Int = 0
        var path: String? = null
        var statusCode: Int? = null
        var duration: Duration? = null
        var responseBytes: Long? = null
        var responseType: Class<*>? = null

        override fun recordRequestStarted(
            method: String,
            path: String,
        ) {
            started++
            this.path = path
        }

        override fun recordRequestFinished(
            method: String,
            path: String,
            statusCode: Int,
            duration: Duration,
            responseBytes: Long,
        ) {
            finished++
            this.statusCode = statusCode
            this.duration = duration
            this.responseBytes = responseBytes
        }

        override fun recordRequestFailed(
            method: String,
            path: String,
            exception: Throwable,
            duration: Duration,
        ) {
            failed++
            this.duration = duration
        }

        override fun recordMappingFailed(
            method: String,
            path: String,
            responseType: Class<*>,
            exception: Throwable,
        ) {
            mappingFailed++
            this.responseType = responseType
        }
    }
}
