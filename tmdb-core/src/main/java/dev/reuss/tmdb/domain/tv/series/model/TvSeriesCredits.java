package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CastCredit;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.common.credit.CrewCredit;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Latest season credits for a TMDB TV series.
 *
 * @param id   TMDB TV series id
 * @param cast cast credits
 * @param crew crew credits
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesCredits(
        int id,
        List<CastCredit> cast,
        List<CrewCredit> crew
) implements CreditsResponse<CastCredit, CrewCredit>, TmdbModel {

    public TvSeriesCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}
