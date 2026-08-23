package dev.reuss.tmdb.domain.discover

import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultDiscoverServiceTest {
    @Test
    fun movies_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<DiscoverMovieResponse>("/discover/movie") {
            DefaultDiscoverService(it).movies()
        }
        assertRequest<DiscoverMovieResponse>(
            "/discover/movie",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultDiscoverService(it).movies(
                MovieDiscoverQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun tv_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<DiscoverTvShowResponse>("/discover/tv") {
            DefaultDiscoverService(it).tv()
        }
        assertRequest<DiscoverTvShowResponse>(
            "/discover/tv",
            mapOf("language" to "de-DE", "page" to "3"),
        ) {
            DefaultDiscoverService(it).tv(
                TvDiscoverQuery.create().language(Languages.DE_DE).page(3),
            )
        }
    }
}
