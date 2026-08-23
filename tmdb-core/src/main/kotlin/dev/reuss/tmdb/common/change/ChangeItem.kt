package dev.reuss.tmdb.common.change

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Single change item for a TMDB resource field.
 *
 * @property id            change item id
 * @property action        change action
 * @property time          change timestamp
 * @property iso6391 ISO 639-1 language code associated with the value.
 * @property iso31661 ISO 3166-1 country code associated with the value.
 * @property value         changed value
 * @property originalValue previous value, if provided by the endpoint
 */
@JvmRecord
data class ChangeItem(
    @all:JsonProperty("id")
    val id: String?,
    @all:JsonProperty("action")
    val action: String?,
    @all:JsonProperty("time")
    val time: String?,
    @all:JsonProperty("iso_639_1")
    val iso6391: String?,
    @all:JsonProperty("iso_3166_1")
    val iso31661: String?,
    @all:JsonProperty("value")
    val value: Any?,
    @all:JsonProperty("original_value")
    val originalValue: Any?,
) : TmdbModel
