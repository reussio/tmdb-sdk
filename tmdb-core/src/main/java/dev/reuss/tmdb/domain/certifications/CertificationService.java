package dev.reuss.tmdb.domain.certifications;

import dev.reuss.tmdb.domain.certifications.model.MovieCertifications;
import dev.reuss.tmdb.domain.certifications.model.TvCertifications;

/**
 * Service for loading TMDB certification metadata.
 */
public interface CertificationService {

    /**
     * Loads the officially supported movie certifications on TMDB.
     *
     * @return supported movie certifications grouped by region
     */
    MovieCertifications movieCertifications();

    /**
     * Loads the officially supported TV certifications on TMDB.
     *
     * @return supported TV certifications grouped by region
     */
    TvCertifications tvCertifications();
}