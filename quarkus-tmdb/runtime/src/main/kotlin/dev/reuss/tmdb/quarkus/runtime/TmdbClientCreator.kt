package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region
import io.quarkus.arc.SyntheticCreationalContext
import org.eclipse.microprofile.config.Config
import org.eclipse.microprofile.config.ConfigProvider
import java.time.Duration
import java.util.function.Function

class TmdbClientCreator : Function<SyntheticCreationalContext<TmdbClient>, TmdbClient> {
    override fun apply(context: SyntheticCreationalContext<TmdbClient>): TmdbClient =
        TmdbClient
            .builder()
            .accessToken(requiredAccessToken())
            .baseUrl(baseUrl())
            .defaultLanguage(Language.of(defaultLanguage()))
            .defaultRegion(defaultRegion()?.let { Region.of(it) })
            .connectTimeout(connectTimeout())
            .requestTimeout(requestTimeout())
            .metricsRecorder(
                context.getInjectedReference(TmdbMetricsRecorder::class.java),
            ).build()

    private fun config(): Config = ConfigProvider.getConfig()

    private fun requiredAccessToken(): String =
        config()
            .getOptionalValue(
                "tmdb.access-token",
                String::class.java,
            ).filter { it.isNotBlank() }
            .orElseThrow {
                IllegalStateException(
                    "Missing required property 'tmdb.access-token'. " +
                        "Configure your TMDB API read access token.",
                )
            }

    private fun baseUrl(): String =
        config()
            .getOptionalValue(
                "tmdb.base-url",
                String::class.java,
            ).orElse(TmdbClientConfig.DEFAULT_BASE_URL)

    private fun defaultLanguage(): String =
        config()
            .getOptionalValue(
                "tmdb.default-language",
                String::class.java,
            ).orElse(TmdbClientConfig.DEFAULT_LANGUAGE)

    private fun defaultRegion(): String? =
        config()
            .getOptionalValue(
                "tmdb.default-region",
                String::class.java,
            ).filter { it.isNotBlank() }
            .orElse(null)

    private fun connectTimeout(): Duration =
        config()
            .getOptionalValue(
                "tmdb.connect-timeout",
                Duration::class.java,
            ).orElse(TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT_DURATION)

    private fun requestTimeout(): Duration =
        config()
            .getOptionalValue(
                "tmdb.request-timeout",
                Duration::class.java,
            ).orElse(TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT_DURATION)
}
