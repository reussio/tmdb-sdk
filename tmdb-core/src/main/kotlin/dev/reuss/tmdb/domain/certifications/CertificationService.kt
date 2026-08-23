package dev.reuss.tmdb.domain.certifications

import dev.reuss.tmdb.domain.certifications.model.MovieCertifications
import dev.reuss.tmdb.domain.certifications.model.TvCertifications

/** Loads the movie and TV certification systems supported by TMDB. */
interface CertificationService {
    /** Returns movie certifications grouped by ISO 3166-1 country code. */
    fun movieCertifications(): MovieCertifications

    /** Returns TV certifications grouped by ISO 3166-1 country code. */
    fun tvCertifications(): TvCertifications
}
