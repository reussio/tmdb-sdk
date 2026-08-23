package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate credits for a TMDB TV series.
 *
 * @property cast aggregate cast credits
 * @property crew aggregate crew credits
 */
@JvmRecord
data class TvSeriesAggregateCredits(
    @all:JsonProperty("cast")
    val cast: List<TvSeriesAggregateCastCredit> = emptyList(),

    @all:JsonProperty("crew")
    val crew: List<TvSeriesAggregateCrewCredit> = emptyList()
) : TmdbModel
