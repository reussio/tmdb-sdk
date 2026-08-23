package dev.reuss.tmdb.domain.search.model.collection

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Collection returned by TMDB collection search.
 *
 * @property adult whether the collection is marked as adult
 * @property backdropPath backdrop image path
 * @property id TMDB collection id
 * @property name localized collection name
 * @property originalLanguage original language code
 * @property originalName original collection name
 * @property overview collection overview
 * @property posterPath poster image path
 */
@JvmRecord
data class SearchCollection(
    @all:JsonProperty("adult")
    val adult: Boolean,

    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("original_language")
    val originalLanguage: String?,

    @all:JsonProperty("original_name")
    val originalName: String?,

    @all:JsonProperty("overview")
    val overview: String?,

    @all:JsonProperty("poster_path")
    val posterPath: String?
) : TmdbModel