package dev.reuss.tmdb.quarkus.deployment

import io.quarkus.deployment.Capabilities
import io.quarkus.deployment.Capability
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TmdbMetricsProcessorTest {
    @Test
    fun shouldRegisterMetricsWhenMetricsCapabilityIsAvailable() {
        val capabilities =
            Capabilities(
                setOf(Capability.METRICS),
            )

        assertTrue(
            TmdbMetricsProcessor.shouldRegisterMetrics(capabilities),
        )
    }

    @Test
    fun shouldSkipMetricsWhenMetricsCapabilityIsMissing() {
        val capabilities =
            Capabilities(
                emptySet(),
            )

        assertFalse(
            TmdbMetricsProcessor.shouldRegisterMetrics(capabilities),
        )
    }
}
