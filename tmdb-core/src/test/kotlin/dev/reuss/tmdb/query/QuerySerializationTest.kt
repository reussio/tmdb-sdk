package dev.reuss.tmdb.query

import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverSortBy
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery
import dev.reuss.tmdb.domain.discover.query.TvDiscoverSortBy
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
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesVideosQuery
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class QuerySerializationTest {
    @Test
    fun toQueryParams_shouldSerializeEveryConfiguredMovieDiscoverFilter() {
        val params =
            MovieDiscoverQuery
                .create()
                .certification("FSK 12")
                .certificationGte("FSK 6")
                .certificationLte("FSK 16")
                .certificationCountry("DE")
                .includeAdult(false)
                .includeVideo(true)
                .language(Languages.DE_DE)
                .page(2)
                .primaryReleaseYear(2024)
                .primaryReleaseDateGte(LocalDate.of(2024, 1, 1))
                .primaryReleaseDateLte(LocalDate.of(2024, 12, 31))
                .region(Regions.DE)
                .releaseDateGte(LocalDate.of(2023, 1, 1))
                .releaseDateLte(LocalDate.of(2025, 1, 1))
                .sortBy(MovieDiscoverSortBy.POPULARITY_DESC)
                .voteAverageGte(5.5)
                .voteAverageLte(9.5)
                .voteCountGte(100.0)
                .voteCountLte(1000.0)
                .watchRegion(Regions.DE)
                .withCast("287")
                .withCompanies("420")
                .withCrew("525")
                .withGenres("18")
                .withKeywords("9715")
                .withOriginCountry("DE")
                .withOriginalLanguage("de")
                .withPeople("287|525")
                .withReleaseType("2|3")
                .withRuntimeGte(80)
                .withRuntimeLte(180)
                .withWatchMonetizationTypes("flatrate")
                .withWatchProviders("8")
                .withoutCompanies("999")
                .withoutGenres("27")
                .withoutKeywords("666")
                .withoutWatchProviders("9")
                .year(2024)
                .toQueryParams()
                .toMap()

        assertEquals(
            mapOf(
                "certification" to "FSK 12",
                "certification.gte" to "FSK 6",
                "certification.lte" to "FSK 16",
                "certification_country" to "DE",
                "include_adult" to "false",
                "include_video" to "true",
                "language" to "de-DE",
                "page" to "2",
                "primary_release_year" to "2024",
                "primary_release_date.gte" to "2024-01-01",
                "primary_release_date.lte" to "2024-12-31",
                "region" to "DE",
                "release_date.gte" to "2023-01-01",
                "release_date.lte" to "2025-01-01",
                "sort_by" to "popularity.desc",
                "vote_average.gte" to "5.5",
                "vote_average.lte" to "9.5",
                "vote_count.gte" to "100.0",
                "vote_count.lte" to "1000.0",
                "watch_region" to "DE",
                "with_cast" to "287",
                "with_companies" to "420",
                "with_crew" to "525",
                "with_genres" to "18",
                "with_keywords" to "9715",
                "with_origin_country" to "DE",
                "with_original_language" to "de",
                "with_people" to "287|525",
                "with_release_type" to "2|3",
                "with_runtime.gte" to "80",
                "with_runtime.lte" to "180",
                "with_watch_monetization_types" to "flatrate",
                "with_watch_providers" to "8",
                "without_companies" to "999",
                "without_genres" to "27",
                "without_keywords" to "666",
                "without_watch_providers" to "9",
                "year" to "2024",
            ),
            params,
        )
    }

    @Test
    fun toQueryParams_shouldSerializeEveryConfiguredTvDiscoverFilter() {
        val params =
            TvDiscoverQuery
                .create()
                .airDateGte(LocalDate.of(2024, 1, 1))
                .airDateLte(LocalDate.of(2024, 12, 31))
                .firstAirDateYear(2024)
                .firstAirDateGte(LocalDate.of(2023, 1, 1))
                .firstAirDateLte(LocalDate.of(2025, 1, 1))
                .includeAdult(false)
                .includeNullFirstAirDates(true)
                .language(Languages.DE_DE)
                .page(3)
                .screenedTheatrically(true)
                .sortBy(TvDiscoverSortBy.FIRST_AIR_DATE_DESC)
                .timezone("Europe/Berlin")
                .voteAverageGte(5.5)
                .voteAverageLte(9.5)
                .voteCountGte(100.0)
                .voteCountLte(1000.0)
                .watchRegion(Regions.DE)
                .withCompanies("420")
                .withGenres("18")
                .withKeywords("9715")
                .withNetworks(49)
                .withOriginCountry("DE")
                .withOriginalLanguage("de")
                .withRuntimeGte(20)
                .withRuntimeLte(90)
                .withStatus("0|2")
                .withWatchMonetizationTypes("flatrate")
                .withWatchProviders("8")
                .withoutCompanies("999")
                .withoutGenres("27")
                .withoutKeywords("666")
                .withoutWatchProviders("9")
                .withType("0|4")
                .toQueryParams()
                .toMap()

        assertEquals(
            mapOf(
                "air_date.gte" to "2024-01-01",
                "air_date.lte" to "2024-12-31",
                "first_air_date_year" to "2024",
                "first_air_date.gte" to "2023-01-01",
                "first_air_date.lte" to "2025-01-01",
                "include_adult" to "false",
                "include_null_first_air_dates" to "true",
                "language" to "de-DE",
                "page" to "3",
                "screened_theatrically" to "true",
                "sort_by" to "first_air_date.desc",
                "timezone" to "Europe/Berlin",
                "vote_average.gte" to "5.5",
                "vote_average.lte" to "9.5",
                "vote_count.gte" to "100.0",
                "vote_count.lte" to "1000.0",
                "watch_region" to "DE",
                "with_companies" to "420",
                "with_genres" to "18",
                "with_keywords" to "9715",
                "with_networks" to "49",
                "with_origin_country" to "DE",
                "with_original_language" to "de",
                "with_runtime.gte" to "20",
                "with_runtime.lte" to "90",
                "with_status" to "0|2",
                "with_watch_monetization_types" to "flatrate",
                "with_watch_providers" to "8",
                "without_companies" to "999",
                "without_genres" to "27",
                "without_keywords" to "666",
                "without_watch_providers" to "9",
                "with_type" to "0|4",
            ),
            params,
        )
    }

    @Test
    fun movieListQueries_shouldSerializeTheirSupportedOptions() {
        val regionalQueries =
            listOf(
                MovieNowPlayingQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
                MoviePopularQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
                MovieTopRatedQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
                MovieUpcomingQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
            )
        val pagedQueries =
            listOf(
                MovieRecommendationsQuery.create().language(Languages.DE_DE).page(2),
                MovieReviewsQuery.create().language(Languages.DE_DE).page(2),
                MovieSimilarQuery.create().language(Languages.DE_DE).page(2),
            )

        regionalQueries.forEach { query ->
            assertEquals(
                mapOf("language" to "de-DE", "page" to "2", "region" to "DE"),
                query.toQueryParams().toMap(),
            )
        }
        pagedQueries.forEach { query ->
            assertEquals(
                mapOf("language" to "de-DE", "page" to "2"),
                query.toQueryParams().toMap(),
            )
        }
    }

    @Test
    fun searchQueries_shouldSerializeEndpointSpecificOptions() {
        assertEquals(
            mapOf(
                "query" to "Fight Club",
                "include_adult" to "false",
                "language" to "de-DE",
                "page" to "2",
                "region" to "DE",
            ),
            SearchCollectionQuery
                .of("Fight Club")
                .includeAdult(false)
                .language(Languages.DE_DE)
                .page(2)
                .region(Regions.DE)
                .toQueryParams()
                .toMap(),
        )
        assertEquals(
            mapOf(
                "query" to "Fight Club",
                "include_adult" to "true",
                "language" to "de-DE",
                "primary_release_year" to "1999",
                "page" to "2",
                "region" to "DE",
                "year" to "2000",
            ),
            SearchMovieQuery
                .of("Fight Club")
                .includeAdult(true)
                .language(Languages.DE_DE)
                .primaryReleaseYear(1999)
                .page(2)
                .region(Regions.DE)
                .year(2000)
                .toQueryParams()
                .toMap(),
        )
        assertEquals(
            mapOf(
                "query" to "Dark",
                "first_air_date_year" to "2017",
                "include_adult" to "false",
                "language" to "de-DE",
                "page" to "3",
                "year" to "2018",
            ),
            SearchTvQuery
                .of("Dark")
                .firstAirDateYear(2017)
                .includeAdult(false)
                .language(Languages.DE_DE)
                .page(3)
                .year(2018)
                .toQueryParams()
                .toMap(),
        )

        listOf(
            SearchMultiQuery
                .of("query")
                .includeAdult(false)
                .language(Languages.DE_DE)
                .page(2),
            SearchPersonQuery
                .of("query")
                .includeAdult(false)
                .language(Languages.DE_DE)
                .page(2),
        ).forEach { query ->
            assertEquals(
                mapOf(
                    "query" to "query",
                    "include_adult" to "false",
                    "language" to "de-DE",
                    "page" to "2",
                ),
                query.toQueryParams().toMap(),
            )
        }

        listOf(
            SearchCompanyQuery.of("query").page(2),
            SearchKeywordQuery.of("query").page(2),
        ).forEach { query ->
            assertEquals(
                mapOf("query" to "query", "page" to "2"),
                query.toQueryParams().toMap(),
            )
        }
    }

    @Test
    fun commonQueries_shouldSerializeConfiguredOptionsAndIgnoreClearedOptions() {
        assertEquals(
            mapOf("language" to "de-DE"),
            CollectionDetailsQuery.of(Languages.DE_DE).toQueryParams().toMap(),
        )
        assertTrue(
            CollectionDetailsQuery
                .empty()
                .toQueryParams()
                .toMap()
                .isEmpty(),
        )
        assertEquals(
            mapOf("language" to "de-DE", "page" to "2"),
            PopularPeopleQuery
                .create()
                .language(Languages.DE_DE)
                .page(2)
                .toQueryParams()
                .toMap(),
        )
        assertEquals(
            mapOf("language" to "de-DE", "page" to "2"),
            TvSeriesListQuery
                .create()
                .language(Languages.DE_DE)
                .page(2)
                .toQueryParams()
                .toMap(),
        )
        assertEquals(
            mapOf("language" to "de-DE", "page" to "2", "timezone" to "Europe/Berlin"),
            TvSeriesDateListQuery
                .create()
                .language(Languages.DE_DE)
                .page(2)
                .timezone("Europe/Berlin")
                .toQueryParams()
                .toMap(),
        )
        assertTrue(
            MoviePopularQuery
                .create()
                .language(Languages.DE_DE)
                .language(null)
                .page(2)
                .page(null)
                .region(Regions.DE)
                .region(null)
                .toQueryParams()
                .toMap()
                .isEmpty(),
        )
    }

    @Test
    fun videoQueries_shouldSerializeLanguagesAndDefensivelyCopyInputLists() {
        val languages = mutableListOf(Languages.DE_DE)
        val episodeQuery = TvEpisodeVideosQuery.create().includeVideoLanguage(languages)
        languages += Languages.EN_US

        assertEquals(
            mapOf("include_video_language" to "de-DE"),
            episodeQuery.toQueryParams().toMap(),
        )
        assertEquals(
            mapOf("language" to "de-DE", "include_video_language" to "de-DE,en-US"),
            TvSeasonVideosQuery
                .create()
                .language(Languages.DE_DE)
                .includeVideoLanguage(Languages.DE_DE, Languages.EN_US)
                .toQueryParams()
                .toMap(),
        )
        assertEquals(
            mapOf("include_video_language" to "de-DE,en-US"),
            TvSeriesVideosQuery
                .create()
                .includeVideoLanguage(listOf(Languages.DE_DE, Languages.EN_US))
                .toQueryParams()
                .toMap(),
        )
        assertTrue(
            TvEpisodeVideosQuery
                .create()
                .includeVideoLanguage(emptyList())
                .toQueryParams()
                .toMap()
                .isEmpty(),
        )
    }

    @Test
    fun imageQuery_shouldExposeFactoriesAndRejectBlankLanguageList() {
        assertTrue(
            ImageQuery
                .none()
                .toQueryParams()
                .toMap()
                .isEmpty(),
        )
        assertEquals(
            mapOf("language" to "de-DE"),
            ImageQuery.language(Languages.DE_DE).toQueryParams().toMap(),
        )
        assertEquals(
            mapOf("include_image_language" to "de,en,null"),
            ImageQuery.includeImageLanguage("de,en,null").toQueryParams().toMap(),
        )

        assertThrows<IllegalArgumentException> {
            ImageQuery.includeImageLanguage("   ")
        }
    }

    @Test
    fun discoverSortValues_shouldMatchTmdbWireContract() {
        assertEquals(
            listOf(
                "original_title.asc",
                "original_title.desc",
                "popularity.asc",
                "popularity.desc",
                "revenue.asc",
                "revenue.desc",
                "primary_release_date.asc",
                "primary_release_date.desc",
                "title.asc",
                "title.desc",
                "vote_average.asc",
                "vote_average.desc",
                "vote_count.asc",
                "vote_count.desc",
            ),
            MovieDiscoverSortBy.entries.map { it.value },
        )
        assertEquals(
            listOf(
                "first_air_date.asc",
                "first_air_date.desc",
                "name.asc",
                "name.desc",
                "original_name.asc",
                "original_name.desc",
                "popularity.asc",
                "popularity.desc",
                "vote_average.asc",
                "vote_average.desc",
                "vote_count.asc",
                "vote_count.desc",
            ),
            TvDiscoverSortBy.entries.map { it.value },
        )
    }
}
