package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator

/**
 * Spring Boot Actuator health indicator for the TMDB SDK client.
 */
class TmdbHealthIndicator(
    private val tmdbClient: TmdbClient?
) : HealthIndicator {

    override fun health(): Health =
        if (tmdbClient == null) {
            Health.down()
                .withDetail("client", "missing")
                .build()
        } else {
            Health.up()
                .withDetail("client", "configured")
                .build()
        }
}