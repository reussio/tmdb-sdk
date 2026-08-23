package dev.reuss.tmdb.domain.tv.series

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvShowImages
import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
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
 * Default [TvSeriesService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultTvSeriesService(
    private val httpClient: TmdbHttpClient
) : TvSeriesService {

    override fun airingToday(): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.airingToday()),
            TvSeriesListResponse::class.java
        )

    override fun airingToday(language: Language): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.airingToday(),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesListResponse::class.java
        )

    override fun airingToday(query: TvSeriesDateListQuery): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.airingToday(),
                query.toQueryParams()
            ),
            TvSeriesListResponse::class.java
        )

    override fun onTheAir(): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.onTheAir()),
            TvSeriesListResponse::class.java
        )

    override fun onTheAir(language: Language): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.onTheAir(),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesListResponse::class.java
        )

    override fun onTheAir(query: TvSeriesDateListQuery): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.onTheAir(),
                query.toQueryParams()
            ),
            TvSeriesListResponse::class.java
        )

    override fun popular(): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.popular()),
            TvSeriesListResponse::class.java
        )

    override fun popular(language: Language): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.popular(),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesListResponse::class.java
        )

    override fun popular(query: TvSeriesListQuery): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.popular(),
                query.toQueryParams()
            ),
            TvSeriesListResponse::class.java
        )

    override fun topRated(): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.topRated()),
            TvSeriesListResponse::class.java
        )

    override fun topRated(language: Language): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.topRated(),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesListResponse::class.java
        )

    override fun topRated(query: TvSeriesListQuery): TvSeriesListResponse =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.topRated(),
                query.toQueryParams()
            ),
            TvSeriesListResponse::class.java
        )

    override fun details(seriesId: TvShowId): TvSeriesDetails =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.details(seriesId)),
            TvSeriesDetails::class.java
        )

    override fun details(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.details(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesDetails::class.java
        )

    override fun details(
        seriesId: TvShowId,
        appendToResponse: AppendToResponse<TvSeriesAppend>
    ): TvSeriesDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.details(seriesId),
                QueryParams.create().add("append_to_response", appendToResponse)
            ),
            TvSeriesDetails::class.java
        )

    override fun details(
        seriesId: TvShowId,
        language: Language,
        appendToResponse: AppendToResponse<TvSeriesAppend>
    ): TvSeriesDetails =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.details(seriesId),
                QueryParams.create()
                    .add("language", language.value)
                    .add("append_to_response", appendToResponse)
            ),
            TvSeriesDetails::class.java
        )

    override fun aggregateCredits(seriesId: TvShowId): TvSeriesAggregateCredits =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.aggregateCredits(seriesId)),
            TvSeriesAggregateCredits::class.java
        )

    override fun aggregateCredits(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesAggregateCredits =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.aggregateCredits(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesAggregateCredits::class.java
        )

    override fun alternativeTitles(seriesId: TvShowId): TvSeriesAlternativeTitles =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.alternativeTitles(seriesId)),
            TvSeriesAlternativeTitles::class.java
        )

    override fun changes(seriesId: TvShowId): TvSeriesChanges =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.changes(seriesId)),
            TvSeriesChanges::class.java
        )

    override fun changes(
        seriesId: TvShowId,
        query: ChangesQuery
    ): TvSeriesChanges =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.changes(seriesId),
                query.toQueryParams()
            ),
            TvSeriesChanges::class.java
        )

    override fun contentRatings(seriesId: TvShowId): TvSeriesContentRatings =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.contentRatings(seriesId)),
            TvSeriesContentRatings::class.java
        )

    override fun credits(seriesId: TvShowId): TvSeriesCredits =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.credits(seriesId)),
            TvSeriesCredits::class.java
        )

    override fun credits(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesCredits =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.credits(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesCredits::class.java
        )

    override fun episodeGroups(seriesId: TvShowId): TvSeriesEpisodeGroups =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.episodeGroups(seriesId)),
            TvSeriesEpisodeGroups::class.java
        )

    override fun externalIds(seriesId: TvShowId): ExternalIds =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.externalIds(seriesId)),
            ExternalIds::class.java
        )

    override fun keywords(seriesId: TvShowId): TvSeriesKeywords =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.keywords(seriesId)),
            TvSeriesKeywords::class.java
        )

    override fun latest(): TvSeriesDetails =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.latest()),
            TvSeriesDetails::class.java
        )

    override fun recommendations(seriesId: TvShowId): TvSeriesRecommendations =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.recommendations(seriesId)),
            TvSeriesRecommendations::class.java
        )

    override fun recommendations(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesRecommendations =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.recommendations(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesRecommendations::class.java
        )

    override fun recommendations(
        seriesId: TvShowId,
        query: TvSeriesListQuery
    ): TvSeriesRecommendations =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.recommendations(seriesId),
                query.toQueryParams()
            ),
            TvSeriesRecommendations::class.java
        )

    override fun reviews(seriesId: TvShowId): TvSeriesReviews =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.reviews(seriesId)),
            TvSeriesReviews::class.java
        )

    override fun reviews(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesReviews =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.reviews(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesReviews::class.java
        )

    override fun reviews(
        seriesId: TvShowId,
        query: TvSeriesListQuery
    ): TvSeriesReviews =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.reviews(seriesId),
                query.toQueryParams()
            ),
            TvSeriesReviews::class.java
        )

    override fun screenedTheatrically(
        seriesId: TvShowId
    ): TvSeriesScreenedTheatrically =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.screenedTheatrically(seriesId)),
            TvSeriesScreenedTheatrically::class.java
        )

    override fun similar(seriesId: TvShowId): TvSeriesSimilar =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.similar(seriesId)),
            TvSeriesSimilar::class.java
        )

    override fun similar(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesSimilar =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.similar(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesSimilar::class.java
        )

    override fun similar(
        seriesId: TvShowId,
        query: TvSeriesListQuery
    ): TvSeriesSimilar =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.similar(seriesId),
                query.toQueryParams()
            ),
            TvSeriesSimilar::class.java
        )

    override fun translations(seriesId: TvShowId): TvSeriesTranslations =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.translations(seriesId)),
            TvSeriesTranslations::class.java
        )

    override fun videos(seriesId: TvShowId): TvSeriesVideos =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.videos(seriesId)),
            TvSeriesVideos::class.java
        )

    override fun videos(
        seriesId: TvShowId,
        language: Language
    ): TvSeriesVideos =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.videos(seriesId),
                QueryParams.create().add("language", language.value)
            ),
            TvSeriesVideos::class.java
        )

    override fun videos(
        seriesId: TvShowId,
        query: TvSeriesVideosQuery
    ): TvSeriesVideos =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.videos(seriesId),
                query.toQueryParams()
            ),
            TvSeriesVideos::class.java
        )

    override fun watchProviders(seriesId: TvShowId): TvSeriesWatchProviders =
        httpClient.get(
            TmdbRequest.get(TvSeriesPaths.watchProviders(seriesId)),
            TvSeriesWatchProviders::class.java
        )

    override fun images(seriesId: TvShowId): TvShowImages =
        images(seriesId, ImageQuery.none())

    override fun images(
        seriesId: TvShowId,
        query: ImageQuery
    ): TvShowImages =
        httpClient.get(
            TmdbRequest.get(
                TvSeriesPaths.images(seriesId),
                query.toQueryParams()
            ),
            TvShowImages::class.java
        )
}