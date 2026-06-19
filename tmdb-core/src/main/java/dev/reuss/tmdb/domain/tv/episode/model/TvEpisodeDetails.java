package dev.reuss.tmdb.domain.tv.episode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CrewCredit;
import dev.reuss.tmdb.common.credit.GuestStarCredit;
import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvEpisodeImages;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Details for a TMDB TV episode.
 *
 * @param airDate        episode air date
 * @param crew           episode crew
 * @param episodeNumber  episode number
 * @param guestStars     episode guest stars
 * @param name           episode name
 * @param overview       episode overview
 * @param id             TMDB episode id
 * @param productionCode production code
 * @param runtime        runtime in minutes
 * @param seasonNumber   season number
 * @param stillPath      still image path
 * @param voteAverage    vote average
 * @param voteCount      vote count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeDetails(
        @JsonProperty("air_date")
        String airDate,

        List<CrewCredit> crew,

        @JsonProperty("episode_number")
        int episodeNumber,

        @JsonProperty("guest_stars")
        List<GuestStarCredit> guestStars,

        String name,

        String overview,

        int id,

        @JsonProperty("production_code")
        String productionCode,

        Integer runtime,

        @JsonProperty("season_number")
        int seasonNumber,

        @JsonProperty("still_path")
        String stillPath,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        @JsonProperty("changes")
        TvEpisodeChanges changes,

        @JsonProperty("credits")
        TvEpisodeCredits credits,

        @JsonProperty("external_ids")
        ExternalIds externalIds,

        @JsonProperty("images")
        TvEpisodeImages images,

        @JsonProperty("translations")
        TvEpisodeTranslations translations,

        @JsonProperty("videos")
        TvEpisodeVideos videos
) implements TmdbModel {

    public TvEpisodeDetails {
        crew = TmdbCollections.list(crew);
        guestStars = TmdbCollections.list(guestStars);
    }
}
