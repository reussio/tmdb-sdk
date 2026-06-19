package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.PersonImages;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Top level TMDB person details.
 *
 * @param adult              whether the person is marked as adult
 * @param alsoKnownAs        alternative names
 * @param biography          person biography
 * @param birthday           birthday
 * @param deathday           deathday
 * @param gender             gender value returned by TMDB
 * @param homepage           homepage URL
 * @param id                 TMDB person id
 * @param imdbId             IMDb id
 * @param knownForDepartment known department
 * @param name               person name
 * @param placeOfBirth       place of birth
 * @param popularity         person popularity
 * @param profilePath        profile image path
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonDetails(
        boolean adult,

        @JsonProperty("also_known_as")
        List<String> alsoKnownAs,

        String biography,

        String birthday,

        String deathday,

        int gender,

        String homepage,

        int id,

        @JsonProperty("imdb_id")
        String imdbId,

        @JsonProperty("known_for_department")
        String knownForDepartment,

        String name,

        @JsonProperty("place_of_birth")
        String placeOfBirth,

        double popularity,

        @JsonProperty("profile_path")
        String profilePath,

        @JsonProperty("changes")
        PersonChanges changes,

        @JsonProperty("combined_credits")
        PersonCombinedCredits combinedCredits,

        @JsonProperty("external_ids")
        ExternalIds externalIds,

        @JsonProperty("images")
        PersonImages images,

        @JsonProperty("movie_credits")
        PersonMovieCredits movieCredits,

        @JsonProperty("tv_credits")
        PersonTvCredits tvCredits,

        @JsonProperty("translations")
        PersonTranslations translations
) implements TmdbModel {

    public PersonDetails {
        alsoKnownAs = TmdbCollections.list(alsoKnownAs);
    }
}