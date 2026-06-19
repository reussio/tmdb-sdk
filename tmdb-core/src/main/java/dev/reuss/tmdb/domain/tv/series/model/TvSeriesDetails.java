package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.company.ProductionCompany;
import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.genre.Genre;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Details of a TMDB TV series.
 *
 * @param adult whether the series is marked as adult
 * @param backdropPath backdrop image path
 * @param createdBy series creators
 * @param episodeRunTime episode runtimes in minutes
 * @param firstAirDate first air date
 * @param genres series genres
 * @param homepage series homepage
 * @param id TMDB TV series id
 * @param inProduction whether the series is in production
 * @param languages languages used by the series
 * @param lastAirDate last air date
 * @param lastEpisodeToAir last aired episode
 * @param name series name
 * @param nextEpisodeToAir next scheduled episode
 * @param networks networks
 * @param numberOfEpisodes episode count
 * @param numberOfSeasons season count
 * @param originCountry origin countries
 * @param originalLanguage original language
 * @param originalName original name
 * @param overview series overview
 * @param popularity popularity
 * @param posterPath poster image path
 * @param productionCompanies production companies
 * @param productionCountries production countries
 * @param seasons seasons
 * @param spokenLanguages spoken languages
 * @param status series status
 * @param tagline series tagline
 * @param type series type
 * @param voteAverage vote average
 * @param voteCount vote count
 * @param aggregateCredits appended aggregate credits
 * @param alternativeTitles appended alternative titles
 * @param changes appended changes
 * @param contentRatings appended content ratings
 * @param credits appended credits
 * @param episodeGroups appended episode groups
 * @param externalIds appended external ids
 * @param keywords appended keywords
 * @param recommendations appended recommendations
 * @param reviews appended reviews
 * @param screenedTheatrically appended theatrical screenings
 * @param similar appended similar TV series
 * @param translations appended translations
 * @param videos appended videos
 * @param watchProviders appended watch providers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesDetails(
        boolean adult,

        @JsonProperty("backdrop_path")
        String backdropPath,

        @JsonProperty("created_by")
        List<TvSeriesCreator> createdBy,

        @JsonProperty("episode_run_time")
        List<Integer> episodeRunTime,

        @JsonProperty("first_air_date")
        String firstAirDate,

        List<Genre> genres,

        String homepage,

        int id,

        @JsonProperty("in_production")
        boolean inProduction,

        List<String> languages,

        @JsonProperty("last_air_date")
        String lastAirDate,

        @JsonProperty("last_episode_to_air")
        TvSeriesEpisode lastEpisodeToAir,

        String name,

        @JsonProperty("next_episode_to_air")
        TvSeriesEpisode nextEpisodeToAir,

        List<TvSeriesNetwork> networks,

        @JsonProperty("number_of_episodes")
        int numberOfEpisodes,

        @JsonProperty("number_of_seasons")
        int numberOfSeasons,

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

        @JsonProperty("production_companies")
        List<ProductionCompany> productionCompanies,

        @JsonProperty("production_countries")
        List<TvSeriesProductionCountry> productionCountries,

        List<TvSeriesSeason> seasons,

        @JsonProperty("spoken_languages")
        List<TvSeriesSpokenLanguage> spokenLanguages,

        String status,

        String tagline,

        String type,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("aggregate_credits")
        TvSeriesAggregateCredits aggregateCredits,

        @JsonProperty("alternative_titles")
        TvSeriesAlternativeTitles alternativeTitles,

        @JsonProperty("changes")
        TvSeriesChanges changes,

        @JsonProperty("content_ratings")
        TvSeriesContentRatings contentRatings,

        @JsonProperty("credits")
        TvSeriesCredits credits,

        @JsonProperty("episode_groups")
        TvSeriesEpisodeGroups episodeGroups,

        @JsonProperty("external_ids")
        ExternalIds externalIds,

        @JsonProperty("keywords")
        TvSeriesKeywords keywords,

        @JsonProperty("recommendations")
        TvSeriesRecommendations recommendations,

        @JsonProperty("reviews")
        TvSeriesReviews reviews,

        @JsonProperty("screened_theatrically")
        TvSeriesScreenedTheatrically screenedTheatrically,

        @JsonProperty("similar")
        TvSeriesSimilar similar,

        @JsonProperty("translations")
        TvSeriesTranslations translations,

        @JsonProperty("videos")
        TvSeriesVideos videos,

        @JsonProperty("watch/providers")
        TvSeriesWatchProviders watchProviders
) implements TmdbModel {

    public TvSeriesDetails {
        createdBy = TmdbCollections.list(createdBy);
        episodeRunTime = TmdbCollections.list(episodeRunTime);
        genres = TmdbCollections.list(genres);
        languages = TmdbCollections.list(languages);
        networks = TmdbCollections.list(networks);
        originCountry = TmdbCollections.list(originCountry);
        productionCompanies = TmdbCollections.list(productionCompanies);
        productionCountries = TmdbCollections.list(productionCountries);
        seasons = TmdbCollections.list(seasons);
        spokenLanguages = TmdbCollections.list(spokenLanguages);
    }
}
