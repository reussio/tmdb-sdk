package dev.reuss.tmdb.domain.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CastCredit;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.common.credit.CrewCredit;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Credits for a TMDB movie.
 *
 * @param id   TMDB movie id
 * @param cast movie cast credits
 * @param crew movie crew credits
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieCredits(
        int id,
        List<CastCredit> cast,
        List<CrewCredit> crew
) implements CreditsResponse<CastCredit, CrewCredit>, TmdbModel {

    public MovieCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}
