package dev.reuss.tmdb.domain.genres

import dev.reuss.tmdb.domain.genres.model.GenreList
import dev.reuss.tmdb.value.language.Language

/** Loads the official movie and TV genre lists maintained by TMDB. */
interface GenreService {
    /** Returns movie genres using the client's default language. */
    fun movies(): GenreList

    /** Returns movie genres localized in [language]. */
    fun movies(language: Language): GenreList

    /** Returns TV genres using the client's default language. */
    fun tv(): GenreList

    /** Returns TV genres localized in [language]. */
    fun tv(language: Language): GenreList
}
