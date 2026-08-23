package dev.reuss.tmdb.domain.credits.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TV season information included in a TMDB credit response.
 *
 * @property airDate season air date
 * @property episodeCount Number of associated episodes.
 * @property id TMDB season id
 * @property name season name
 * @property overview Localized overview when available.
 * @property posterPath TMDB image path for the poster.
 * @property seasonNumber Season number within its TV series.
 * @property showId TV series id
 */
@JvmRecord
data class CreditSeason(
    @all:JsonProperty("air_date")
    val airDate: String?,
    @all:JsonProperty("episode_count")
    val episodeCount: Int,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("season_number")
    val seasonNumber: Int,
    @all:JsonProperty("show_id")
    val showId: Int,
) : TmdbModel
