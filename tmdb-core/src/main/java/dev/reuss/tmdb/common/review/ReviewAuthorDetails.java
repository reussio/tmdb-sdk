package dev.reuss.tmdb.common.review;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * Author details for a TMDB review.
 *
 * @param name       author display name
 * @param username   author username
 * @param avatarPath author avatar path
 * @param rating     author rating
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ReviewAuthorDetails(
        String name,

        String username,

        @JsonProperty("avatar_path")
        String avatarPath,

        Double rating
) implements TmdbModel {
}
