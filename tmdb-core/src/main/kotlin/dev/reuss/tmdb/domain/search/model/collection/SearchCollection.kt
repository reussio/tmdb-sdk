package dev.reuss.tmdb.domain.search.model.collection

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Collection returned by TMDB collection search.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property backdropPath TMDB image path for the backdrop.
 * @property id TMDB collection id
 * @property name localized collection name
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalName original collection name
 * @property overview Localized overview when available.
 * @property posterPath TMDB image path for the poster.
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
    val posterPath: String?,
) : TmdbModel
