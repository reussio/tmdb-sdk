package dev.reuss.tmdb.core.http

import com.sun.net.httpserver.HttpServer
import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.exception.*
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.net.InetSocketAddress
import java.time.Duration

class JavaNetTmdbHttpClientTest {

    private var server: HttpServer? = null
    private var lastRequestUri: String? = null
    private var lastAuthorizationHeader: String? = null

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

        val client = JavaNetTmdbHttpClient(config(serverBaseUrl()))

        assertThrows<TmdbMappingException> {
            client.get(
                TmdbRequest.get("/movie/550"),
                SuccessResponse::class.java
            )
        }
    }

    @Test
    fun wrapsIoFailuresInClientException() {
        val client = JavaNetTmdbHttpClient(
            config("http://127.0.0.1:9")
        )

        assertThrows<TmdbClientException> {
            client.get(
                TmdbRequest.get("/movie/550"),
                SuccessResponse::class.java
            )
        }
    }

    @Test
    fun sendsAuthorizationHeaderAndEncodesQuery() {
        startServer(200, """{"id":550}""")

        val client = JavaNetTmdbHttpClient(config(serverBaseUrl()))

        val response = client.get(
            TmdbRequest.get(
                "/movie/550",
                QueryParams.create()
                    .add("query", "Fight Club")
            ),
            SuccessResponse::class.java
        )

        assertEquals(550, response.id)
        assertEquals("/movie/550?query=Fight+Club", lastRequestUri)
        assertEquals("Bearer test-token", lastAuthorizationHeader)
    }

    private fun assertHttpStatusMapsTo(
        status: Int,
        exceptionType: Class<out TmdbApiException>
    ) {
        startServer(
            status,
            """
            {
              "success": false,
              "status_code": $status,
              "status_message": "mapped error"
            }
            """.trimIndent()
        )

        val client = JavaNetTmdbHttpClient(config(serverBaseUrl()))

        val exception = assertThrows<TmdbApiException> {
            client.get(
                TmdbRequest.get("/failing"),
                SuccessResponse::class.java
            )
        }

        assertInstanceOf(exceptionType, exception)
        assertEquals(status, exception.httpStatus)

        stopServer()
    }

    private fun startServer(
        status: Int,
        body: String
    ) {
        stopServer()

        val newServer = HttpServer.create(
            InetSocketAddress("127.0.0.1", 0),
            0
        )

        newServer.createContext("/") { exchange ->
            lastRequestUri = exchange.requestURI.toString()
            lastAuthorizationHeader =
                exchange.requestHeaders.getFirst("Authorization")

            val bytes = body.toByteArray(Charsets.UTF_8)

            exchange.responseHeaders.add(
                "Content-Type",
                "application/json"
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

    private fun config(baseUrl: String): TmdbClientConfig =
        TmdbClientConfig(
            TmdbAuth.bearerToken("test-token"),
            baseUrl,
            Language.of("en-US"),
            null,
            Duration.ofSeconds(1),
            Duration.ofSeconds(1),
            TmdbMetricsRecorder.NOOP
        )

    private data class SuccessResponse(
        val id: Int
    )
}