package dev.reuss.tmdb.domain.people;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.PersonImages;
import dev.reuss.tmdb.domain.people.model.*;
import dev.reuss.tmdb.query.AppendableResponse;

/**
 * Supported person append_to_response values.
 */
public enum PersonAppend implements AppendableResponse {
    CHANGES("changes", PersonChanges.class),
    COMBINED_CREDITS("combined_credits", PersonCombinedCredits.class),
    EXTERNAL_IDS("external_ids", ExternalIds.class),
    IMAGES("images", PersonImages.class),
    MOVIE_CREDITS("movie_credits", PersonMovieCredits.class),
    TV_CREDITS("tv_credits", PersonTvCredits.class),
    TRANSLATIONS("translations", PersonTranslations.class);

    private final String value;
    private final Class<?> responseType;

    PersonAppend(String value, Class<?> responseType) {
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