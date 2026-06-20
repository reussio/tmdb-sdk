package dev.reuss.tmdb.quarkus.deployment;

import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbMetricsProcessorTest {

    @Test
    void shouldRegisterMetricsWhenMetricsCapabilityIsAvailable() {
        Capabilities capabilities = new Capabilities(Set.of(Capability.METRICS));

        assertTrue(TmdbMetricsProcessor.shouldRegisterMetrics(capabilities));
    }

    @Test
    void shouldSkipMetricsWhenMetricsCapabilityIsMissing() {
        Capabilities capabilities = new Capabilities(Set.of());

        assertFalse(TmdbMetricsProcessor.shouldRegisterMetrics(capabilities));
    }
}
