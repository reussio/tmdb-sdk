package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SearchQueryContractTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("searchQueries")
    void rejectsBlankQueryText(SearchQueryCase queryCase) {
        assertThrows(IllegalArgumentException.class, () -> queryCase.create(""));
        assertThrows(IllegalArgumentException.class, () -> queryCase.create("   "));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("searchQueries")
    void serializesRequiredQueryText(SearchQueryCase queryCase) {
        SearchQuery query = queryCase.create(" Fight Club ");

        assertInstanceOf(SearchQuery.class, query);
        assertInstanceOf(PagedQuery.class, query);
        assertEquals("Fight Club", query.query());
        assertEquals("Fight Club", query.toQueryParams().toMap().get("query"));
    }

    static Stream<SearchQueryCase> searchQueries() {
        return Stream.of(
                new SearchQueryCase("SearchCollectionQuery", SearchCollectionQuery::of),
                new SearchQueryCase("SearchCompanyQuery", SearchCompanyQuery::of),
                new SearchQueryCase("SearchKeywordQuery", SearchKeywordQuery::of),
                new SearchQueryCase("SearchMovieQuery", SearchMovieQuery::of),
                new SearchQueryCase("SearchMultiQuery", SearchMultiQuery::of),
                new SearchQueryCase("SearchPersonQuery", SearchPersonQuery::of),
                new SearchQueryCase("SearchTvQuery", SearchTvQuery::of)
        );
    }

    private record SearchQueryCase(String name, SearchQueryFactory factory) {

        SearchQuery create(String query) {
            return factory.create(query);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @FunctionalInterface
    private interface SearchQueryFactory {
        SearchQuery create(String query);
    }
}
