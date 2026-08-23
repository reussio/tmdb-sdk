package dev.reuss.tmdb.domain.genres

import dev.reuss.tmdb.domain.genres.model.GenreList
import dev.reuss.tmdb.value.language.Language

/**
 * Service for loading TMDB genre metadata.
 */

interface GenreService {
    fun movies(): GenreList

    fun movies(language: Language): GenreList

    fun tv(): GenreList

    fun tv(language: Language): GenreList
}
