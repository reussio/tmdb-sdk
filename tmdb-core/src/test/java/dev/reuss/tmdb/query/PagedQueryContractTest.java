package dev.reuss.tmdb.query;

import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery;
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery;
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieReviewsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieSimilarQuery;
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery;
import dev.reuss.tmdb.domain.search.query.*;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PagedQueryContractTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("pagedQueries")
    void validPageIsSerialized(PagedQueryCase queryCase) {
        PagedQuery<?> query = queryCase.create();

        query.page(2);

        assertInstanceOf(PagedQuery.class, query);
        assertEquals("2", query.toQueryParams().toMap().get("page"));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("pagedQueries")
    void rejectsInvalidPages(PagedQueryCase queryCase) {
        PagedQuery<?> query = queryCase.create();

        assertThrows(IllegalArgumentException.class, () -> query.page(0));
        assertThrows(IllegalArgumentException.class, () -> query.page(-1));
    }

    static Stream<PagedQueryCase> pagedQueries() {
        return Stream.of(
                new PagedQueryCase("ChangesQuery", ChangesQuery::create),
                new PagedQueryCase("MovieDiscoverQuery", MovieDiscoverQuery::create),
                new PagedQueryCase("TvDiscoverQuery", TvDiscoverQuery::create),
                new PagedQueryCase("MovieRecommendationsQuery", MovieRecommendationsQuery::create),
                new PagedQueryCase("MovieReviewsQuery", MovieReviewsQuery::create),
                new PagedQueryCase("MovieSimilarQuery", MovieSimilarQuery::create),
                new PagedQueryCase("PopularPeopleQuery", PopularPeopleQuery::create),
                new PagedQueryCase("SearchCollectionQuery", () -> SearchCollectionQuery.of("fight")),
                new PagedQueryCase("SearchCompanyQuery", () -> SearchCompanyQuery.of("warner")),
                new PagedQueryCase("SearchKeywordQuery", () -> SearchKeywordQuery.of("space")),
                new PagedQueryCase("SearchMovieQuery", () -> SearchMovieQuery.of("fight club")),
                new PagedQueryCase("SearchMultiQuery", () -> SearchMultiQuery.of("dark")),
                new PagedQueryCase("SearchPersonQuery", () -> SearchPersonQuery.of("brad pitt")),
                new PagedQueryCase("SearchTvQuery", () -> SearchTvQuery.of("dark")),
                new PagedQueryCase("TvSeriesDateListQuery", TvSeriesDateListQuery::create),
                new PagedQueryCase("TvSeriesListQuery", TvSeriesListQuery::create)
        );
    }

    private record PagedQueryCase(String name, QueryFactory factory) {

        PagedQuery<?> create() {
            return factory.create();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @FunctionalInterface
    private interface QueryFactory {
        PagedQuery<?> create();
    }
}
