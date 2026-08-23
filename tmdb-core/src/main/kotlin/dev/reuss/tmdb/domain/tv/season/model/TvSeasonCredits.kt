package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CastCredit
import dev.reuss.tmdb.common.credit.CreditsResponse
import dev.reuss.tmdb.common.credit.CrewCredit

/**
 * Credits for a TMDB TV season.
 *
 * @property id TMDB season id
 * @property cast cast credits
 * @property crew crew credits
 */
@JvmRecord
data class TvSeasonCredits(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("cast")
    override val cast: List<CastCredit> = emptyList(),

    @all:JsonProperty("crew")
    override val crew: List<CrewCredit> = emptyList()
) : CreditsResponse<CastCredit, CrewCredit>, TmdbModel
