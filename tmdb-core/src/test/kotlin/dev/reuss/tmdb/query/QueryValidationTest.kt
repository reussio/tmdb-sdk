package dev.reuss.tmdb.query

import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery
import dev.reuss.tmdb.domain.search.query.SearchTvQuery
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery
import dev.reuss.tmdb.value.language.Language
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class QueryValidationTest {
    @Test
    fun validateYear_shouldAcceptBoundsAndRejectInvalidStringYears() {
        QueryValidation.validateYear(1000, "Year")
        QueryValidation.validateYear(9999, "Year")
        QueryValidation.validateYear("2024", "Year")
        QueryValidation.validateYear(null as String?, "Year")
        QueryValidation.validateYear("   ", "Year")

        assertThrows<IllegalArgumentException> {
            QueryValidation.validateYear("year", "Year")
        }
        assertThrows<IllegalArgumentException> {
            QueryValidation.validateYear("999", "Year")
        }
    }

    @Test
    fun defaultQueriesOnlySerializeSetValues() {
        assertTrue(
            MovieRecommendationsQuery
                .create()
                .toQueryParams()
                .toMap()
                .isEmpty(),
        )

        assertTrue(
            MovieDiscoverQuery
                .create()
                .toQueryParams()
                .toMap()
                .isEmpty(),
        )

        assertEquals(
            mapOf("query" to "Fight Club"),
            SearchMovieQuery
                .of(" Fight Club ")
                .toQueryParams()
                .toMap(),
        )
    }

    @Test
    fun optionalValuesAreSerializedWhenSet() {
        val params =
            MovieRecommendationsQuery
                .create()
                .language(Language.of("de-DE"))
                .page(2)
                .toQueryParams()
                .toMap()

        assertEquals(
            mapOf(
                "language" to "de-DE",
                "page" to "2",
            ),
            params,
        )
    }

    @Test
    fun rejectsInvalidPagesAndYears() {
        assertThrows<IllegalArgumentException> {
            MovieRecommendationsQuery.create().page(0)
        }

        assertThrows<IllegalArgumentException> {
            SearchMovieQuery.of("Fight Club").year(99)
        }

        assertThrows<IllegalArgumentException> {
            SearchMovieQuery.of("Fight Club").primaryReleaseYear(10000)
        }

        assertThrows<IllegalArgumentException> {
            SearchTvQuery.of("Dark").year(999)
        }

        assertThrows<IllegalArgumentException> {
            SearchTvQuery.of("Dark").firstAirDateYear(10000)
        }

        assertThrows<IllegalArgumentException> {
            MovieDiscoverQuery.create().year(99)
        }

        assertThrows<IllegalArgumentException> {
            MovieDiscoverQuery.create().primaryReleaseYear(10000)
        }

        assertThrows<IllegalArgumentException> {
            TvDiscoverQuery.create().firstAirDateYear(999)
        }
    }

    @Test
    fun requiredSearchQueryMustNotBeBlank() {
        assertThrows<IllegalArgumentException> {
            SearchMovieQuery.of(" ")
        }
    }

    @Test
    fun changesQueryValidatesPageAndDateRange() {
        assertThrows<IllegalArgumentException> {
            ChangesQuery.create().page(0)
        }

        assertThrows<IllegalArgumentException> {
            ChangesQuery
                .create()
                .startDate(LocalDate.of(2024, 1, 10))
                .endDate(LocalDate.of(2024, 1, 9))
        }

        assertThrows<IllegalArgumentException> {
            ChangesQuery
                .create()
                .startDate(LocalDate.of(2024, 1, 1))
                .endDate(LocalDate.of(2024, 1, 16))
        }

        assertEquals(
            mapOf(
                "start_date" to "2024-01-01",
                "end_date" to "2024-01-15",
                "page" to "2",
            ),
            ChangesQuery
                .create()
                .startDate(LocalDate.of(2024, 1, 1))
                .endDate(LocalDate.of(2024, 1, 15))
                .page(2)
                .toQueryParams()
                .toMap(),
        )
    }

    @Test
    fun imageAndVideoQueriesSerializeLanguageFilters() {
        assertEquals(
            mapOf(
                "language" to "de-DE",
                "include_image_language" to "de,en,null",
            ),
            ImageQuery(
                Language.of("de-DE"),
                "de,en,null",
            ).toQueryParams().toMap(),
        )

        assertEquals(
            mapOf(
                "language" to "de-DE",
                "include_video_language" to "de-DE,en-US",
            ),
            TvSeasonVideosQuery
                .create()
                .language(Language.of("de-DE"))
                .includeVideoLanguage(
                    Language.of("de-DE"),
                    Language.of("en-US"),
                ).toQueryParams()
                .toMap(),
        )

        assertEquals(
            mapOf(
                "include_video_language" to "de-DE,en-US",
            ),
            TvEpisodeVideosQuery
                .create()
                .includeVideoLanguage(
                    Language.of("de-DE"),
                    Language.of("en-US"),
                ).toQueryParams()
                .toMap(),
        )
    }
}
