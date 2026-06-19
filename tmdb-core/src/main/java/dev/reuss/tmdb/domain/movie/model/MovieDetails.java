package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.company.ProductionCompany;
import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.genre.Genre;
import dev.reuss.tmdb.common.image.MovieImages;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Details for a TMDB movie.
 *
 * @param adult               whether the movie is marked as adult
 * @param backdropPath        backdrop image path
 * @param belongsToCollection collection this movie belongs to
 * @param budget              movie budget
 * @param genres              movie genres
 * @param homepage            movie homepage
 * @param id                  TMDB movie id
 * @param imdbId              IMDb id
 * @param originCountry       origin countries
 * @param originalLanguage    original language
 * @param originalTitle       original title
 * @param overview            movie overview
 * @param popularity          popularity
 * @param posterPath          poster image path
 * @param productionCompanies production companies
 * @param productionCountries production countries
 * @param releaseDate         release date
 * @param revenue             movie revenue
 * @param runtime             runtime in minutes
 * @param spokenLanguages     spoken languages
 * @param status              movie status
 * @param tagline             movie tagline
 * @param title               movie title
 * @param video               whether the movie has video flag
 * @param voteAverage         vote average
 * @param voteCount           vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieDetails(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("belongs_to_collection")
        MovieCollection belongsToCollection,

        long budget,

        List<Genre> genres,

        String homepage,

        int id,

        @JsonProperty("imdb_id")
        String imdbId,

        @JsonProperty("origin_country")
        List<String> originCountry,

        @JsonProperty("original_language")
        String originalLanguage,

        @JsonProperty("original_title")
        String originalTitle,

        String overview,

        double popularity,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("production_companies")
        List<ProductionCompany> productionCompanies,

        @JsonProperty("production_countries")
        List<MovieProductionCountry> productionCountries,

        @JsonProperty("release_date")
        String releaseDate,

        long revenue,

        Integer runtime,

        @JsonProperty("spoken_languages")
        List<MovieSpokenLanguage> spokenLanguages,

        String status,

        String tagline,

        String title,

        boolean video,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("alternative_titles")
        MovieAlternativeTitles alternativeTitles,

        @JsonProperty("changes")
        MovieChanges changes,
        @JsonProperty("credits")
        MovieCredits credits,

        @JsonProperty("external_ids")
        ExternalIds externalIds,

        @JsonProperty("images") MovieImages images,

        @JsonProperty("keywords")
        MovieKeywords keywords,

        @JsonProperty("recommendations")
        MovieRecommendations recommendations,

        @JsonProperty("release_dates")
        MovieReleaseDates releaseDates,

        @JsonProperty("reviews")
        MovieReviews reviews,

        @JsonProperty("similar")
        SimilarMovies similar,

        @JsonProperty("translations")
        MovieTranslations translations,

        @JsonProperty("videos")
        MovieVideos videos,

        @JsonProperty("watch/providers")
        MovieWatchProviders watchProviders
) implements TmdbModel {

    public MovieDetails {
        genres = TmdbCollections.list(genres);
        originCountry = TmdbCollections.list(originCountry);
        productionCompanies = TmdbCollections.list(productionCompanies);
        productionCountries = TmdbCollections.list(productionCountries);
        spokenLanguages = TmdbCollections.list(spokenLanguages);
    }
}
