package dev.reuss.tmdb.common.video;

import java.util.List;

/**
 * Common contract for TMDB responses that contain videos.
 *
 * @param <T> video item type
 */
public interface VideosResponse<T> {

    /**
     * Returns the videos contained in the response.
     *
     * @return immutable list of videos
     */
    List<T> results();

    /**
     * Returns whether the response contains no videos.
     *
     * @return {@code true} if there are no videos
     */
    default boolean isEmpty() {
        return results().isEmpty();
    }

    /**
     * Returns whether the response contains at least one video.
     *
     * @return {@code true} if videos are present
     */
    default boolean hasVideos() {
        return !isEmpty();
    }

    /**
     * Returns the number of videos in the response.
     *
     * @return video count
     */
    default int videoCount() {
        return results().size();
    }
}
