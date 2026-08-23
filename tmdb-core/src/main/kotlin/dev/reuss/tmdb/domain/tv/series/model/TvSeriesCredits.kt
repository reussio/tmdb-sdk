package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CastCredit
import dev.reuss.tmdb.common.credit.CreditsResponse
import dev.reuss.tmdb.common.credit.CrewCredit

/**
 * Latest season credits for a TMDB TV series.
 *
 * @property id TMDB TV series id
 * @property cast cast credits
 * @property crew crew credits
 */
@JvmRecord
data class TvSeriesCredits(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("cast")
    override val cast: List<CastCredit> = emptyList(),
    @all:JsonProperty("crew")
    override val crew: List<CrewCredit> = emptyList(),
) : CreditsResponse<CastCredit, CrewCredit>,
    TmdbModel
