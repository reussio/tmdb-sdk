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
import dev.reuss.tmdb.value.id.TvShowId
import dev.reuss.tmdb.value.language.Language

/** Loads TV-series lists, details, and related metadata from TMDB. */
interface TvSeriesService {
    /** Returns TV series with an episode airing today, using default query settings. */
    fun airingToday(): TvSeriesListResponse

    /** Returns TV series with an episode airing today, localized in [language]. */
    fun airingToday(language: Language): TvSeriesListResponse

    /** Returns TV series with an episode airing today using [query]. */
    fun airingToday(query: TvSeriesDateListQuery): TvSeriesListResponse

    /** Returns TV series with an episode airing in the next seven days. */
    fun onTheAir(): TvSeriesListResponse

    /** Returns series airing in the next seven days, localized in [language]. */
    fun onTheAir(language: Language): TvSeriesListResponse

    /** Returns series airing in the next seven days using [query]. */
    fun onTheAir(query: TvSeriesDateListQuery): TvSeriesListResponse

    /** Returns popular TV series using default query settings. */
    fun popular(): TvSeriesListResponse

    /** Returns popular TV series localized in [language]. */
    fun popular(language: Language): TvSeriesListResponse

    /** Returns popular TV series using [query]. */
    fun popular(query: TvSeriesListQuery): TvSeriesListResponse

    /** Returns the highest-rated TV series using default query settings. */
    fun topRated(): TvSeriesListResponse

    /** Returns the highest-rated TV series localized in [language]. */
    fun topRated(language: Language): TvSeriesListResponse

    /** Returns the highest-rated TV series using [query]. */
    fun topRated(query: TvSeriesListQuery): TvSeriesListResponse

    /** Returns series details using the client's default language. */
    fun details(seriesId: TvShowId): TvSeriesDetails

    /** Returns series details localized in [language]. */
    fun details(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesDetails

    /** Returns series details with the requested sub-resources appended. */
    fun details(
        seriesId: TvShowId,
        appendToResponse: AppendToResponse<TvSeriesAppend>,
    ): TvSeriesDetails

    /** Returns localized series details with the requested sub-resources appended. */
    fun details(
        seriesId: TvShowId,
        language: Language,
        appendToResponse: AppendToResponse<TvSeriesAppend>,
    ): TvSeriesDetails

    /** Returns credits from every season, combined by person with roles and episode counts. */
    fun aggregateCredits(seriesId: TvShowId): TvSeriesAggregateCredits

    /** Returns aggregated series credits localized in [language]. */
    fun aggregateCredits(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesAggregateCredits

    /** Returns alternative titles recorded for the series. */
    fun alternativeTitles(seriesId: TvShowId): TvSeriesAlternativeTitles

    /** Returns all tracked changes from the preceding 24 hours. */
    fun changes(seriesId: TvShowId): TvSeriesChanges

    /** Returns tracked series changes restricted by [query]. */
    fun changes(
        seriesId: TvShowId,
        query: ChangesQuery,
    ): TvSeriesChanges

    /** Returns the series' content ratings grouped by country. */
    fun contentRatings(seriesId: TvShowId): TvSeriesContentRatings

    /** Returns cast and crew credits for the latest season. */
    fun credits(seriesId: TvShowId): TvSeriesCredits

    /** Returns latest-season cast and crew credits localized in [language]. */
    fun credits(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesCredits

    /** Returns alternative episode groupings associated with the series. */
    fun episodeGroups(seriesId: TvShowId): TvSeriesEpisodeGroups

    /** Returns identifiers for the series in external databases. */
    fun externalIds(seriesId: TvShowId): ExternalIds

    /** Returns keywords associated with the series. */
    fun keywords(seriesId: TvShowId): TvSeriesKeywords

    /** Returns the most recently created TV-series record on TMDB. */
    fun latest(): TvSeriesDetails

    /** Returns recommendations using default paging and language settings. */
    fun recommendations(seriesId: TvShowId): TvSeriesRecommendations

    /** Returns recommendations localized in [language]. */
    fun recommendations(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesRecommendations

    /** Returns recommendations using [query]. */
    fun recommendations(
        seriesId: TvShowId,
        query: TvSeriesListQuery,
    ): TvSeriesRecommendations

    /** Returns user reviews using default paging and language settings. */
    fun reviews(seriesId: TvShowId): TvSeriesReviews

    /** Returns user reviews localized in [language]. */
    fun reviews(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesReviews

    /** Returns user reviews using [query]. */
    fun reviews(
        seriesId: TvShowId,
        query: TvSeriesListQuery,
    ): TvSeriesReviews

    /** Returns episodes that received a theatrical screening. */
    fun screenedTheatrically(seriesId: TvShowId): TvSeriesScreenedTheatrically

    /** Returns similar TV series using default paging and language settings. */
    fun similar(seriesId: TvShowId): TvSeriesSimilar

    /** Returns similar TV series localized in [language]. */
    fun similar(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesSimilar

    /** Returns similar TV series using [query]. */
    fun similar(
        seriesId: TvShowId,
        query: TvSeriesListQuery,
    ): TvSeriesSimilar

    /** Returns every translation recorded for the series. */
    fun translations(seriesId: TvShowId): TvSeriesTranslations

    /** Returns series videos using the client's default language. */
    fun videos(seriesId: TvShowId): TvSeriesVideos

    /** Returns series videos localized in [language]. */
    fun videos(
        seriesId: TvShowId,
        language: Language,
    ): TvSeriesVideos

    /** Returns series videos using the language filters in [query]. */
    fun videos(
        seriesId: TvShowId,
        query: TvSeriesVideosQuery,
    ): TvSeriesVideos

    /** Returns regional streaming and purchase offers for the series. */
    fun watchProviders(seriesId: TvShowId): TvSeriesWatchProviders

    /** Returns series backdrops, logos, and posters using default language filters. */
    fun images(seriesId: TvShowId): TvShowImages

    /** Returns series backdrops, logos, and posters using [query]. */
    fun images(
        seriesId: TvShowId,
        query: ImageQuery,
    ): TvShowImages
}
