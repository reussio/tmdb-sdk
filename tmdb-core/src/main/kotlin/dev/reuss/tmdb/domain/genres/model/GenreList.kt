package dev.reuss.tmdb.domain.genres.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.genre.Genre

/**
 * List of TMDB genres.
 *
 * @property genres genres
 */
data class GenreList(
    @all:JsonProperty("genres")
    val genres: List<Genre>?
) : TmdbModel