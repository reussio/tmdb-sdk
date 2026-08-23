package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Aggregate credits for a TMDB TV season.
 *
 * @property cast aggregate cast credits
 * @property crew aggregate crew credits
 * @property id TMDB season id
 */
@JvmRecord
data class TvSeasonAggregateCredits(
    @all:JsonProperty("cast")
    val cast: List<TvSeasonAggregateCastCredit> = emptyList(),
    @all:JsonProperty("crew")
    val crew: List<TvSeasonAggregateCrewCredit> = emptyList(),
    @all:JsonProperty("id")
    val id: Int,
) : TmdbModel
