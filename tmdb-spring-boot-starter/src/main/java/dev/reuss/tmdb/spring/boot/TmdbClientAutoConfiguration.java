package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.TmdbClientBuilder;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.language.Languages;
import dev.reuss.tmdb.value.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@AutoConfiguration
@ConditionalOnClass(TmdbClient.class)
@EnableConfigurationProperties(TmdbProperties.class)
public class TmdbClientAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(TmdbClientAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public TmdbClient tmdbClient(TmdbProperties properties) {
        String baseUrl = valueOrDefault(properties.baseUrl(), "https://api.themoviedb.org/3");
        Language defaultLanguage = languageOrDefault(properties.defaultLanguage());
        Duration connectTimeout = durationOrDefault(properties.connectTimeout(), Duration.ofSeconds(5));
        Duration requestTimeout = durationOrDefault(properties.requestTimeout(), Duration.ofSeconds(10));
        Region defaultRegion = regionOrNull(properties.defaultRegion());

        TmdbClientBuilder builder = TmdbClient.builder()
                .accessToken(requireAccessToken(properties.accessToken()))
                .baseUrl(baseUrl)
                .defaultLanguage(defaultLanguage)
                .connectTimeout(connectTimeout)
                .requestTimeout(requestTimeout);

        if (defaultRegion != null) {
            builder.defaultRegion(defaultRegion);
        }

        TmdbClient tmdbClient = builder.build();

        log.info(
                "Configured TMDB Java SDK client: baseUrl={}, defaultLanguage={}, defaultRegion={}, connectTimeout={}, requestTimeout={}",
                baseUrl,
                defaultLanguage,
                defaultRegion != null ? defaultRegion : "none",
                connectTimeout.toSeconds(),
                requestTimeout.toSeconds()
        );

        return tmdbClient;
    }

    private static String valueOrDefault(String value, String fallback) {
        return value == null || value.isBlank() ? fallback : value;
    }

    private static Language languageOrDefault(String value) {
        if (value == null || value.isBlank()) {
            return Languages.EN_US;
        }

        try {
            return Language.of(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Invalid value for property 'tmdb.default-language': '" + value
                            + "'. Expected a TMDB language tag such as 'en-US' or 'de-DE'."
            );
        }
    }

    private static Region regionOrNull(String value) {
        return value == null || value.isBlank() ? null : new Region(value);
    }

    private static Duration durationOrDefault(Duration value, Duration fallback) {
        return value == null ? fallback : value;
    }

    private static String requireAccessToken(String accessToken) {
        if (accessToken == null || accessToken.isBlank()) {
            throw new IllegalStateException("TMDB access token must be configured via 'tmdb.access-token'");
        }
        return accessToken;
    }
}
