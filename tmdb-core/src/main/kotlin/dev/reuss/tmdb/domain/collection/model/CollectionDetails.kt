package dev.reuss.tmdb.domain.collection.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * Details for a TMDB collection.
 *
 * @property id collection id
 * @property name collection name
 * @property originalLanguage ISO 639-1 code for the resource's original language.
 * @property originalName original collection name
 * @property overview Localized overview when available.
 * @property posterPath TMDB image path for the poster.
 * @property backdropPath TMDB image path for the backdrop.
 * @property parts movies that are part of the collection
 */
@JvmRecord
data class CollectionDetails(
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
    @all:JsonProperty("backdrop_path")
    val backdropPath: String?,
    @all:JsonProperty("parts")
    val parts: List<CollectionPart> = emptyList(),
) : TmdbModel
