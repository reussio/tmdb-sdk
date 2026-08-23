package dev.reuss.tmdb.domain.search.query

import dev.reuss.tmdb.query.PagedQuery
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SearchQueryContractTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("searchQueries")
    fun rejectsBlankQueryText(queryCase: SearchQueryCase) {
        assertThrows<IllegalArgumentException> {
            queryCase.create("")
        }

        assertThrows<IllegalArgumentException> {
            queryCase.create("   ")
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("searchQueries")
    fun serializesRequiredQueryText(queryCase: SearchQueryCase) {
        val query = queryCase.create(" Fight Club ")

        assertInstanceOf(SearchQuery::class.java, query)
        assertInstanceOf(PagedQuery::class.java, query)
        assertEquals("Fight Club", query.query)
        assertEquals("Fight Club", query.toQueryParams().toMap()["query"])
    }

    data class SearchQueryCase(
        val name: String,
        val factory: (String) -> SearchQuery
    ) {
        fun create(query: String): SearchQuery =
            factory(query)

        override fun toString(): String =
            name
    }

    companion object {

        @JvmStatic
        fun searchQueries(): List<SearchQueryCase> =
            listOf(
                SearchQueryCase("SearchCollectionQuery", SearchCollectionQuery::of),
                SearchQueryCase("SearchCompanyQuery", SearchCompanyQuery::of),
                SearchQueryCase("SearchKeywordQuery", SearchKeywordQuery::of),
                SearchQueryCase("SearchMovieQuery", SearchMovieQuery::of),
                SearchQueryCase("SearchMultiQuery", SearchMultiQuery::of),
                SearchQueryCase("SearchPersonQuery", SearchPersonQuery::of),
                SearchQueryCase("SearchTvQuery", SearchTvQuery::of)
            )
    }
}