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
import dev.reuss.tmdb.value.id.TvSeasonId
import dev.reuss.tmdb.value.id.TvSeasonNumber
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Language

/** Loads details and related metadata for individual TV seasons. */
interface TvSeasonService {
    /** Returns season details using the client's default language. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonDetails

    /** Returns season details localized in [language]. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonDetails

    /** Returns season details with the requested sub-resources appended. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        appendToResponse: AppendToResponse<TvSeasonAppend>,
    ): TvSeasonDetails

    /** Returns localized season details with the requested sub-resources appended. */
    fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
        appendToResponse: AppendToResponse<TvSeasonAppend>,
    ): TvSeasonDetails

    /** Returns credits combined by person, with roles and episode counts. */
    fun aggregateCredits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonAggregateCredits

    /** Returns credits combined by person and localized in [language]. */
    fun aggregateCredits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonAggregateCredits

    /** Returns tracked changes for the season identified by its TMDB [seasonId]. */
    fun changes(seasonId: TvSeasonId): TvSeasonChanges

    /** Returns tracked season changes restricted by [query]. */
    fun changes(
        seasonId: TvSeasonId,
        query: ChangesQuery,
    ): TvSeasonChanges

    /** Returns the season's cast and crew credits using the client's default language. */
    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonCredits

    /** Returns the season's cast and crew credits localized in [language]. */
    fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonCredits

    /** Returns identifiers for the season in external databases. */
    fun externalIds(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): ExternalIds

    /** Returns every translation recorded for the season. */
    fun translations(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonTranslations

    /** Returns season videos using the client's default language. */
    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonVideos

    /** Returns season videos localized in [language]. */
    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonVideos

    /** Returns season videos using the language filters in [query]. */
    fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        query: TvSeasonVideosQuery,
    ): TvSeasonVideos

    /** Returns regional streaming and purchase offers using the default language. */
    fun watchProviders(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonWatchProviders

    /** Returns regional streaming and purchase offers localized in [language]. */
    fun watchProviders(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonWatchProviders

    /** Returns season posters using the client's default language filters. */
    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonImages

    /** Returns season posters using the language filters in [query]. */
    fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        query: ImageQuery,
    ): TvSeasonImages
}
