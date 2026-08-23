package dev.reuss.tmdb.domain.genres

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.genres.model.GenreList
import dev.reuss.tmdb.value.language.Language

/**
 * Default [GenreService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultGenreService(
    private val httpClient: TmdbHttpClient
) : GenreService {

    override fun movies(): GenreList =
        httpClient.get(
            TmdbRequest.get(GenrePaths.movieGenres()),
            GenreList::class.java
        )

    override fun movies(language: Language): GenreList =
        httpClient.get(
            TmdbRequest.get(
                GenrePaths.movieGenres(),
                QueryParams.create().add("language", language)
            ),
            GenreList::class.java
        )

    override fun tv(): GenreList =
        httpClient.get(
            TmdbRequest.get(GenrePaths.tvSeriesGenres()),
            GenreList::class.java
        )

    override fun tv(language: Language): GenreList =
        httpClient.get(
            TmdbRequest.get(
                GenrePaths.tvSeriesGenres(),
                QueryParams.create().add("language", language)
            ),
            GenreList::class.java
        )
}
