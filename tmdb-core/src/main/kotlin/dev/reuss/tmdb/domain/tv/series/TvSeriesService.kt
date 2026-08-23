package dev.reuss.tmdb.domain.tv.series

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvShowImages
import dev.reuss.tmdb.domain.tv.series.model.*
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesVideosQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Language

/**
 * Service for TMDB TV series list endpoints.
 */
interface TvSeriesService {

    fun airingToday(): TvSeriesListResponse

    fun airingToday(language: Language): TvSeriesListResponse

    fun airingToday(query: TvSeriesDateListQuery): TvSeriesListResponse

    fun onTheAir(): TvSeriesListResponse

    fun onTheAir(language: Language): TvSeriesListResponse

    fun onTheAir(query: TvSeriesDateListQuery): TvSeriesListResponse

    fun popular(): TvSeriesListResponse

    fun popular(language: Language): TvSeriesListResponse

    fun popular(query: TvSeriesListQuery): TvSeriesListResponse

    fun topRated(): TvSeriesListResponse

    fun topRated(language: Language): TvSeriesListResponse

    fun topRated(query: TvSeriesListQuery): TvSeriesListResponse

    fun details(seriesId: TvShowId): TvSeriesDetails

    fun details(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesDetails

    fun details(
        seriesId: TvShowId,
        appendToResponse: AppendToResponse<TvSeriesAppend>
    ): TvSeriesDetails

    fun details(
        seriesId: TvShowId,
        language: Language,
        appendToResponse: AppendToResponse<TvSeriesAppend>
    ): TvSeriesDetails

    fun aggregateCredits(seriesId: TvShowId): TvSeriesAggregateCredits

    fun aggregateCredits(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesAggregateCredits

    fun alternativeTitles(seriesId: TvShowId): TvSeriesAlternativeTitles

    fun changes(seriesId: TvShowId): TvSeriesChanges

    fun changes(
        seriesId: TvShowId,
        query: ChangesQuery
    ): TvSeriesChanges

    fun contentRatings(seriesId: TvShowId): TvSeriesContentRatings

    fun credits(seriesId: TvShowId): TvSeriesCredits

    fun credits(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesCredits

    fun episodeGroups(seriesId: TvShowId): TvSeriesEpisodeGroups

    fun externalIds(seriesId: TvShowId): ExternalIds

    fun keywords(seriesId: TvShowId): TvSeriesKeywords

    fun latest(): TvSeriesDetails

    fun recommendations(seriesId: TvShowId): TvSeriesRecommendations

    fun recommendations(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesRecommendations

    fun recommendations(
        seriesId: TvShowId,
        query: TvSeriesListQuery
    ): TvSeriesRecommendations

    fun reviews(seriesId: TvShowId): TvSeriesReviews

    fun reviews(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesReviews

    fun reviews(
        seriesId: TvShowId,
        query: TvSeriesListQuery
    ): TvSeriesReviews

    fun screenedTheatrically(
        seriesId: TvShowId
    ): TvSeriesScreenedTheatrically

    fun similar(seriesId: TvShowId): TvSeriesSimilar

    fun similar(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesSimilar

    fun similar(
        seriesId: TvShowId,
        query: TvSeriesListQuery
    ): TvSeriesSimilar

    fun translations(seriesId: TvShowId): TvSeriesTranslations

    fun videos(seriesId: TvShowId): TvSeriesVideos

    fun videos(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesVideos

    fun videos(
        seriesId: TvShowId,
        query: TvSeriesVideosQuery
    ): TvSeriesVideos

    fun watchProviders(seriesId: TvShowId): TvSeriesWatchProviders

    fun images(seriesId: TvShowId): TvShowImages

    fun images(
        seriesId: TvShowId,
        query: ImageQuery
    ): TvShowImages
}