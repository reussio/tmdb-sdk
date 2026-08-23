package dev.reuss.tmdb.query

import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery
import dev.reuss.tmdb.domain.movie.query.MovieNowPlayingQuery
import dev.reuss.tmdb.domain.movie.query.MoviePopularQuery
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery
import dev.reuss.tmdb.domain.movie.query.MovieReviewsQuery
import dev.reuss.tmdb.domain.movie.query.MovieSimilarQuery
import dev.reuss.tmdb.domain.movie.query.MovieTopRatedQuery
import dev.reuss.tmdb.domain.movie.query.MovieUpcomingQuery
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery
import dev.reuss.tmdb.domain.search.query.SearchCollectionQuery
import dev.reuss.tmdb.domain.search.query.SearchCompanyQuery
import dev.reuss.tmdb.domain.search.query.SearchKeywordQuery
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery
import dev.reuss.tmdb.domain.search.query.SearchMultiQuery
import dev.reuss.tmdb.domain.search.query.SearchPersonQuery
import dev.reuss.tmdb.domain.search.query.SearchTvQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PagedQueryContractTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("pagedQueries")
    fun validPageIsSerialized(queryCase: PagedQueryCase) {
        val query = queryCase.create()

        query.page(2)

        assertInstanceOf(PagedQuery::class.java, query)
        assertEquals("2", query.toQueryParams().toMap()["page"])
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("pagedQueries")
    fun rejectsInvalidPages(queryCase: PagedQueryCase) {
        val query = queryCase.create()

        assertThrows<IllegalArgumentException> {
            query.page(0)
        }

        assertThrows<IllegalArgumentException> {
            query.page(-1)
        }
    }

    data class PagedQueryCase(
        val name: String,
        val factory: () -> PagedQuery<*>,
    ) {
        fun create(): PagedQuery<*> = factory()

        override fun toString(): String = name
    }

    companion object {
        @JvmStatic
        fun pagedQueries(): List<PagedQueryCase> =
            listOf(
                PagedQueryCase("ChangesQuery") { ChangesQuery.create() },
                PagedQueryCase("MovieDiscoverQuery") { MovieDiscoverQuery.create() },
                PagedQueryCase("TvDiscoverQuery") { TvDiscoverQuery.create() },
                PagedQueryCase("MovieNowPlayingQuery") { MovieNowPlayingQuery.create() },
                PagedQueryCase("MoviePopularQuery") { MoviePopularQuery.create() },
                PagedQueryCase("MovieTopRatedQuery") { MovieTopRatedQuery.create() },
                PagedQueryCase("MovieUpcomingQuery") { MovieUpcomingQuery.create() },
                PagedQueryCase("MovieRecommendationsQuery") {
                    MovieRecommendationsQuery.create()
                },
                PagedQueryCase("MovieReviewsQuery") { MovieReviewsQuery.create() },
                PagedQueryCase("MovieSimilarQuery") { MovieSimilarQuery.create() },
                PagedQueryCase("PopularPeopleQuery") { PopularPeopleQuery.create() },
                PagedQueryCase("SearchCollectionQuery") {
                    SearchCollectionQuery.of("fight")
                },
                PagedQueryCase("SearchCompanyQuery") {
                    SearchCompanyQuery.of("warner")
                },
                PagedQueryCase("SearchKeywordQuery") {
                    SearchKeywordQuery.of("space")
                },
                PagedQueryCase("SearchMovieQuery") {
                    SearchMovieQuery.of("fight club")
                },
                PagedQueryCase("SearchMultiQuery") {
                    SearchMultiQuery.of("dark")
                },
                PagedQueryCase("SearchPersonQuery") {
                    SearchPersonQuery.of("brad pitt")
                },
                PagedQueryCase("SearchTvQuery") {
                    SearchTvQuery.of("dark")
                },
                PagedQueryCase("TvSeriesDateListQuery") {
                    TvSeriesDateListQuery.create()
                },
                PagedQueryCase("TvSeriesListQuery") {
                    TvSeriesListQuery.create()
                },
            )
    }
}
