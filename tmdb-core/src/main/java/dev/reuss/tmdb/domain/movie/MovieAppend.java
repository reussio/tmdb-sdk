package dev.reuss.tmdb.domain.movie;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.MovieImages;
import dev.reuss.tmdb.domain.movie.model.*;
import dev.reuss.tmdb.query.AppendableResponse;

public enum MovieAppend implements AppendableResponse {

    ALTERNATIVE_TITLES("alternative_titles", MovieAlternativeTitles.class),
    CHANGES("changes", MovieChanges.class),
    CREDITS("credits", MovieCredits.class),
    EXTERNAL_IDS("external_ids", ExternalIds.class),
    IMAGES("images", MovieImages.class),
    KEYWORDS("keywords", MovieKeywords.class),
    RECOMMENDATIONS("recommendations", MovieRecommendations.class),
    RELEASE_DATES("release_dates", MovieReleaseDates.class),
    REVIEWS("reviews", MovieReviews.class),
    SIMILAR("similar", SimilarMovies.class),
    TRANSLATIONS("translations", MovieTranslations.class),
    VIDEOS("videos", MovieVideos.class),
    WATCH_PROVIDERS("watch/providers", MovieWatchProviders.class);

    private final String value;
    private final Class<?> responseType;

    MovieAppend(String value, Class<?> responseType) {
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