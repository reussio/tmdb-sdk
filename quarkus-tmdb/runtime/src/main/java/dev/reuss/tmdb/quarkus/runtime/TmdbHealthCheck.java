package dev.reuss.tmdb.quarkus.runtime;

import dev.reuss.tmdb.TmdbClient;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 * Readiness check for the TMDB SDK client.
 */
@Readiness
public class TmdbHealthCheck implements HealthCheck {

    private final TmdbClient client;

    @Inject
    public TmdbHealthCheck(TmdbClient client) {
        this.client = client;
    }

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("tmdb")
                .status(client != null)
                .build();
    }
}
