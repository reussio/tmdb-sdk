package dev.reuss.tmdb.domain.reviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.review.ReviewAuthorDetails;
import dev.reuss.tmdb.value.media.MediaType;

/**
 * TMDB review details.
 *
 * @param id            TMDB review id
 * @param author        review author name
 * @param authorDetails review author details
 * @param content       review content
 * @param createdAt     creation timestamp
 * @param iso6391       ISO 639-1 language code
 * @param mediaId       related movie or TV show id
 * @param mediaTitle    related movie or TV show title
 * @param mediaType     related media type, for example {@code movie} or {@code tv}
 * @param updatedAt     update timestamp
 * @param url           TMDB review URL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Review(
        String id,

        String author,

        @JsonProperty("author_details")
        ReviewAuthorDetails authorDetails,

        String content,

        @JsonProperty("created_at")
        String createdAt,

        @JsonProperty("iso_639_1")
        String iso6391,

        @JsonProperty("media_id")
        int mediaId,

        @JsonProperty("media_title")
        MediaType mediaTitle,

        @JsonProperty("media_type")
        MediaType mediaType,

        @JsonProperty("updated_at")
        String updatedAt,

        String url
) implements TmdbModel {
}
