package dev.reuss.tmdb.quarkus.deployment

import com.sun.net.httpserver.HttpServer
import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.quarkus.runtime.TmdbConfig
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer
import io.quarkus.test.QuarkusExtensionTest
import jakarta.enterprise.inject.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.asset.StringAsset
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.net.InetSocketAddress
import java.time.Duration

class TmdbCustomMetricsRecorderTest {
    @Inject
    lateinit var client: TmdbClient

    @Inject
    lateinit var metricsRecorder: RecordingMetricsRecorder

    @Test
    fun shouldInjectCustomMetricsRecorderIntoTmdbClient() {
        client.configuration().apiConfiguration()

        assertEquals(1, metricsRecorder.started)
        assertEquals(1, metricsRecorder.finished)
        assertEquals("/configuration", metricsRecorder.path)
        assertEquals(200, metricsRecorder.statusCode)
    }

    @Singleton
    class CustomMetricsProducer {
        @Produces
        @Singleton
        fun metricsRecorder(): RecordingMetricsRecorder = RecordingMetricsRecorder()
    }

    class RecordingMetricsRecorder : TmdbMetricsRecorder {
        var started: Int = 0
        var finished: Int = 0
        var path: String? = null
        var statusCode: Int? = null

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
        }
    }

    companion object {
        private val server = startServer()

        @JvmField
        @RegisterExtension
        val app =
            QuarkusExtensionTest()
                .withApplicationRoot { jar ->
                    jar
                        .addClasses(
                            TmdbProducer::class.java,
                            TmdbConfig::class.java,
                            CustomMetricsProducer::class.java,
                            RecordingMetricsRecorder::class.java,
                        ).addAsManifestResource(
                            EmptyAsset.INSTANCE,
                            "beans.xml",
                        ).addAsResource(
                            StringAsset(
                                """
                                tmdb.access-token=test-token
                                tmdb.base-url=http://127.0.0.1:${server.address.port}
                                """.trimIndent(),
                            ),
                            "application.properties",
                        )
                }

        @JvmStatic
        @AfterAll
        fun stopServer() {
            server.stop(0)
        }

        private fun startServer(): HttpServer {
            val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)

            server.createContext("/configuration") { exchange ->
                val body =
                    """{"images":{"secure_base_url":"https://image.tmdb.org/t/p/"}}"""
                        .toByteArray()
                exchange.sendResponseHeaders(200, body.size.toLong())
                exchange.responseBody.use { it.write(body) }
            }
            server.start()
            return server
        }
    }
}
