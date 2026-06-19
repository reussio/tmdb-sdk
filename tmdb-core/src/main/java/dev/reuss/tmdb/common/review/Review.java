package dev.reuss.tmdb.common.review;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Review item for a TMDB resource.
 *
 * @param author        review author
 * @param authorDetails review author details
 * @param content       review content
 * @param createdAt     creation timestamp
 * @param id            review id
 * @param updatedAt     update timestamp
 * @param url           review URL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Review(
        String author,

        @JsonProperty("author_details")
        ReviewAuthorDetails authorDetails,

        String content,

        @JsonProperty("created_at")
        String createdAt,

        String id,

        @JsonProperty("updated_at")
        String updatedAt,

        String url
) implements TmdbModel {
}
