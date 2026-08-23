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
import dev.reuss.tmdb.value.id.TvEpisodeId
import dev.reuss.tmdb.value.id.TvEpisodeNumber
import dev.reuss.tmdb.value.id.TvSeasonNumber
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Language

/** Loads details and related metadata for individual TV episodes. */
interface TvEpisodeService {
    /** Returns episode details using the client's default language. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeDetails

    /** Returns episode details localized in [language]. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
    ): TvEpisodeDetails

    /** Returns episode details with the requested sub-resources appended. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        appendToResponse: AppendToResponse<TvEpisodeAppend>,
    ): TvEpisodeDetails

    /** Returns localized episode details with the requested sub-resources appended. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
        appendToResponse: AppendToResponse<TvEpisodeAppend>,
    ): TvEpisodeDetails

    /** Returns the tracked changes for the episode identified by its TMDB [episodeId]. */
    fun changes(episodeId: TvEpisodeId): TvEpisodeChanges

    /** Returns episode cast and crew credits using the client's default language. */
    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeCredits

    /** Returns episode cast and crew credits localized in [language]. */
    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
    ): TvEpisodeCredits

    /** Returns identifiers for the episode in external databases. */
    fun externalIds(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): ExternalIds

    /** Returns every translation recorded for the episode. */
    fun translations(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeTranslations

    /** Returns episode videos using the client's default language. */
    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeVideos

    /** Returns episode videos localized in [language]. */
    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
    ): TvEpisodeVideos

    /** Returns episode videos using the language filters in [query]. */
    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        query: TvEpisodeVideosQuery,
    ): TvEpisodeVideos

    /** Returns episode stills using the client's default language filters. */
    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeImages

    /** Returns episode stills using the language filters in [query]. */
    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        query: ImageQuery,
    ): TvEpisodeImages
}
