package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.quarkus.runtime.TmdbHealthCheck
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.Readiness
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TmdbHealthCheckTest {
    @Test
    fun shouldBeReadinessHealthCheck() {
        assertTrue(
            HealthCheck::class.java.isAssignableFrom(
                TmdbHealthCheck::class.java,
            ),
        )

        assertTrue(
            TmdbHealthCheck::class.java.isAnnotationPresent(
                Readiness::class.java,
            ),
        )
    }
}
