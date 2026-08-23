package dev.reuss.tmdb.domain.tv.episode

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvEpisodeImages
import dev.reuss.tmdb.domain.tv.episode.model.*
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.TvEpisodeId
import dev.reuss.tmdb.value.id.TvEpisodeNumber
import dev.reuss.tmdb.value.id.TvSeasonNumber
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Language

/**
 * Service for TMDB TV episode endpoints.
 */
interface TvEpisodeService {

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber
    ): TvEpisodeDetails

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language
    ): TvEpisodeDetails

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        appendToResponse: AppendToResponse<TvEpisodeAppend>
    ): TvEpisodeDetails

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
        appendToResponse: AppendToResponse<TvEpisodeAppend>
    ): TvEpisodeDetails

    fun changes(episodeId: TvEpisodeId): TvEpisodeChanges

    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber
    ): TvEpisodeCredits

    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language
    ): TvEpisodeCredits

    fun externalIds(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber
    ): ExternalIds

    fun translations(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber
    ): TvEpisodeTranslations

    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber
    ): TvEpisodeVideos

    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language
    ): TvEpisodeVideos

    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        query: TvEpisodeVideosQuery
    ): TvEpisodeVideos

    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber
    ): TvEpisodeImages

    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        query: ImageQuery
    ): TvEpisodeImages
}