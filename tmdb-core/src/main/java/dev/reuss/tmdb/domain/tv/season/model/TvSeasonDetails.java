package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvSeasonImages;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Details for a TMDB TV season.
 *
 * @param objectId     internal TMDB object id
 * @param airDate      season air date
 * @param episodes     season episodes
 * @param name         season name
 * @param overview     season overview
 * @param id           TMDB season id
 * @param posterPath   poster image path
 * @param seasonNumber season number
 * @param voteAverage  vote average
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonDetails(
        @JsonProperty("_id")
        String objectId,

        @JsonProperty("air_date")
        String airDate,

        List<TvSeasonEpisode> episodes,

        String name,

        String overview,

        int id,

        @JsonProperty("poster_path")
        String posterPath,

        @JsonProperty("season_number")
        int seasonNumber,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("aggregate_credits")
        TvSeasonAggregateCredits aggregateCredits,

        @JsonProperty("changes")
        TvSeasonChanges changes,

        @JsonProperty("credits")
        TvSeasonCredits credits,

        @JsonProperty("external_ids")
        ExternalIds externalIds,

        @JsonProperty("images")
        TvSeasonImages images,

        @JsonProperty("translations")
        TvSeasonTranslations translations,

        @JsonProperty("videos")
        TvSeasonVideos videos,

        @JsonProperty("watch/providers")
        TvSeasonWatchProviders watchProviders
) implements TmdbModel {

    public TvSeasonDetails {
        episodes = TmdbCollections.list(episodes);
    }
}