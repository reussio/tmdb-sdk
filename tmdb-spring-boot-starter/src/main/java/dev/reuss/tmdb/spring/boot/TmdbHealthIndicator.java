package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * Spring Boot Actuator health indicator for the TMDB SDK client.
 */
public class TmdbHealthIndicator implements HealthIndicator {

    private final TmdbClient tmdbClient;

    public TmdbHealthIndicator(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    @Override
    public Health health() {
        if (tmdbClient == null) {
            return Health.down()
                    .withDetail("client", "missing")
                    .build();
        }

        return Health.up()
                .withDetail("client", "configured")
                .build();
    }
}
