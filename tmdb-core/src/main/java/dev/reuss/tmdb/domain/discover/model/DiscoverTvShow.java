package dev.reuss.tmdb.domain.discover.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * TV show summary returned by TMDB TV discovery.
 *
 * @param backdropPath     backdrop image path
 * @param firstAirDate     first air date
 * @param genreIds         genre ids
 * @param id               TMDB TV show id
 * @param name             localized TV show name
 * @param originCountry    origin countries
 * @param originalLanguage original language code
 * @param originalName     original TV show name
 * @param overview         TV show overview
 * @param popularity       TV show popularity
 * @param posterPath       poster image path
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DiscoverTvShow(
        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("first_air_date")
        String firstAirDate,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        int id,

        String name,

        @JsonProperty("origin_country")
        List<String> originCountry,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_name")
        String originalName,

        String overview,

        double popularity,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount
) implements TmdbModel {

    public DiscoverTvShow {
        genreIds = TmdbCollections.list(genreIds);
        originCountry = TmdbCollections.list(originCountry);
    }
}
