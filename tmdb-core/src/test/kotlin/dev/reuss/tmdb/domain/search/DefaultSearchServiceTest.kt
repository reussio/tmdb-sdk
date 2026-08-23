package dev.reuss.tmdb.domain.search

import dev.reuss.tmdb.domain.search.model.collection.SearchCollectionResponse
import dev.reuss.tmdb.domain.search.model.company.SearchCompanyResponse
import dev.reuss.tmdb.domain.search.model.keyword.SearchKeywordResponse
import dev.reuss.tmdb.domain.search.model.movie.SearchMovieResponse
import dev.reuss.tmdb.domain.search.model.multi.SearchMultiResponse
import dev.reuss.tmdb.domain.search.model.person.SearchPersonResponse
import dev.reuss.tmdb.domain.search.model.tv.SearchTvShowResponse
import dev.reuss.tmdb.domain.search.query.SearchCollectionQuery
import dev.reuss.tmdb.domain.search.query.SearchCompanyQuery
import dev.reuss.tmdb.domain.search.query.SearchKeywordQuery
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery
import dev.reuss.tmdb.domain.search.query.SearchMultiQuery
import dev.reuss.tmdb.domain.search.query.SearchPersonQuery
import dev.reuss.tmdb.domain.search.query.SearchTvQuery
import dev.reuss.tmdb.testsupport.assertRequest
import org.junit.jupiter.api.Test

class DefaultSearchServiceTest {
    @Test
    fun collections_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchCollectionResponse>("/search/collection", mapOf("query" to "Fight Club")) {
            DefaultSearchService(it).collections(" Fight Club ")
        }
        assertRequest<SearchCollectionResponse>(
            "/search/collection",
            mapOf("query" to "Fight Club", "page" to "2"),
        ) {
            DefaultSearchService(it).collections(SearchCollectionQuery.of("Fight Club").page(2))
        }
    }

    @Test
    fun companies_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchCompanyResponse>("/search/company", mapOf("query" to "Warner")) {
            DefaultSearchService(it).companies("Warner")
        }
        assertRequest<SearchCompanyResponse>(
            "/search/company",
            mapOf("query" to "Warner", "page" to "2"),
        ) {
            DefaultSearchService(it).companies(SearchCompanyQuery.of("Warner").page(2))
        }
    }

    @Test
    fun keywords_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchKeywordResponse>("/search/keyword", mapOf("query" to "space")) {
            DefaultSearchService(it).keywords("space")
        }
        assertRequest<SearchKeywordResponse>(
            "/search/keyword",
            mapOf("query" to "space", "page" to "2"),
        ) {
            DefaultSearchService(it).keywords(SearchKeywordQuery.of("space").page(2))
        }
    }

    @Test
    fun movies_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchMovieResponse>("/search/movie", mapOf("query" to "Fight Club")) {
            DefaultSearchService(it).movies("Fight Club")
        }
        assertRequest<SearchMovieResponse>(
            "/search/movie",
            mapOf("query" to "Fight Club", "year" to "1999"),
        ) {
            DefaultSearchService(it).movies(SearchMovieQuery.of("Fight Club").year(1999))
        }
    }

    @Test
    fun multi_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchMultiResponse>("/search/multi", mapOf("query" to "Dark")) {
            DefaultSearchService(it).multi("Dark")
        }
        assertRequest<SearchMultiResponse>(
            "/search/multi",
            mapOf("query" to "Dark", "include_adult" to "false"),
        ) {
            DefaultSearchService(it).multi(SearchMultiQuery.of("Dark").includeAdult(false))
        }
    }

    @Test
    fun people_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchPersonResponse>("/search/person", mapOf("query" to "Brad Pitt")) {
            DefaultSearchService(it).people("Brad Pitt")
        }
        assertRequest<SearchPersonResponse>(
            "/search/person",
            mapOf("query" to "Brad Pitt", "page" to "2"),
        ) {
            DefaultSearchService(it).people(SearchPersonQuery.of("Brad Pitt").page(2))
        }
    }

    @Test
    fun tv_shouldSupportStringAndQueryOverloads() {
        assertRequest<SearchTvShowResponse>("/search/tv", mapOf("query" to "Dark")) {
            DefaultSearchService(it).tv("Dark")
        }
        assertRequest<SearchTvShowResponse>(
            "/search/tv",
            mapOf("query" to "Dark", "first_air_date_year" to "2017"),
        ) {
            DefaultSearchService(it).tv(SearchTvQuery.of("Dark").firstAirDateYear(2017))
        }
    }
}
