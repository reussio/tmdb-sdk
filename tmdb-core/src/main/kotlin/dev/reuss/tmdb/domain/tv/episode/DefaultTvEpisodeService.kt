package dev.reuss.tmdb.domain.tv.episode

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.TvEpisodeImages
import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
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

/**
 * Default [TvEpisodeService] implementation backed by TMDB HTTP requests.
 */
internal class DefaultTvEpisodeService(
    private val httpClient: TmdbHttpClient,
) : TvEpisodeService {
    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeDetails =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.details(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
            ),
            TvEpisodeDetails::class.java,
        )

    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
    ): TvEpisodeDetails =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.details(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvEpisodeDetails::class.java,
        )

    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        appendToResponse: AppendToResponse<TvEpisodeAppend>,
    ): TvEpisodeDetails =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.details(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                QueryParams
                    .create()
                    .add("append_to_response", appendToResponse),
            ),
            TvEpisodeDetails::class.java,
        )

    override fun details(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
        appendToResponse: AppendToResponse<TvEpisodeAppend>,
    ): TvEpisodeDetails =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.details(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                QueryParams
                    .create()
                    .add("language", language.value)
                    .add("append_to_response", appendToResponse),
            ),
            TvEpisodeDetails::class.java,
        )

    override fun changes(episodeId: TvEpisodeId): TvEpisodeChanges =
        httpClient.get(
            TmdbRequest.get(TvEpisodePaths.changes(episodeId)),
            TvEpisodeChanges::class.java,
        )

    override fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeCredits =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.credits(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
            ),
            TvEpisodeCredits::class.java,
        )

    override fun credits(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
    ): TvEpisodeCredits =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.credits(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvEpisodeCredits::class.java,
        )

    override fun externalIds(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): ExternalIds =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.externalIds(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
            ),
            ExternalIds::class.java,
        )

    override fun translations(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeTranslations =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.translations(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
            ),
            TvEpisodeTranslations::class.java,
        )

    override fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeVideos =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.videos(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
            ),
            TvEpisodeVideos::class.java,
        )

    override fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        language: Language,
    ): TvEpisodeVideos =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.videos(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                QueryParams
                    .create()
                    .add("language", language.value),
            ),
            TvEpisodeVideos::class.java,
        )

    override fun videos(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        query: TvEpisodeVideosQuery,
    ): TvEpisodeVideos =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.videos(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                query.toQueryParams(),
            ),
            TvEpisodeVideos::class.java,
        )

    override fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
    ): TvEpisodeImages =
        images(
            seriesId,
            seasonNumber,
            episodeNumber,
            ImageQuery.none(),
        )

    override fun images(
        seriesId: TvShowId,
        seasonNumber: TvSeasonNumber,
        episodeNumber: TvEpisodeNumber,
        query: ImageQuery,
    ): TvEpisodeImages =
        httpClient.get(
            TmdbRequest.get(
                TvEpisodePaths.images(
                    seriesId,
                    seasonNumber.value,
                    episodeNumber.value,
                ),
                query.toQueryParams(),
            ),
            TvEpisodeImages::class.java,
        )
}
