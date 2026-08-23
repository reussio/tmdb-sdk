package dev.reuss.tmdb.domain.certifications

import dev.reuss.tmdb.domain.certifications.model.MovieCertifications
import dev.reuss.tmdb.domain.certifications.model.TvCertifications

/**
 * Service for loading TMDB certification metadata.
 */
interface CertificationService {

    fun movieCertifications(): MovieCertifications

    fun tvCertifications(): TvCertifications
}
