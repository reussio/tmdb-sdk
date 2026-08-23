package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator

/**
 * Reports whether a TMDB client bean was configured.
 *
 * The indicator deliberately performs no network request and therefore does not assert TMDB API
 * reachability or token validity.
 */
class TmdbHealthIndicator(
    private val tmdbClient: TmdbClient?,
) : HealthIndicator {
    override fun health(): Health =
        if (tmdbClient == null) {
            Health
                .down()
                .withDetail("client", "missing")
                .build()
        } else {
            Health
                .up()
                .withDetail("client", "configured")
                .build()
        }
}
