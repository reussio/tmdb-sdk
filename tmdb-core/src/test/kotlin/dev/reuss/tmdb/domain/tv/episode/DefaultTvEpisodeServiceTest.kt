package dev.reuss.tmdb.domain.tv.episode

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvEpisodeImages
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeChanges
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeCredits
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeDetails
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeTranslations
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeVideos
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.TvEpisodeId
import dev.reuss.tmdb.value.id.TvEpisodeNumber
import dev.reuss.tmdb.value.id.TvSeasonNumber
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultTvEpisodeServiceTest {
    private val seriesId = TvShowId.of(1399)
    private val seasonNumber = TvSeasonNumber.of(0)
    private val episodeNumber = TvEpisodeNumber.of(1)

    @Test
    fun details_shouldSupportLanguageAndAppendOverloads() {
        val append = AppendToResponse.of(TvEpisodeAppend.CREDITS, TvEpisodeAppend.VIDEOS)

        assertRequest<TvEpisodeDetails>("/tv/1399/season/0/episode/1") {
            DefaultTvEpisodeService(it).details(seriesId, seasonNumber, episodeNumber)
        }
        assertRequest<TvEpisodeDetails>(
            "/tv/1399/season/0/episode/1",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvEpisodeService(it).details(
                seriesId,
                seasonNumber,
                episodeNumber,
                Languages.DE_DE,
            )
        }
        assertRequest<TvEpisodeDetails>(
            "/tv/1399/season/0/episode/1",
            mapOf("append_to_response" to "credits,videos"),
        ) {
            DefaultTvEpisodeService(it).details(seriesId, seasonNumber, episodeNumber, append)
        }
        assertRequest<TvEpisodeDetails>(
            "/tv/1399/season/0/episode/1",
            mapOf("language" to "de-DE", "append_to_response" to "credits,videos"),
        ) {
            DefaultTvEpisodeService(it).details(
                seriesId,
                seasonNumber,
                episodeNumber,
                Languages.DE_DE,
                append,
            )
        }
    }

    @Test
    fun credits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<TvEpisodeCredits>("/tv/1399/season/0/episode/1/credits") {
            DefaultTvEpisodeService(it).credits(seriesId, seasonNumber, episodeNumber)
        }
        assertRequest<TvEpisodeCredits>(
            "/tv/1399/season/0/episode/1/credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvEpisodeService(it).credits(
                seriesId,
                seasonNumber,
                episodeNumber,
                Languages.DE_DE,
            )
        }
    }

    @Test
    fun videos_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<TvEpisodeVideos>("/tv/1399/season/0/episode/1/videos") {
            DefaultTvEpisodeService(it).videos(seriesId, seasonNumber, episodeNumber)
        }
        assertRequest<TvEpisodeVideos>(
            "/tv/1399/season/0/episode/1/videos",
            mapOf("language" to "de-DE"),
        ) {
            DefaultTvEpisodeService(it).videos(
                seriesId,
                seasonNumber,
                episodeNumber,
                Languages.DE_DE,
            )
        }
        assertRequest<TvEpisodeVideos>(
            "/tv/1399/season/0/episode/1/videos",
            mapOf("language" to "de-DE", "include_video_language" to "de-DE,en-US"),
        ) {
            DefaultTvEpisodeService(it).videos(
                seriesId,
                seasonNumber,
                episodeNumber,
                TvEpisodeVideosQuery
                    .create()
                    .language(Languages.DE_DE)
                    .includeVideoLanguage(Languages.DE_DE, Languages.EN_US),
            )
        }
    }

    @Test
    fun images_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<TvEpisodeImages>("/tv/1399/season/0/episode/1/images") {
            DefaultTvEpisodeService(it).images(seriesId, seasonNumber, episodeNumber)
        }
        assertRequest<TvEpisodeImages>(
            "/tv/1399/season/0/episode/1/images",
            mapOf("include_image_language" to "de,null"),
        ) {
            DefaultTvEpisodeService(it).images(
                seriesId,
                seasonNumber,
                episodeNumber,
                ImageQuery.includeImageLanguage("de,null"),
            )
        }
    }

    @Test
    fun remainingMethods_shouldUseExpectedPathsAndResponseTypes() {
        assertRequest<TvEpisodeChanges>("/tv/episode/63056/changes") {
            DefaultTvEpisodeService(it).changes(TvEpisodeId.of(63056))
        }
        assertRequest<ExternalIds>("/tv/1399/season/0/episode/1/external_ids") {
            DefaultTvEpisodeService(it).externalIds(seriesId, seasonNumber, episodeNumber)
        }
        assertRequest<TvEpisodeTranslations>("/tv/1399/season/0/episode/1/translations") {
            DefaultTvEpisodeService(it).translations(seriesId, seasonNumber, episodeNumber)
        }
    }
}
