package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.AutoConfigurations
import org.springframework.boot.test.context.runner.ApplicationContextRunner

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
        }
    }

    @Test
    fun bindsProperties() {
        contextRunner
            .withPropertyValues(
                "tmdb.access-token=test-token",
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
}
