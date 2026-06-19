package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;
import dev.reuss.tmdb.value.media.MediaType;

import java.util.List;

/**
 * Combined crew credit for a TMDB person.
 *
 * <p>This model supports both movie and TV credits. Fields that do not apply
 * to the concrete media type may be {@code null} or empty.</p>
 *
 * @param adult            whether the media is marked as adult
 * @param backdropPath     backdrop image path
 * @param genreIds         genre ids
 * @param id               TMDB media id
 * @param originalLanguage original language code
 * @param originalTitle    original movie title
 * @param originalName     original TV show name
 * @param overview         overview
 * @param popularity       popularity
 * @param posterPath       poster image path
 * @param releaseDate      movie release date
 * @param firstAirDate     TV first air date
 * @param title            movie title
 * @param name             TV show name
 * @param video            whether the movie has video content
 * @param voteAverage      vote average
 * @param voteCount        vote count
 * @param originCountry    TV origin countries
 * @param creditId         TMDB credit id
 * @param department       crew department
 * @param job              crew job
 * @param episodeCount     TV episode count
 * @param mediaType        media type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonCombinedCrewCredit(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        int id,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_title")
        String originalTitle,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        double popularity,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("release_date")
        String releaseDate,

        @JsonProperty("first_air_date")
        String firstAirDate,

        String title,

        String name,

        boolean video,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("origin_country")
        List<String> originCountry,

        @JsonProperty("credit_id")
        String creditId,

        String department,

        String job,

        @JsonProperty("episode_count")
        int episodeCount,

        @JsonProperty("media_type")
        MediaType mediaType
) implements TmdbModel {

    public PersonCombinedCrewCredit {
        genreIds = TmdbCollections.list(genreIds);
        originCountry = TmdbCollections.list(originCountry);
    }
}
