package dev.reuss.tmdb.spring.boot

import com.sun.net.httpserver.HttpServer
import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.AutoConfigurations
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import java.net.InetSocketAddress
import java.time.Duration

class TmdbClientAutoConfigurationTest {
    private val contextRunner =
        ApplicationContextRunner()
            .withConfiguration(
                AutoConfigurations.of(TmdbClientAutoConfiguration::class.java),
            )

    @Test
    fun createsTmdbClientWhenAccessTokenIsConfigured() {
        contextRunner
            .withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context)
                    .hasSingleBean(TmdbClient::class.java)
            }
    }

    @Test
    fun doesNotCreateTmdbClientWhenCustomBeanExists() {
        val customClient =
            TmdbClient
                .builder()
                .accessToken("custom-token")
                .build()

        contextRunner
            .withBean(
                TmdbClient::class.java,
                { customClient },
            ).withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context)
                    .hasSingleBean(TmdbClient::class.java)

                assertThat(
                    context.getBean(TmdbClient::class.java),
                ).isSameAs(customClient)
            }
    }

    @Test
    fun failsWhenAccessTokenIsMissing() {
        contextRunner.run { context ->
            assertThat(context).hasFailed()
            assertThat(context.startupFailure)
                .hasRootCauseMessage("TMDB access token must be configured via 'tmdb.access-token'")
        }
    }

    @Test
    fun failsWhenAccessTokenIsBlank() {
        contextRunner
            .withPropertyValues("tmdb.access-token=")
            .run { context ->
                assertThat(context).hasFailed()
                assertThat(context.startupFailure)
                    .hasRootCauseMessage("TMDB access token must be configured via 'tmdb.access-token'")
            }
    }

    @Test
    fun bindsProperties() {
        contextRunner
            .withPropertyValues(
                "tmdb.access-token=test-token",
                "tmdb.base-url=https://example.test/3",
                "tmdb.default-language=de-DE",
                "tmdb.default-region=DE",
                "tmdb.connect-timeout=2s",
                "tmdb.request-timeout=5s",
            ).run { context ->
                assertThat(context)
                    .hasSingleBean(TmdbClient::class.java)

                val properties =
                    context.getBean(TmdbProperties::class.java)

                assertThat(properties.accessToken)
                    .isEqualTo("test-token")

                assertThat(properties.baseUrl)
                    .isEqualTo("https://example.test/3")

                assertThat(properties.defaultLanguage)
                    .isEqualTo("de-DE")

                assertThat(properties.defaultRegion)
                    .isEqualTo("DE")

                assertThat(properties.connectTimeout)
                    .hasSeconds(2)

                assertThat(properties.requestTimeout)
                    .hasSeconds(5)
            }
    }

    @Test
    fun failsWhenLanguageRegionOrTimeoutIsInvalid() {
        listOf(
            "tmdb.base-url=not-a-url",
            "tmdb.default-language=invalid",
            "tmdb.default-region=ZZ",
            "tmdb.connect-timeout=0s",
            "tmdb.request-timeout=-1s",
        ).forEach { invalidProperty ->
            contextRunner
                .withPropertyValues(
                    "tmdb.access-token=test-token",
                    invalidProperty,
                ).run { context ->
                    assertThat(context).hasFailed()
                }
        }
    }

    @Test
    fun customBaseUrlAndMetricsRecorderAreUsedByConfiguredClient() {
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        var authorizationHeader: String? = null
        var rawQuery: String? = null
        val metrics = RecordingMetricsRecorder()

        server.createContext("/configuration") { exchange ->
            authorizationHeader = exchange.requestHeaders.getFirst("Authorization")
            rawQuery = exchange.requestURI.rawQuery
            val body =
                """{"images":{"secure_base_url":"https://image.tmdb.org/t/p/"}}"""
                    .toByteArray()
            exchange.sendResponseHeaders(200, body.size.toLong())
            exchange.responseBody.use { it.write(body) }
        }
        server.start()

        try {
            contextRunner
                .withBean(TmdbMetricsRecorder::class.java, { metrics })
                .withPropertyValues(
                    "tmdb.access-token=test-token",
                    "tmdb.base-url=http://127.0.0.1:${server.address.port}",
                    "tmdb.default-language=de-DE",
                    "tmdb.default-region=DE",
                ).run { context ->
                    context.getBean(TmdbClient::class.java).configuration().apiConfiguration()

                    assertThat(authorizationHeader).isEqualTo("Bearer test-token")
                    assertThat(rawQuery).isEqualTo("language=de-DE&region=DE")
                    assertThat(metrics.started).isEqualTo(1)
                    assertThat(metrics.finished).isEqualTo(1)
                }
        } finally {
            server.stop(0)
        }
    }

    private class RecordingMetricsRecorder : TmdbMetricsRecorder {
        var started = 0
        var finished = 0

        override fun recordRequestStarted(
            method: String,
            path: String,
        ) {
            started++
        }

        override fun recordRequestFinished(
            method: String,
            path: String,
            statusCode: Int,
            duration: Duration,
            responseBytes: Long,
        ) {
            finished++
        }
    }
}
