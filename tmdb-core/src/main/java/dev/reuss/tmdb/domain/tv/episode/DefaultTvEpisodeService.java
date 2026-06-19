package dev.reuss.tmdb.domain.tv.episode;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvEpisodeImages;
import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.tv.episode.model.*;
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.TvEpisodeId;
import dev.reuss.tmdb.value.id.TvEpisodeNumber;
import dev.reuss.tmdb.value.id.TvSeasonNumber;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

public final class DefaultTvEpisodeService implements TvEpisodeService {

    private final TmdbHttpClient httpClient;

    public DefaultTvEpisodeService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodePaths.details(seriesId, seasonNumber.value(), episodeNumber.value())),
                TvEpisodeDetails.class
        );
    }

    @Override
    public TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.details(seriesId, seasonNumber.value(), episodeNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvEpisodeDetails.class
        );
    }

    @Override
    public TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            AppendToResponse<TvEpisodeAppend> appendToResponse
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.details(seriesId, seasonNumber.value(), episodeNumber.value()),
                        QueryParams.create().add("append_to_response", appendToResponse)
                ),
                TvEpisodeDetails.class
        );
    }

    @Override
    public TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language,
            AppendToResponse<TvEpisodeAppend> appendToResponse
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");
        Objects.requireNonNull(language, "Language must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.details(seriesId, seasonNumber.value(), episodeNumber.value()),
                        QueryParams.create()
                                .add("language", language)
                                .add("append_to_response", appendToResponse)
                ),
                TvEpisodeDetails.class
        );
    }

    @Override
    public TvEpisodeChanges changes(TvEpisodeId episodeId) {
        Objects.requireNonNull(episodeId, "TV episode id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodePaths.changes(episodeId)),
                TvEpisodeChanges.class
        );
    }

    @Override
    public TvEpisodeCredits credits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodePaths.credits(seriesId, seasonNumber.value(), episodeNumber.value())),
                TvEpisodeCredits.class
        );
    }

    @Override
    public TvEpisodeCredits credits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.credits(seriesId, seasonNumber.value(), episodeNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvEpisodeCredits.class
        );
    }

    @Override
    public ExternalIds externalIds(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodePaths.externalIds(seriesId, seasonNumber.value(), episodeNumber.value())),
                ExternalIds.class
        );
    }

    @Override
    public TvEpisodeTranslations translations(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodePaths.translations(seriesId, seasonNumber.value(), episodeNumber.value())),
                TvEpisodeTranslations.class
        );
    }

    @Override
    public TvEpisodeVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodePaths.videos(seriesId, seasonNumber.value(), episodeNumber.value())),
                TvEpisodeVideos.class
        );
    }

    @Override
    public TvEpisodeVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.videos(seriesId, seasonNumber.value(), episodeNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvEpisodeVideos.class
        );
    }

    @Override
    public TvEpisodeVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            TvEpisodeVideosQuery query
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(episodeNumber, "TV episode number must not be null");
        Objects.requireNonNull(query, "TV episode videos query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.videos(seriesId, seasonNumber.value(), episodeNumber.value()),
                        query.toQueryParams()
                ),
                TvEpisodeVideos.class
        );
    }

    @Override
    public TvEpisodeImages images(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return images(tvShowId, seasonNumber, episodeNumber, ImageQuery.none());
    }

    @Override
    public TvEpisodeImages images(
            TvShowId tvShowId,
            int seasonNumber,
            int episodeNumber,
            ImageQuery query
    ) {
        Objects.requireNonNull(tvShowId, "TV show id must not be null");
        Objects.requireNonNull(query, "Image query must not be null");

        if (seasonNumber < 0) {
            throw new IllegalArgumentException("Season number must not be negative");
        }

        if (episodeNumber <= 0) {
            throw new IllegalArgumentException("Episode number must be positive");
        }

        return httpClient.get(
                TmdbRequest.get(
                        TvEpisodePaths.images(tvShowId, seasonNumber, episodeNumber),
                        query.toQueryParams()
                ),
                TvEpisodeImages.class
        );
    }
}
