package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CastCredit;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.common.credit.CrewCredit;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Credits for a TMDB TV season.
 *
 * @param cast cast credits
 * @param crew crew credits
 * @param id   TMDB season id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonCredits(
        int id,
        List<CastCredit> cast,
        List<CrewCredit> crew
) implements CreditsResponse<CastCredit, CrewCredit>, TmdbModel {

    public TvSeasonCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}
