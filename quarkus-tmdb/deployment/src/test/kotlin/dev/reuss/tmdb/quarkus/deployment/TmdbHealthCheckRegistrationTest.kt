package dev.reuss.tmdb.quarkus.deployment

import io.quarkus.deployment.Capabilities
import io.quarkus.deployment.Capability
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TmdbHealthCheckRegistrationTest {
    @Test
    fun shouldRegisterHealthCheckWhenSmallRyeHealthIsAvailable() {
        val capabilities =
            Capabilities(
                setOf(Capability.SMALLRYE_HEALTH),
            )

        assertTrue(
            TmdbHealthProcessor.shouldRegisterHealthCheck(capabilities),
        )
    }

    @Test
    fun shouldSkipHealthCheckWhenSmallRyeHealthIsMissing() {
        val capabilities =
            Capabilities(
                emptySet(),
            )

        assertFalse(
            TmdbHealthProcessor.shouldRegisterHealthCheck(capabilities),
        )
    }
}
