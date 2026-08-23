package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.TmdbClient
import jakarta.inject.Inject
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Readiness

/**
 * Readiness check for the TMDB SDK client.
 */
@Readiness
class TmdbHealthCheck @Inject constructor(
    @Suppress("unused")
    client: TmdbClient
) : HealthCheck {

    override fun call(): HealthCheckResponse =
        HealthCheckResponse.named("tmdb")
            .up()
            .build()
}