package dev.reuss.tmdb.domain.tv.season.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Aggregate credits for a TMDB TV season.
 *
 * @param cast aggregate cast credits
 * @param crew aggregate crew credits
 * @param id   TMDB season id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeasonAggregateCredits(
        List<TvSeasonAggregateCastCredit> cast,
        List<TvSeasonAggregateCrewCredit> crew,
        int id
) implements TmdbModel {

    public TvSeasonAggregateCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}