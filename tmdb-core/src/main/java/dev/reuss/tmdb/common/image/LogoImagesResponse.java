package dev.reuss.tmdb.common.image;

import java.util.List;

/**
 * Common contract for TMDB image responses that contain logo images.
 */
public interface LogoImagesResponse {

    /**
     * Returns logo images.
     *
     * @return immutable list of logo images
     */
    List<LogoImage> logos();

    /**
     * Returns whether the response contains no logos.
     *
     * @return {@code true} if there are no logos
     */
    default boolean isEmpty() {
        return logos().isEmpty();
    }

    /**
     * Returns whether the response contains at least one logo.
     *
     * @return {@code true} if logos are present
     */
    default boolean hasLogos() {
        return !isEmpty();
    }

    /**
     * Returns the number of logo images.
     *
     * @return logo count
     */
    default int logoCount() {
        return logos().size();
    }
}