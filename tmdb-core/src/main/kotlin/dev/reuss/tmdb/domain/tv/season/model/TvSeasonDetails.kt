package dev.reuss.tmdb.domain.tv.season.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvSeasonImages

/**
 * Details for a TMDB TV season.
 *
 * @property objectId internal TMDB object id
 * @property airDate season air date
 * @property episodes season episodes
 * @property name season name
 * @property overview Localized overview when available.
 * @property id TMDB season id
 * @property posterPath TMDB image path for the poster.
 * @property seasonNumber Season number within its TV series.
 * @property voteAverage Average user rating reported by TMDB.
 * @property aggregateCredits Response appended through `append_to_response` when requested.
 * @property changes Response appended through `append_to_response` when requested.
 * @property credits Response appended through `append_to_response` when requested.
 * @property externalIds Response appended through `append_to_response` when requested.
 * @property images Response appended through `append_to_response` when requested.
 * @property translations Response appended through `append_to_response` when requested.
 * @property videos Response appended through `append_to_response` when requested.
 * @property watchProviders Response appended through `append_to_response` when requested.
 */
@JvmRecord
data class TvSeasonDetails(
    @all:JsonProperty("_id")
    val objectId: String?,
    @all:JsonProperty("air_date")
    val airDate: String?,
    @all:JsonProperty("episodes")
    val episodes: List<TvSeasonEpisode> = emptyList(),
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("overview")
    val overview: String?,
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("poster_path")
    val posterPath: String?,
    @all:JsonProperty("season_number")
    val seasonNumber: Int,
    @all:JsonProperty("vote_average")
    val voteAverage: Double,
    @all:JsonProperty("aggregate_credits")
    val aggregateCredits: TvSeasonAggregateCredits? = null,
    @all:JsonProperty("changes")
    val changes: TvSeasonChanges? = null,
    @all:JsonProperty("credits")
    val credits: TvSeasonCredits? = null,
    @all:JsonProperty("external_ids")
    val externalIds: ExternalIds? = null,
    @all:JsonProperty("images")
    val images: TvSeasonImages? = null,
    @all:JsonProperty("translations")
    val translations: TvSeasonTranslations? = null,
    @all:JsonProperty("videos")
    val videos: TvSeasonVideos? = null,
    @all:JsonProperty("watch/providers")
    val watchProviders: TvSeasonWatchProviders? = null,
) : TmdbModel
