package dev.reuss.tmdb.domain.tv.season;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvSeasonImages;
import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.tv.season.model.*;
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.TvSeasonId;
import dev.reuss.tmdb.value.id.TvSeasonNumber;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

public final class DefaultTvSeasonService implements TvSeasonService {

    private final TmdbHttpClient httpClient;

    public DefaultTvSeasonService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public TvSeasonDetails details(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.details(seriesId, seasonNumber.value())),
                TvSeasonDetails.class
        );
    }

    @Override
    public TvSeasonDetails details(TvShowId seriesId, TvSeasonNumber seasonNumber, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.details(seriesId, seasonNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvSeasonDetails.class
        );
    }

    @Override
    public TvSeasonDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            AppendToResponse<TvSeasonAppend> appendToResponse
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.details(seriesId, seasonNumber.value()),
                        QueryParams.create().add("append_to_response", appendToResponse)
                ),
                TvSeasonDetails.class
        );
    }

    @Override
    public TvSeasonDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language,
            AppendToResponse<TvSeasonAppend> appendToResponse
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(language, "Language must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.details(seriesId, seasonNumber.value()),
                        QueryParams.create()
                                .add("language", language)
                                .add("append_to_response", appendToResponse)
                ),
                TvSeasonDetails.class
        );
    }

    @Override
    public TvSeasonAggregateCredits aggregateCredits(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.aggregateCredits(seriesId, seasonNumber.value())),
                TvSeasonAggregateCredits.class
        );
    }

    @Override
    public TvSeasonAggregateCredits aggregateCredits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.aggregateCredits(seriesId, seasonNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvSeasonAggregateCredits.class
        );
    }

    @Override
    public TvSeasonChanges changes(TvSeasonId seasonId) {
        Objects.requireNonNull(seasonId, "TV season id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.changes(seasonId)),
                TvSeasonChanges.class
        );
    }

    @Override
    public TvSeasonChanges changes(TvSeasonId seasonId, ChangesQuery query) {
        Objects.requireNonNull(seasonId, "TV season id must not be null");
        Objects.requireNonNull(query, "Changes query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.changes(seasonId),
                        query.toQueryParams()
                ),
                TvSeasonChanges.class
        );
    }

    @Override
    public TvSeasonCredits credits(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.credits(seriesId, seasonNumber.value())),
                TvSeasonCredits.class
        );
    }

    @Override
    public TvSeasonCredits credits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.credits(seriesId, seasonNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvSeasonCredits.class
        );
    }

    @Override
    public ExternalIds externalIds(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.externalIds(seriesId, seasonNumber.value())),
                ExternalIds.class
        );
    }

    @Override
    public TvSeasonTranslations translations(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.translations(seriesId, seasonNumber.value())),
                TvSeasonTranslations.class
        );
    }

    @Override
    public TvSeasonVideos videos(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.videos(seriesId, seasonNumber.value())),
                TvSeasonVideos.class
        );
    }

    @Override
    public TvSeasonVideos videos(TvShowId seriesId, TvSeasonNumber seasonNumber, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.videos(seriesId, seasonNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvSeasonVideos.class
        );
    }

    @Override
    public TvSeasonVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvSeasonVideosQuery query
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(query, "TV season videos query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.videos(seriesId, seasonNumber.value()),
                        query.toQueryParams()
                ),
                TvSeasonVideos.class
        );
    }

    @Override
    public TvSeasonWatchProviders watchProviders(TvShowId seriesId, TvSeasonNumber seasonNumber) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeasonPaths.watchProviders(seriesId, seasonNumber.value())),
                TvSeasonWatchProviders.class
        );
    }

    @Override
    public TvSeasonWatchProviders watchProviders(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(seasonNumber, "TV season number must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.watchProviders(seriesId, seasonNumber.value()),
                        QueryParams.create().add("language", language)
                ),
                TvSeasonWatchProviders.class
        );
    }

    @Override
    public TvSeasonImages images(TvShowId tvShowId, int seasonNumber) {
        return images(tvShowId, seasonNumber, ImageQuery.none());
    }

    @Override
    public TvSeasonImages images(TvShowId tvShowId, int seasonNumber, ImageQuery query) {
        Objects.requireNonNull(tvShowId, "TV show id must not be null");
        Objects.requireNonNull(query, "Image query must not be null");

        if (seasonNumber < 0) {
            throw new IllegalArgumentException("Season number must not be negative");
        }

        return httpClient.get(
                TmdbRequest.get(
                        TvSeasonPaths.images(tvShowId, seasonNumber),
                        query.toQueryParams()
                ),
                TvSeasonImages.class
        );
    }
}
