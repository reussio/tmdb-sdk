package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.quarkus.runtime.TmdbHealthCheck
import io.smallrye.health.ResponseProvider
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Readiness
import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun call_shouldReportConfiguredClientAsReady() {
        HealthCheckResponse.setResponseProvider(ResponseProvider())
        val client = TmdbClient.builder().accessToken("test-token").build()

        val response = TmdbHealthCheck(client).call()

        assertEquals("tmdb", response.name)
        assertEquals(HealthCheckResponse.Status.UP, response.status)
    }
}
