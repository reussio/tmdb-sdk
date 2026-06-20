package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.quarkus.runtime.TmdbHealthCheck;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbHealthCheckTest {

    @Test
    void shouldBeReadinessHealthCheck() {
        assertTrue(HealthCheck.class.isAssignableFrom(TmdbHealthCheck.class));
        assertTrue(TmdbHealthCheck.class.isAnnotationPresent(Readiness.class));
    }
}
