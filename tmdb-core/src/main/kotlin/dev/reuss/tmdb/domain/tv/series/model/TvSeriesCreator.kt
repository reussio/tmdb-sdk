package dev.reuss.tmdb.domain.tv.series.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Creator of a TMDB TV series.
 *
 * @property id TMDB person id
 * @property creditId credit id
 * @property name creator name
 * @property gender TMDB gender code for the person.
 * @property profilePath TMDB image path for the profile image.
 */
@JvmRecord
data class TvSeriesCreator(
    @all:JsonProperty("id")
    val id: Int,
    @all:JsonProperty("credit_id")
    val creditId: String?,
    @all:JsonProperty("name")
    val name: String?,
    @all:JsonProperty("gender")
    val gender: Int,
    @all:JsonProperty("profile_path")
    val profilePath: String?,
) : TmdbModel
