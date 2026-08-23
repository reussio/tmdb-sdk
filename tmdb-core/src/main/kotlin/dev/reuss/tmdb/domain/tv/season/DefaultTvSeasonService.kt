package dev.reuss.tmdb.domain.tv.season

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvSeasonImages
import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
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

/**
 * Default [TvSeasonService] implementation backed by TMDB HTTP requests.
 */
internal class DefaultTvSeasonService(
    private val httpClient: TmdbHttpClient,
) : TvSeasonService {
    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.details(seriesId, seasonNumber.value),
            ),
            TvSeasonDetails::class.java,
        )

    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.details(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvSeasonDetails::class.java,
        )

    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        appendToResponse: AppendToResponse<TvSeasonAppend>,
    ): TvSeasonDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.details(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("append_to_response", appendToResponse),
            ),
            TvSeasonDetails::class.java,
        )

    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
        appendToResponse: AppendToResponse<TvSeasonAppend>,
    ): TvSeasonDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.details(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("language", language.value)
                    .add("append_to_response", appendToResponse),
            ),
            TvSeasonDetails::class.java,
        )

    override fun aggregateCredits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonAggregateCredits =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.aggregateCredits(seriesId, seasonNumber.value),
            ),
            TvSeasonAggregateCredits::class.java,
        )

    override fun aggregateCredits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonAggregateCredits =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.aggregateCredits(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvSeasonAggregateCredits::class.java,
        )

    override fun changes(seasonId: TvSeasonId): TvSeasonChanges =
        httpClient.get(
            TmdbRequest.get(TvSeasonPaths.changes(seasonId)),
            TvSeasonChanges::class.java,
        )

    override fun changes(
        seasonId: TvSeasonId,
        query: ChangesQuery,
    ): TvSeasonChanges =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.changes(seasonId),
                query.toQueryParams(),
            ),
            TvSeasonChanges::class.java,
        )

    override fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonCredits =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.credits(seriesId, seasonNumber.value),
            ),
            TvSeasonCredits::class.java,
        )

    override fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonCredits =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.credits(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvSeasonCredits::class.java,
        )

    override fun externalIds(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): ExternalIds =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.externalIds(seriesId, seasonNumber.value),
            ),
            ExternalIds::class.java,
        )

    override fun translations(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonTranslations =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.translations(seriesId, seasonNumber.value),
            ),
            TvSeasonTranslations::class.java,
        )

    override fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonVideos =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.videos(seriesId, seasonNumber.value),
            ),
            TvSeasonVideos::class.java,
        )

    override fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonVideos =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.videos(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvSeasonVideos::class.java,
        )

    override fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        query: TvSeasonVideosQuery,
    ): TvSeasonVideos =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.videos(seriesId, seasonNumber.value),
                query.toQueryParams(),
            ),
            TvSeasonVideos::class.java,
        )

    override fun watchProviders(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonWatchProviders =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.watchProviders(seriesId, seasonNumber.value),
            ),
            TvSeasonWatchProviders::class.java,
        )

    override fun watchProviders(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        language: Language,
    ): TvSeasonWatchProviders =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.watchProviders(seriesId, seasonNumber.value),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvSeasonWatchProviders::class.java,
        )

    override fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
    ): TvSeasonImages =
        images(
            seriesId,
            seasonNumber,
            ImageQuery.none(),
        )

    override fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        query: ImageQuery,
    ): TvSeasonImages =
        httpClient.get(
            TmdbRequest.get(
                TvSeasonPaths.images(seriesId, seasonNumber.value),
                query.toQueryParams(),
            ),
            TvSeasonImages::class.java,
        )
}
