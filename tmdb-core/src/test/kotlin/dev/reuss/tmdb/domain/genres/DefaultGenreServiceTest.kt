package dev.reuss.tmdb.domain.genres

import dev.reuss.tmdb.domain.genres.model.GenreList
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultGenreServiceTest {
    @Test
    fun genreMethods_shouldUseMovieAndTvPathsWithOptionalLanguage() {
        assertRequest<GenreList>("/genre/movie/list") {
            DefaultGenreService(it).movies()
        }
        assertRequest<GenreList>("/genre/movie/list", mapOf("language" to "de-DE")) {
            DefaultGenreService(it).movies(Languages.DE_DE)
        }
        assertRequest<GenreList>("/genre/tv/list") {
            DefaultGenreService(it).tv()
        }
        assertRequest<GenreList>("/genre/tv/list", mapOf("language" to "de-DE")) {
            DefaultGenreService(it).tv(Languages.DE_DE)
        }
    }
}
