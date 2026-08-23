package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.TmdbClient
import jakarta.inject.Inject
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Readiness

/**
 * Readiness check that confirms the Quarkus TMDB client bean was created.
 *
 * The check deliberately performs no network request and therefore does not assert TMDB API
 * reachability or token validity.
 */
@Readiness
class TmdbHealthCheck
    @Inject
    constructor(
        @Suppress("unused")
        client: TmdbClient,
    ) : HealthCheck {
        override fun call(): HealthCheckResponse =
            HealthCheckResponse
                .named("tmdb")
                .up()
                .build()
    }
