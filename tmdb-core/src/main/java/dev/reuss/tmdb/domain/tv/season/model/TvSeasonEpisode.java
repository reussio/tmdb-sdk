package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CrewCredit;
import dev.reuss.tmdb.common.credit.GuestStarCredit;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Episode of a TMDB TV season.
 *
 * @param airDate        episode air date
 * @param episodeNumber  episode number
 * @param episodeType    episode type
 * @param id             TMDB episode id
 * @param name           episode name
 * @param overview       episode overview
 * @param productionCode production code
 * @param runtime        runtime in minutes
 * @param seasonNumber   season number
 * @param showId         TMDB TV series id
 * @param stillPath      still image path
 * @param voteAverage    vote average
 * @param voteCount      vote count
 * @param crew           episode crew
 * @param guestStars     episode guest stars
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonEpisode(
        @JsonProperty("air_date")
        String airDate,

        @JsonProperty("episode_number")
        int episodeNumber,

        @JsonProperty("episode_type")
        String episodeType,

        int id,

        String name,

        String overview,

        @JsonProperty("production_code")
        String productionCode,

        Integer runtime,

        @JsonProperty("season_number")
        int seasonNumber,

        @JsonProperty("show_id")
        int showId,

        @JsonProperty("still_path")
        String stillPath,

        @JsonProperty("vote_average")
        double voteAverage,

        @JsonProperty("vote_count")
        int voteCount,

        List<CrewCredit> crew,

        @JsonProperty("guest_stars")
        List<GuestStarCredit> guestStars
) implements TmdbModel {

    public TvSeasonEpisode {
        crew = TmdbCollections.list(crew);
        guestStars = TmdbCollections.list(guestStars);
    }
}
