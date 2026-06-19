package dev.reuss.tmdb.domain.tv.series;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvShowImages;
import dev.reuss.tmdb.domain.tv.series.model.*;
import dev.reuss.tmdb.query.AppendableResponse;

/**
 * Supported TV series append_to_response values.
 */
public enum TvSeriesAppend implements AppendableResponse {
    AGGREGATE_CREDITS("aggregate_credits", TvSeriesAggregateCredits.class),
    ALTERNATIVE_TITLES("alternative_titles", TvSeriesAlternativeTitles.class),
    CHANGES("changes", TvSeriesChanges.class),
    CONTENT_RATINGS("content_ratings", TvSeriesContentRatings.class),
    CREDITS("credits", TvSeriesCredits.class),
    EPISODE_GROUPS("episode_groups", TvSeriesEpisodeGroups.class),
    EXTERNAL_IDS("external_ids", ExternalIds.class),
    IMAGES("images", TvShowImages.class),
    KEYWORDS("keywords", TvSeriesKeywords.class),
    RECOMMENDATIONS("recommendations", TvSeriesRecommendations.class),
    REVIEWS("reviews", TvSeriesReviews.class),
    SCREENED_THEATRICALLY("screened_theatrically", TvSeriesScreenedTheatrically.class),
    SIMILAR("similar", TvSeriesSimilar.class),
    TRANSLATIONS("translations", TvSeriesTranslations.class),
    VIDEOS("videos", TvSeriesVideos.class),
    WATCH_PROVIDERS("watch/providers", TvSeriesWatchProviders.class);

    private final String value;
    private final Class<?> responseType;

    TvSeriesAppend(String value, Class<?> responseType) {
        this.value = value;
        this.responseType = responseType;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public Class<?> responseType() {
        return responseType;
    }
}