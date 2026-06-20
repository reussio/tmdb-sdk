package dev.reuss.tmdb.quarkus.runtime;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.core.config.TmdbClientConfig;
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;
import io.quarkus.arc.SyntheticCreationalContext;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Function;

public final class TmdbClientCreator implements Function<SyntheticCreationalContext<TmdbClient>, TmdbClient> {

    @Override
    public TmdbClient apply(SyntheticCreationalContext<TmdbClient> context) {
        return TmdbClient.builder()
                .accessToken(requiredAccessToken())
                .baseUrl(baseUrl())
                .defaultLanguage(Language.of(defaultLanguage()))
                .defaultRegion(defaultRegion().map(Region::of).orElse(null))
                .connectTimeout(connectTimeout())
                .requestTimeout(requestTimeout())
                .metricsRecorder(context.getInjectedReference(TmdbMetricsRecorder.class))
                .build();
    }

    private static Config config() {
        return ConfigProvider.getConfig();
    }

    private static String requiredAccessToken() {
        return config().getOptionalValue("tmdb.access-token", String.class)
                .filter(token -> !token.isBlank())
                .orElseThrow(() -> new IllegalStateException(
                        "Missing required property 'tmdb.access-token'. Configure your TMDB API read access token."
                ));
    }

    private static String baseUrl() {
        return config().getOptionalValue("tmdb.base-url", String.class)
                .orElse(TmdbClientConfig.DEFAULT_BASE_URL);
    }

    private static String defaultLanguage() {
        return config().getOptionalValue("tmdb.default-language", String.class)
                .orElse(TmdbClientConfig.DEFAULT_LANGUAGE);
    }

    private static Optional<String> defaultRegion() {
        return config().getOptionalValue("tmdb.default-region", String.class)
                .filter(region -> !region.isBlank());
    }

    private static Duration connectTimeout() {
        return config().getOptionalValue("tmdb.connect-timeout", Duration.class)
                .orElse(TmdbClientConfig.DEFAULT_CONNECT_TIMEOUT_DURATION);
    }

    private static Duration requestTimeout() {
        return config().getOptionalValue("tmdb.request-timeout", Duration.class)
                .orElse(TmdbClientConfig.DEFAULT_REQUEST_TIMEOUT_DURATION);
    }
}
