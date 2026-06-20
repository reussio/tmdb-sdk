package dev.reuss.tmdb.quarkus.deployment;

import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbHealthCheckRegistrationTest {

    @Test
    void shouldRegisterHealthCheckWhenSmallRyeHealthIsAvailable() {
        Capabilities capabilities = new Capabilities(Set.of(Capability.SMALLRYE_HEALTH));

        assertTrue(TmdbHealthProcessor.shouldRegisterHealthCheck(capabilities));
    }

    @Test
    void shouldSkipHealthCheckWhenSmallRyeHealthIsMissing() {
        Capabilities capabilities = new Capabilities(Set.of());

        assertFalse(TmdbHealthProcessor.shouldRegisterHealthCheck(capabilities));
    }
}
