package dev.reuss.tmdb.common.change;

import java.util.List;

/**
 * Common contract for TMDB responses that contain change entries.
 */
public interface ChangesResponse {

    /**
     * Returns the changes contained in the response.
     *
     * @return immutable list of changes
     */
    List<Change> changes();

    /**
     * Returns whether the response contains no changes.
     *
     * @return {@code true} if there are no changes
     */
    default boolean isEmpty() {
        return changes().isEmpty();
    }

    /**
     * Returns whether the response contains at least one change.
     *
     * @return {@code true} if changes are present
     */
    default boolean hasChanges() {
        return !isEmpty();
    }

    /**
     * Returns the number of changes in the response.
     *
     * @return change count
     */
    default int changeCount() {
        return changes().size();
    }
}
