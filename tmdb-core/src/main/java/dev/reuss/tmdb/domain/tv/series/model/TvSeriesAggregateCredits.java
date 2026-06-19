package dev.reuss.tmdb.domain.tv.series.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Aggregate credits for a TMDB TV series.
 *
 * @param cast aggregate cast credits
 * @param crew aggregate crew credits
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvSeriesAggregateCredits(
        List<TvSeriesAggregateCastCredit> cast,
        List<TvSeriesAggregateCrewCredit> crew
) implements TmdbModel {

    public TvSeriesAggregateCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}