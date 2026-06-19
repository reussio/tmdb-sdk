package dev.reuss.tmdb.domain.certifications.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;
import java.util.Map;

/**
 * Supported TMDB TV certifications grouped by region.
 *
 * @param certifications TV certifications grouped by region code
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvCertifications(
        Map<String, List<Certification>> certifications
) implements TmdbModel {

    public TvCertifications {
        certifications = TmdbCollections.map(certifications);
    }
}