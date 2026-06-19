package dev.reuss.tmdb.query;

import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery;
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery;
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery;
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery;
import dev.reuss.tmdb.domain.search.query.SearchTvQuery;
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery;
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QueryValidationTest {

    @Test
    void defaultQueriesOnlySerializeSetValues() {
        assertTrue(MovieRecommendationsQuery.create().toQueryParams().toMap().isEmpty());
        assertTrue(MovieDiscoverQuery.create().toQueryParams().toMap().isEmpty());
        assertEquals(Map.of("query", "Fight Club"), SearchMovieQuery.of(" Fight Club ").toQueryParams().toMap());
    }

    @Test
    void optionalValuesAreSerializedWhenSet() {
        Map<String, String> params = MovieRecommendationsQuery.create()
                .language(Language.of("de-DE"))
                .page(2)
                .toQueryParams()
                .toMap();

        assertEquals(Map.of("language", "de-DE", "page", "2"), params);
    }

    @Test
    void rejectsInvalidPagesAndYears() {
        assertThrows(IllegalArgumentException.class, () -> MovieRecommendationsQuery.create().page(0));
        assertThrows(IllegalArgumentException.class, () -> SearchMovieQuery.of("Fight Club").year("99"));
        assertThrows(IllegalArgumentException.class, () -> SearchMovieQuery.of("Fight Club").primaryReleaseYear("abcd"));
        assertThrows(IllegalArgumentException.class, () -> SearchTvQuery.of("Dark").year(999));
        assertThrows(IllegalArgumentException.class, () -> SearchTvQuery.of("Dark").firstAirDateYear(10000));
        assertThrows(IllegalArgumentException.class, () -> MovieDiscoverQuery.create().year(99));
        assertThrows(IllegalArgumentException.class, () -> MovieDiscoverQuery.create().primaryReleaseYear(10000));
        assertThrows(IllegalArgumentException.class, () -> TvDiscoverQuery.create().firstAirDateYear(999));
    }

    @Test
    void requiredSearchQueryMustNotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> SearchMovieQuery.of(null));
        assertThrows(IllegalArgumentException.class, () -> SearchMovieQuery.of(" "));
    }

    @Test
    void changesQueryValidatesPageAndDateRange() {
        assertThrows(IllegalArgumentException.class, () -> ChangesQuery.create().page(0));
        assertThrows(IllegalArgumentException.class, () -> ChangesQuery.create()
                .startDate(LocalDate.of(2024, 1, 10))
                .endDate(LocalDate.of(2024, 1, 9)));
        assertThrows(IllegalArgumentException.class, () -> ChangesQuery.create()
                .startDate(LocalDate.of(2024, 1, 1))
                .endDate(LocalDate.of(2024, 1, 16)));

        assertEquals(
                Map.of("start_date", "2024-01-01", "end_date", "2024-01-14", "page", "2"),
                ChangesQuery.create()
                        .startDate(LocalDate.of(2024, 1, 1))
                        .endDate(LocalDate.of(2024, 1, 14))
                        .page(2)
                        .toQueryParams()
                        .toMap()
        );
    }

    @Test
    void imageAndVideoQueriesSerializeLanguageFilters() {
        assertEquals(
                Map.of("language", "de-DE", "include_image_language", "de,en,null"),
                new ImageQuery(Language.of("de-DE"), "de,en,null").toQueryParams().toMap()
        );
        assertEquals(
                Map.of("language", "de-DE", "include_video_language", "de-DE,en-US"),
                TvSeasonVideosQuery.create()
                        .language(Language.of("de-DE"))
                        .includeVideoLanguage(Language.of("de-DE"), Language.of("en-US"))
                        .toQueryParams()
                        .toMap()
        );
        assertEquals(
                Map.of("include_video_language", "de-DE,en-US"),
                TvEpisodeVideosQuery.create()
                        .includeVideoLanguage(Language.of("de-DE"), Language.of("en-US"))
                        .toQueryParams()
                        .toMap()
        );
    }
}
