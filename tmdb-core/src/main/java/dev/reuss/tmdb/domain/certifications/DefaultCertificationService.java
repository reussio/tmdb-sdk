package dev.reuss.tmdb.domain.certifications;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.certifications.model.MovieCertifications;
import dev.reuss.tmdb.domain.certifications.model.TvCertifications;

import java.util.Objects;

/**
 * Default {@link CertificationService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultCertificationService implements CertificationService {

    private final TmdbHttpClient httpClient;

    public DefaultCertificationService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public MovieCertifications movieCertifications() {
        return httpClient.get(
                TmdbRequest.get(CertificationPaths.movieCertifications()),
                MovieCertifications.class
        );
    }

    @Override
    public TvCertifications tvCertifications() {
        return httpClient.get(
                TmdbRequest.get(CertificationPaths.tvCertifications()),
                TvCertifications.class
        );
    }
}
