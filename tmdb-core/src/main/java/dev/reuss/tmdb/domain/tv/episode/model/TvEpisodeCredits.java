package dev.reuss.tmdb.domain.tv.episode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CastCredit;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.common.credit.CrewCredit;
import dev.reuss.tmdb.common.credit.GuestStarCredit;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Credits for a TMDB TV episode.
 *
 * @param cast       episode cast credits
 * @param crew       episode crew credits
 * @param guestStars episode guest stars
 * @param id         TMDB episode id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvEpisodeCredits(
        int id,
        List<CrewCredit> crew,
        List<CastCredit> cast,

        @JsonProperty("guest_stars")
        List<GuestStarCredit> guestStars

) implements CreditsResponse<CastCredit, CrewCredit>, TmdbModel {

    public TvEpisodeCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
        guestStars = TmdbCollections.list(guestStars);
    }
}
