package dev.reuss.tmdb.domain.tv.season;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvSeasonImages;
import dev.reuss.tmdb.domain.tv.season.model.*;
import dev.reuss.tmdb.query.AppendableResponse;

public enum TvSeasonAppend implements AppendableResponse {

    AGGREGATE_CREDITS("aggregate_credits", TvSeasonAggregateCredits.class),
    CHANGES("changes", TvSeasonChanges.class),
    CREDITS("credits", TvSeasonCredits.class),
    EXTERNAL_IDS("external_ids", ExternalIds.class),
    IMAGES("images", TvSeasonImages.class),
    TRANSLATIONS("translations", TvSeasonTranslations.class),
    VIDEOS("videos", TvSeasonVideos.class),
    WATCH_PROVIDERS("watch/providers", TvSeasonWatchProviders.class);

    private final String value;
    private final Class<?> responseType;

    TvSeasonAppend(String value, Class<?> responseType) {
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
