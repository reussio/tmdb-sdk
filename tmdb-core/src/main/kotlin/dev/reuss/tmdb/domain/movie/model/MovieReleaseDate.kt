package dev.reuss.tmdb.domain.movie.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Release date entry for a movie.
 *
 * @property certification certification
 * @property descriptors certification descriptors
 * @property iso6391 ISO 639-1 language code
 * @property note release note
 * @property releaseDate release timestamp
 * @property type release type
 */
@JvmRecord
data class MovieReleaseDate(
    @all:JsonProperty("certification")
    val certification: String?,
    @all:JsonProperty("descriptors")
    val descriptors: List<String> = emptyList(),
    @all:JsonProperty("iso_639_1")
    val iso6391: String?,
    @all:JsonProperty("note")
    val note: String?,
    @all:JsonProperty("release_date")
    val releaseDate: String?,
    @all:JsonProperty("type")
    val type: MovieReleaseType,
) : TmdbModel
