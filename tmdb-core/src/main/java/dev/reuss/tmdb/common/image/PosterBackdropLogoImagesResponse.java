package dev.reuss.tmdb.common.image;

import java.util.List;

/**
 * Common contract for TMDB image responses that contain backdrops, logos and posters.
 */
public interface PosterBackdropLogoImagesResponse {

    /**
     * Returns backdrop images.
     *
     * @return immutable list of backdrop images
     */
    List<TmdbImage> backdrops();

    /**
     * Returns logo images.
     *
     * @return immutable list of logo images
     */
    List<TmdbImage> logos();

    /**
     * Returns poster images.
     *
     * @return immutable list of poster images
     */
    List<TmdbImage> posters();

    /**
     * Returns whether the response contains no images.
     *
     * @return {@code true} if all image lists are empty
     */
    default boolean isEmpty() {
        return backdrops().isEmpty()
                && logos().isEmpty()
                && posters().isEmpty();
    }

    /**
     * Returns whether the response contains at least one image.
     *
     * @return {@code true} if any image is present
     */
    default boolean hasImages() {
        return !isEmpty();
    }

    /**
     * Returns whether the response contains at least one backdrop.
     *
     * @return {@code true} if backdrops are present
     */
    default boolean hasBackdrops() {
        return !backdrops().isEmpty();
    }

    /**
     * Returns whether the response contains at least one logo.
     *
     * @return {@code true} if logos are present
     */
    default boolean hasLogos() {
        return !logos().isEmpty();
    }

    /**
     * Returns whether the response contains at least one poster.
     *
     * @return {@code true} if posters are present
     */
    default boolean hasPosters() {
        return !posters().isEmpty();
    }

    /**
     * Returns the number of backdrop images.
     *
     * @return backdrop count
     */
    default int backdropCount() {
        return backdrops().size();
    }

    /**
     * Returns the number of logo images.
     *
     * @return logo count
     */
    default int logoCount() {
        return logos().size();
    }

    /**
     * Returns the number of poster images.
     *
     * @return poster count
     */
    default int posterCount() {
        return posters().size();
    }

    /**
     * Returns the total number of images.
     *
     * @return total image count
     */
    default int imageCount() {
        return backdropCount() + logoCount() + posterCount();
    }
}
