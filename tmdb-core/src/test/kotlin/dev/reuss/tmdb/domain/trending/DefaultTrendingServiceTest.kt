package dev.reuss.tmdb.domain.trending

import dev.reuss.tmdb.domain.trending.model.TrendingAllResponse
import dev.reuss.tmdb.domain.trending.model.TrendingMovieResponse
import dev.reuss.tmdb.domain.trending.model.TrendingPersonResponse
import dev.reuss.tmdb.domain.trending.model.TrendingTimeWindow
import dev.reuss.tmdb.domain.trending.model.TrendingTvShowResponse
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultTrendingServiceTest {
    @Test
    fun all_shouldSupportTimeWindowAndLanguageOverloads() {
        assertRequest<TrendingAllResponse>("/trending/all/day") {
            DefaultTrendingService(it).all(TrendingTimeWindow.DAY)
        }
        assertRequest<TrendingAllResponse>(
            "/trending/all/week",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTrendingService(it).all(TrendingTimeWindow.WEEK, Languages.DE_DE)
        }
    }

    @Test
    fun movies_shouldSupportTimeWindowAndLanguageOverloads() {
        assertRequest<TrendingMovieResponse>("/trending/movie/day") {
            DefaultTrendingService(it).movies(TrendingTimeWindow.DAY)
        }
        assertRequest<TrendingMovieResponse>(
            "/trending/movie/week",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTrendingService(it).movies(TrendingTimeWindow.WEEK, Languages.DE_DE)
        }
    }

    @Test
    fun people_shouldSupportTimeWindowAndLanguageOverloads() {
        assertRequest<TrendingPersonResponse>("/trending/person/day") {
            DefaultTrendingService(it).people(TrendingTimeWindow.DAY)
        }
        assertRequest<TrendingPersonResponse>(
            "/trending/person/week",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTrendingService(it).people(TrendingTimeWindow.WEEK, Languages.DE_DE)
        }
    }

    @Test
    fun tv_shouldSupportTimeWindowAndLanguageOverloads() {
        assertRequest<TrendingTvShowResponse>("/trending/tv/day") {
            DefaultTrendingService(it).tv(TrendingTimeWindow.DAY)
        }
        assertRequest<TrendingTvShowResponse>(
            "/trending/tv/week",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTrendingService(it).tv(TrendingTimeWindow.WEEK, Languages.DE_DE)
        }
    }
}
