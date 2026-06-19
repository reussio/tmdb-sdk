package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Similar TV series item.
 *
 * @param adult            whether the TV series is marked as adult
 * @param backdropPath     backdrop image path
 * @param genreIds         genre ids
 * @param id               TMDB TV series id
 * @param originCountry    origin countries
 * @param originalLanguage original language
 * @param originalName     original TV series name
 * @param overview         overview
 * @param popularity       popularity
 * @param posterPath       poster image path
 * @param firstAirDate     first air date
 * @param name             TV series name
 * @param voteAverage      vote average
 * @param voteCount        vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesSimilarItem(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("genre_ids")
        List<Integer> genreIds,

        int id,

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

        @JsonProperty("first_air_date")
        String firstAirDate,

        String name,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount
) implements TmdbModel {

    public TvSeriesSimilarItem {
        genreIds = TmdbCollections.list(genreIds);
        originCountry = TmdbCollections.list(originCountry);
    }
}
