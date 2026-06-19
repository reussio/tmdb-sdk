package dev.reuss.tmdb.domain.credits.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.value.media.MediaType;

/**
 * TMDB credit details.
 *
 * @param creditType credit type, for example {@code cast} or {@code crew}
 * @param department credit department
 * @param job        credit job
 * @param media      related movie or TV media
 * @param mediaType  media type, for example {@code movie} or {@code tv}
 * @param id         TMDB credit id
 * @param person     credited person
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CreditDetails(
        @JsonProperty("credit_type")
        String creditType,

        String department,

        String job,

        CreditMedia media,

        @JsonProperty("media_type")
        MediaType mediaType,

        String id,

        CreditPerson person
) implements TmdbModel {
}