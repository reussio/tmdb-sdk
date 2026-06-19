package dev.reuss.tmdb.domain.certifications.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Represents a TMDB certification entry.
 *
 * @param certification certification value, for example {@code 12}, {@code PG-13} or {@code R}
 * @param meaning       certification meaning
 * @param order         display or severity order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Certification(
        String certification,
        String meaning,
        int order
) implements TmdbModel {
}
