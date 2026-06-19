package dev.reuss.tmdb.spring.boot;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tmdb")
public record TmdbProperties(
        String accessToken,
        String baseUrl,
        String defaultLanguage,
        String defaultRegion,
        Duration connectTimeout,
        Duration requestTimeout
) {
}
