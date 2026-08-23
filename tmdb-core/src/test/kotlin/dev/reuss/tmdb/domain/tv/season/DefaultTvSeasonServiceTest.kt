package dev.reuss.tmdb.domain.tv.season

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvSeasonImages
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonAggregateCredits
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonChanges
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonCredits
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonDetails
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonTranslations
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonVideos
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonWatchProviders
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.TvSeasonId
import dev.reuss.tmdb.value.id.TvSeasonNumber
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DefaultTvSeasonServiceTest {
    private val seriesId = TvShowId.of(1399)
    private val seasonNumber = TvSeasonNumber.of(0)

    @Test
    fun details_shouldSupportLanguageAndAppendOverloads() {
        val append = AppendToResponse.of(TvSeasonAppend.CREDITS, TvSeasonAppend.VIDEOS)

        assertRequest<TvSeasonDetails>("/tv/1399/season/0") {
            DefaultTvSeasonService(it).details(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonDetails>(
            "/tv/1399/season/0",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeasonService(it).details(seriesId, seasonNumber, Languages.DE_DE)
        }
        assertRequest<TvSeasonDetails>(
            "/tv/1399/season/0",
            mapOf("append_to_response" to "credits,videos"),
        ) {
            DefaultTvSeasonService(it).details(seriesId, seasonNumber, append)
        }
        assertRequest<TvSeasonDetails>(
            "/tv/1399/season/0",
            mapOf("language" to "de-DE", "append_to_response" to "credits,videos"),
        ) {
            DefaultTvSeasonService(it).details(seriesId, seasonNumber, Languages.DE_DE, append)
        }
    }

    @Test
    fun aggregateCredits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<TvSeasonAggregateCredits>("/tv/1399/season/0/aggregate_credits") {
            DefaultTvSeasonService(it).aggregateCredits(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonAggregateCredits>(
            "/tv/1399/season/0/aggregate_credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeasonService(it).aggregateCredits(seriesId, seasonNumber, Languages.DE_DE)
        }
    }

    @Test
    fun changes_shouldSupportDefaultAndQueryOverloads() {
        val seasonId = TvSeasonId.of(3624)

        assertRequest<TvSeasonChanges>("/tv/season/3624/changes") {
            DefaultTvSeasonService(it).changes(seasonId)
        }
        assertRequest<TvSeasonChanges>(
            "/tv/season/3624/changes",
            mapOf("end_date" to "2024-01-14", "start_date" to "2024-01-01"),
        ) {
            DefaultTvSeasonService(it).changes(
                seasonId,
                ChangesQuery
                    .create()
                    .startDate(LocalDate.of(2024, 1, 1))
                    .endDate(LocalDate.of(2024, 1, 14)),
            )
        }
    }

    @Test
    fun credits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<TvSeasonCredits>("/tv/1399/season/0/credits") {
            DefaultTvSeasonService(it).credits(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonCredits>(
            "/tv/1399/season/0/credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeasonService(it).credits(seriesId, seasonNumber, Languages.DE_DE)
        }
    }

    @Test
    fun videos_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvSeasonVideos>("/tv/1399/season/0/videos") {
            DefaultTvSeasonService(it).videos(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonVideos>(
            "/tv/1399/season/0/videos",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeasonService(it).videos(seriesId, seasonNumber, Languages.DE_DE)
        }
        assertRequest<TvSeasonVideos>(
            "/tv/1399/season/0/videos",
            mapOf("language" to "de-DE", "include_video_language" to "de-DE,en-US"),
        ) {
            DefaultTvSeasonService(it).videos(
                seriesId,
                seasonNumber,
                TvSeasonVideosQuery
                    .create()
                    .language(Languages.DE_DE)
                    .includeVideoLanguage(Languages.DE_DE, Languages.EN_US),
            )
        }
    }

    @Test
    fun watchProviders_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<TvSeasonWatchProviders>("/tv/1399/season/0/watch/providers") {
            DefaultTvSeasonService(it).watchProviders(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonWatchProviders>(
            "/tv/1399/season/0/watch/providers",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvSeasonService(it).watchProviders(seriesId, seasonNumber, Languages.DE_DE)
        }
    }

    @Test
    fun images_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<TvSeasonImages>("/tv/1399/season/0/images") {
            DefaultTvSeasonService(it).images(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonImages>(
            "/tv/1399/season/0/images",
            mapOf("include_image_language" to "de,null"),
        ) {
            DefaultTvSeasonService(it).images(
                seriesId,
                seasonNumber,
                ImageQuery.includeImageLanguage("de,null"),
            )
        }
    }

    @Test
    fun remainingMethods_shouldUseExpectedPathsAndResponseTypes() {
        assertRequest<ExternalIds>("/tv/1399/season/0/external_ids") {
            DefaultTvSeasonService(it).externalIds(seriesId, seasonNumber)
        }
        assertRequest<TvSeasonTranslations>("/tv/1399/season/0/translations") {
            DefaultTvSeasonService(it).translations(seriesId, seasonNumber)
        }
    }
}
