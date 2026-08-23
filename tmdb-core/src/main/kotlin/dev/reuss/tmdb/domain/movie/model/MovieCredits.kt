package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CastCredit
import dev.reuss.tmdb.common.credit.CreditsResponse
import dev.reuss.tmdb.common.credit.CrewCredit

/**
 * Credits for a TMDB movie.
 *
 * @property id TMDB movie id
 * @property cast movie cast credits
 * @property crew movie crew credits
 */
@JvmRecord
data class MovieCredits(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("cast")
    override val cast: List<CastCredit> = emptyList(),
    @all:JsonProperty("crew")
    override val crew: List<CrewCredit> = emptyList(),
) : CreditsResponse<CastCredit, CrewCredit>,
    TmdbModel
