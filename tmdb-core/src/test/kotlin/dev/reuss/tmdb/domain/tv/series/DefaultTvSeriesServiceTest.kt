package dev.reuss.tmdb.domain.tv.series

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvShowImages
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesAggregateCredits
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesAlternativeTitles
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesChanges
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesContentRatings
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesCredits
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesDetails
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesEpisodeGroups
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesKeywords
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesListResponse
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesRecommendations
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesReviews
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesScreenedTheatrically
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesSimilar
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesTranslations
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesVideos
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesWatchProviders
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesVideosQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DefaultTvSeriesServiceTest {
    private val seriesId = TvShowId.of(1399)

    @Test
    fun airingToday_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesListResponse>("/tv/airing_today") {
            DefaultTvSeriesService(it).airingToday()
        }
        assertRequest<TvSeriesListResponse>("/tv/airing_today", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).airingToday(Languages.DE_DE)
        }
        assertRequest<TvSeriesListResponse>(
            "/tv/airing_today",
            mapOf("language" to "de-DE", "page" to "2", "timezone" to "Europe/Berlin"),
        ) {
            DefaultTvSeriesService(it).airingToday(
                TvSeriesDateListQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .timezone("Europe/Berlin"),
            )
        }
    }

    @Test
    fun onTheAir_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesListResponse>("/tv/on_the_air") {
            DefaultTvSeriesService(it).onTheAir()
        }
        assertRequest<TvSeriesListResponse>("/tv/on_the_air", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).onTheAir(Languages.DE_DE)
        }
        assertRequest<TvSeriesListResponse>(
            "/tv/on_the_air",
            mapOf("language" to "de-DE", "page" to "2", "timezone" to "Europe/Berlin"),
        ) {
            DefaultTvSeriesService(it).onTheAir(
                TvSeriesDateListQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .timezone("Europe/Berlin"),
            )
        }
    }

    @Test
    fun popular_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesListResponse>("/tv/popular") {
            DefaultTvSeriesService(it).popular()
        }
        assertRequest<TvSeriesListResponse>("/tv/popular", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).popular(Languages.DE_DE)
        }
        assertRequest<TvSeriesListResponse>(
            "/tv/popular",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultTvSeriesService(it).popular(
                TvSeriesListQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun topRated_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesListResponse>("/tv/top_rated") {
            DefaultTvSeriesService(it).topRated()
        }
        assertRequest<TvSeriesListResponse>("/tv/top_rated", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).topRated(Languages.DE_DE)
        }
        assertRequest<TvSeriesListResponse>(
            "/tv/top_rated",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultTvSeriesService(it).topRated(
                TvSeriesListQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun details_shouldSupportLanguageAndAppendOverloads() {
        val append = AppendToResponse.of(TvSeriesAppend.CREDITS, TvSeriesAppend.VIDEOS)

        assertRequest<TvSeriesDetails>("/tv/1399") {
            DefaultTvSeriesService(it).details(seriesId)
        }
        assertRequest<TvSeriesDetails>("/tv/1399", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).details(seriesId, Languages.DE_DE)
        }
        assertRequest<TvSeriesDetails>(
            "/tv/1399",
            mapOf("append_to_response" to "credits,videos"),
        ) {
            DefaultTvSeriesService(it).details(seriesId, append)
        }
        assertRequest<TvSeriesDetails>(
            "/tv/1399",
            mapOf("language" to "de-DE", "append_to_response" to "credits,videos"),
        ) {
            DefaultTvSeriesService(it).details(seriesId, Languages.DE_DE, append)
        }
    }

    @Test
    fun aggregateCredits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<TvSeriesAggregateCredits>("/tv/1399/aggregate_credits") {
            DefaultTvSeriesService(it).aggregateCredits(seriesId)
        }
        assertRequest<TvSeriesAggregateCredits>(
            "/tv/1399/aggregate_credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeriesService(it).aggregateCredits(seriesId, Languages.DE_DE)
        }
    }

    @Test
    fun changes_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<TvSeriesChanges>("/tv/1399/changes") {
            DefaultTvSeriesService(it).changes(seriesId)
        }
        assertRequest<TvSeriesChanges>(
            "/tv/1399/changes",
            mapOf("end_date" to "2024-01-14", "start_date" to "2024-01-01"),
        ) {
            DefaultTvSeriesService(it).changes(
                seriesId,
                ChangesQuery
                    .create()
                    .startDate(LocalDate.of(2024, 1, 1))
                    .endDate(LocalDate.of(2024, 1, 14)),
            )
        }
    }

    @Test
    fun credits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<TvSeriesCredits>("/tv/1399/credits") {
            DefaultTvSeriesService(it).credits(seriesId)
        }
        assertRequest<TvSeriesCredits>("/tv/1399/credits", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).credits(seriesId, Languages.DE_DE)
        }
    }

    @Test
    fun recommendations_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesRecommendations>("/tv/1399/recommendations") {
            DefaultTvSeriesService(it).recommendations(seriesId)
        }
        assertRequest<TvSeriesRecommendations>(
            "/tv/1399/recommendations",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeriesService(it).recommendations(seriesId, Languages.DE_DE)
        }
        assertRequest<TvSeriesRecommendations>(
            "/tv/1399/recommendations",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultTvSeriesService(it).recommendations(
                seriesId,
                TvSeriesListQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun reviews_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesReviews>("/tv/1399/reviews") {
            DefaultTvSeriesService(it).reviews(seriesId)
        }
        assertRequest<TvSeriesReviews>("/tv/1399/reviews", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).reviews(seriesId, Languages.DE_DE)
        }
        assertRequest<TvSeriesReviews>(
            "/tv/1399/reviews",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultTvSeriesService(it).reviews(
                seriesId,
                TvSeriesListQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun similar_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesSimilar>("/tv/1399/similar") {
            DefaultTvSeriesService(it).similar(seriesId)
        }
        assertRequest<TvSeriesSimilar>("/tv/1399/similar", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).similar(seriesId, Languages.DE_DE)
        }
        assertRequest<TvSeriesSimilar>(
            "/tv/1399/similar",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultTvSeriesService(it).similar(
                seriesId,
                TvSeriesListQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun videos_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeriesVideos>("/tv/1399/videos") {
            DefaultTvSeriesService(it).videos(seriesId)
        }
        assertRequest<TvSeriesVideos>("/tv/1399/videos", mapOf("language" to "de-DE")) {
            DefaultTvSeriesService(it).videos(seriesId, Languages.DE_DE)
        }
        assertRequest<TvSeriesVideos>(
            "/tv/1399/videos",
            mapOf("language" to "de-DE", "include_video_language" to "de-DE,en-US"),
        ) {
            DefaultTvSeriesService(it).videos(
                seriesId,
                TvSeriesVideosQuery
                    .create()
                    .language(Languages.DE_DE)
                    .includeVideoLanguage(Languages.DE_DE, Languages.EN_US),
            )
        }
    }

    @Test
    fun images_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<TvShowImages>("/tv/1399/images") {
            DefaultTvSeriesService(it).images(seriesId)
        }
        assertRequest<TvShowImages>(
            "/tv/1399/images",
            mapOf("include_image_language" to "de,null"),
        ) {
            DefaultTvSeriesService(it).images(
                seriesId,
                ImageQuery.includeImageLanguage("de,null"),
            )
        }
    }

    @Test
    fun remainingResourceMethods_shouldUseExpectedPathsAndTypes() {
        assertRequest<TvSeriesAlternativeTitles>("/tv/1399/alternative_titles") {
            DefaultTvSeriesService(it).alternativeTitles(seriesId)
        }
        assertRequest<TvSeriesContentRatings>("/tv/1399/content_ratings") {
            DefaultTvSeriesService(it).contentRatings(seriesId)
        }
        assertRequest<TvSeriesEpisodeGroups>("/tv/1399/episode_groups") {
            DefaultTvSeriesService(it).episodeGroups(seriesId)
        }
        assertRequest<ExternalIds>("/tv/1399/external_ids") {
            DefaultTvSeriesService(it).externalIds(seriesId)
        }
        assertRequest<TvSeriesKeywords>("/tv/1399/keywords") {
            DefaultTvSeriesService(it).keywords(seriesId)
        }
        assertRequest<TvSeriesDetails>("/tv/latest") {
            DefaultTvSeriesService(it).latest()
        }
        assertRequest<TvSeriesScreenedTheatrically>("/tv/1399/screened_theatrically") {
            DefaultTvSeriesService(it).screenedTheatrically(seriesId)
        }
        assertRequest<TvSeriesTranslations>("/tv/1399/translations") {
            DefaultTvSeriesService(it).translations(seriesId)
        }
        assertRequest<TvSeriesWatchProviders>("/tv/1399/watch/providers") {
            DefaultTvSeriesService(it).watchProviders(seriesId)
        }
    }
}
