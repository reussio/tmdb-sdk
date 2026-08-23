package dev.reuss.tmdb.domain.certifications

import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.certifications.model.MovieCertifications
import dev.reuss.tmdb.domain.certifications.model.TvCertifications

/**
 * Default [CertificationService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultCertificationService(
    private val httpClient: TmdbHttpClient
) : CertificationService {

    override fun movieCertifications(): MovieCertifications =
        httpClient.get(
            TmdbRequest.get(CertificationPaths.movieCertifications()),
            MovieCertifications::class.java
        )

    override fun tvCertifications(): TvCertifications =
        httpClient.get(
            TmdbRequest.get(CertificationPaths.tvCertifications()),
            TvCertifications::class.java
        )
}
