package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Region
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

/**
 * Creates the application [TmdbClient] from `tmdb.*` properties.
 *
 * Auto-configuration backs off when an application supplies its own client. `tmdb.access-token`
 * is required; blank optional values fall back to core SDK defaults. A [TmdbMetricsRecorder] is
 * attached when one is available.
 */
@AutoConfiguration
@ConditionalOnClass(TmdbClient::class)
@EnableConfigurationProperties(TmdbProperties::class)
class TmdbClientAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    fun tmdbClient(
        properties: TmdbProperties,
        metricsRecorder: ObjectProvider<TmdbMetricsRecorder>,
    ): TmdbClient {
        val baseUrl =
            properties.baseUrl
                ?.takeUnless { it.isBlank() }
                ?: TmdbClientConfig.DEFAULT_BASE_URL

        val defaultLanguage = languageOrDefault(properties.defaultLanguage)

        val connectTimeout =
            properties.connectTimeout
                ?: TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT_DURATION

        val requestTimeout =
            properties.requestTimeout
                ?: TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT_DURATION

        val defaultRegion =
            properties.defaultRegion
                ?.takeUnless { it.isBlank() }
                ?.let { Region.of(it) }

        val builder =
            TmdbClient
                .builder()
                .accessToken(requireAccessToken(properties.accessToken))
                .baseUrl(baseUrl)
                .defaultLanguage(defaultLanguage)
                .connectTimeout(connectTimeout)
                .requestTimeout(requestTimeout)

        defaultRegion?.let(builder::defaultRegion)
        metricsRecorder.ifAvailable(builder::metricsRecorder)

        val client = builder.build()

        log.info(
            "Configured TMDB JVM SDK client: baseUrl={}, defaultLanguage={}, defaultRegion={}, connectTimeout={}, requestTimeout={}",
            baseUrl,
            defaultLanguage,
            defaultRegion ?: "none",
            connectTimeout.seconds,
            requestTimeout.seconds,
        )

        return client
    }

    private fun languageOrDefault(value: String?): Language {
        if (value.isNullOrBlank()) {
            return Languages.EN_US
        }

        return try {
            Language.of(value)
        } catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException(
                "Invalid value for property 'tmdb.default-language': '$value'. " +
                    "Expected a TMDB language tag such as 'en-US' or 'de-DE'.",
                exception,
            )
        }
    }

    private fun requireAccessToken(accessToken: String?): String {
        check(!accessToken.isNullOrBlank()) {
            "TMDB access token must be configured via 'tmdb.access-token'"
        }

        return accessToken
    }

    companion object {
        private val log =
            LoggerFactory.getLogger(TmdbClientAutoConfiguration::class.java)
    }
}
