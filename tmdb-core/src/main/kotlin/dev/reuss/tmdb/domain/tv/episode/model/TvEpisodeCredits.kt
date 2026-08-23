package dev.reuss.tmdb.domain.tv.episode.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CastCredit
import dev.reuss.tmdb.common.credit.CreditsResponse
import dev.reuss.tmdb.common.credit.CrewCredit
import dev.reuss.tmdb.common.credit.GuestStarCredit

/**
 * Credits for a TMDB TV episode.
 *
 * @property cast episode cast credits
 * @property crew episode crew credits
 * @property guestStars episode guest stars
 * @property id TMDB episode id
 */
@JvmRecord
data class TvEpisodeCredits(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("crew")
    override val crew: List<CrewCredit> = emptyList(),
    @all:JsonProperty("cast")
    override val cast: List<CastCredit> = emptyList(),
    @all:JsonProperty("guest_stars")
    val guestStars: List<GuestStarCredit> = emptyList(),
) : CreditsResponse<CastCredit, CrewCredit>,
    TmdbModel
