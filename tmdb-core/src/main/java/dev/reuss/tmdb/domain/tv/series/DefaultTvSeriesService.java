package dev.reuss.tmdb.domain.tv.series;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvShowImages;
import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.tv.series.model.*;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default {@link TvSeriesService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultTvSeriesService implements TvSeriesService {

    private final TmdbHttpClient httpClient;

    public DefaultTvSeriesService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public TvSeriesListResponse airingToday() {
        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.airingToday()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse airingToday(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.airingToday(),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse airingToday(TvSeriesDateListQuery query) {
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.airingToday(), query.toQueryParams()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse onTheAir() {
        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.onTheAir()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse onTheAir(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.onTheAir(),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse onTheAir(TvSeriesDateListQuery query) {
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.onTheAir(), query.toQueryParams()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse popular() {
        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.popular()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse popular(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.popular(),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse popular(TvSeriesListQuery query) {
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.popular(), query.toQueryParams()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse topRated() {
        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.topRated()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse topRated(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.topRated(),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesListResponse topRated(TvSeriesListQuery query) {
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.topRated(), query.toQueryParams()),
                TvSeriesListResponse.class
        );
    }

    @Override
    public TvSeriesDetails details(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.details(seriesId)),
                TvSeriesDetails.class
        );
    }

    @Override
    public TvSeriesDetails details(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.details(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesDetails.class
        );
    }

    @Override
    public TvSeriesDetails details(TvShowId seriesId, AppendToResponse<TvSeriesAppend> appendToResponse) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.details(seriesId),
                        QueryParams.create().add("append_to_response", appendToResponse)
                ),
                TvSeriesDetails.class
        );
    }

    @Override
    public TvSeriesDetails details(
            TvShowId seriesId,
            Language language,
            AppendToResponse<TvSeriesAppend> appendToResponse
    ) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.details(seriesId),
                        QueryParams.create()
                                .add("language", language)
                                .add("append_to_response", appendToResponse)
                ),
                TvSeriesDetails.class
        );
    }

    @Override
    public TvSeriesAggregateCredits aggregateCredits(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.aggregateCredits(seriesId)),
                TvSeriesAggregateCredits.class
        );
    }

    @Override
    public TvSeriesAggregateCredits aggregateCredits(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.aggregateCredits(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesAggregateCredits.class
        );
    }

    @Override
    public TvSeriesAlternativeTitles alternativeTitles(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.alternativeTitles(seriesId)),
                TvSeriesAlternativeTitles.class
        );
    }

    @Override
    public TvSeriesChanges changes(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.changes(seriesId)),
                TvSeriesChanges.class
        );
    }

    @Override
    public TvSeriesChanges changes(TvShowId seriesId, ChangesQuery query) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(query, "Changes query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.changes(seriesId),
                        query.toQueryParams()
                ),
                TvSeriesChanges.class
        );
    }

    @Override
    public TvSeriesContentRatings contentRatings(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.contentRatings(seriesId)),
                TvSeriesContentRatings.class
        );
    }

    @Override
    public TvSeriesCredits credits(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.credits(seriesId)),
                TvSeriesCredits.class
        );
    }

    @Override
    public TvSeriesCredits credits(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.credits(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesCredits.class
        );
    }

    @Override
    public TvSeriesEpisodeGroups episodeGroups(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.episodeGroups(seriesId)),
                TvSeriesEpisodeGroups.class
        );
    }

    @Override
    public ExternalIds externalIds(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.externalIds(seriesId)),
                ExternalIds.class
        );
    }

    @Override
    public TvSeriesKeywords keywords(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.keywords(seriesId)),
                TvSeriesKeywords.class
        );
    }

    @Override
    public TvSeriesDetails latest() {
        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.latest()),
                TvSeriesDetails.class
        );
    }

    @Override
    public TvSeriesRecommendations recommendations(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.recommendations(seriesId)),
                TvSeriesRecommendations.class
        );
    }

    @Override
    public TvSeriesRecommendations recommendations(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.recommendations(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesRecommendations.class
        );
    }

    @Override
    public TvSeriesRecommendations recommendations(TvShowId seriesId, TvSeriesListQuery query) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.recommendations(seriesId),
                        query.toQueryParams()
                ),
                TvSeriesRecommendations.class
        );
    }

    @Override
    public TvSeriesReviews reviews(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.reviews(seriesId)),
                TvSeriesReviews.class
        );
    }

    @Override
    public TvSeriesReviews reviews(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.reviews(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesReviews.class
        );
    }

    @Override
    public TvSeriesReviews reviews(TvShowId seriesId, TvSeriesListQuery query) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.reviews(seriesId),
                        query.toQueryParams()
                ),
                TvSeriesReviews.class
        );
    }

    @Override
    public TvSeriesScreenedTheatrically screenedTheatrically(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.screenedTheatrically(seriesId)),
                TvSeriesScreenedTheatrically.class
        );
    }

    @Override
    public TvSeriesSimilar similar(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.similar(seriesId)),
                TvSeriesSimilar.class
        );
    }

    @Override
    public TvSeriesSimilar similar(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.similar(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesSimilar.class
        );
    }

    @Override
    public TvSeriesSimilar similar(TvShowId seriesId, TvSeriesListQuery query) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(query, "TV series list query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.similar(seriesId),
                        query.toQueryParams()
                ),
                TvSeriesSimilar.class
        );
    }

    @Override
    public TvSeriesTranslations translations(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.translations(seriesId)),
                TvSeriesTranslations.class
        );
    }

    @Override
    public TvSeriesVideos videos(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.videos(seriesId)),
                TvSeriesVideos.class
        );
    }

    @Override
    public TvSeriesVideos videos(TvShowId seriesId, Language language) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.videos(seriesId),
                        QueryParams.create().add("language", language)
                ),
                TvSeriesVideos.class
        );
    }

    @Override
    public TvSeriesVideos videos(TvShowId seriesId, TvSeriesVideosQuery query) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");
        Objects.requireNonNull(query, "TV series videos query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        TvSeriesPaths.videos(seriesId),
                        query.toQueryParams()
                ),
                TvSeriesVideos.class
        );
    }

    @Override
    public TvSeriesWatchProviders watchProviders(TvShowId seriesId) {
        Objects.requireNonNull(seriesId, "TV series id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.watchProviders(seriesId)),
                TvSeriesWatchProviders.class
        );
    }

    @Override
    public TvShowImages images(TvShowId tvShowId) {
        return images(tvShowId, ImageQuery.none());
    }

    @Override
    public TvShowImages images(TvShowId tvShowId, ImageQuery query) {
        Objects.requireNonNull(tvShowId, "TV show id must not be null");
        Objects.requireNonNull(query, "Image query must not be null");

        return httpClient.get(
                TmdbRequest.get(TvSeriesPaths.images(tvShowId), query.toQueryParams()),
                TvShowImages.class
        );
    }
}
