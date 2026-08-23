package dev.reuss.tmdb.domain.tv.season

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvSeasonImages
import dev.reuss.tmdb.domain.tv.season.model.*
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.TvSeasonId
import dev.reuss.tmdb.value.id.TvSeasonNumber
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Language

/**
 * Service for TMDB TV season endpoints.
 */
interface TvSeasonService {

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonDetails

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language
    ): TvSeasonDetails

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        appendToResponse: AppendToResponse<TvSeasonAppend>
    ): TvSeasonDetails

    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
        appendToResponse: AppendToResponse<TvSeasonAppend>
    ): TvSeasonDetails

    fun aggregateCredits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonAggregateCredits

    fun aggregateCredits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language
    ): TvSeasonAggregateCredits

    fun changes(seasonId: TvSeasonId): TvSeasonChanges

    fun changes(
        seasonId: TvSeasonId,
        query: ChangesQuery
    ): TvSeasonChanges

    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonCredits

    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language
    ): TvSeasonCredits

    fun externalIds(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): ExternalIds

    fun translations(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonTranslations

    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonVideos

    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language
    ): TvSeasonVideos

    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        query: TvSeasonVideosQuery
    ): TvSeasonVideos

    fun watchProviders(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonWatchProviders

    fun watchProviders(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language
    ): TvSeasonWatchProviders

    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber
    ): TvSeasonImages

    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        query: ImageQuery
    ): TvSeasonImages
}