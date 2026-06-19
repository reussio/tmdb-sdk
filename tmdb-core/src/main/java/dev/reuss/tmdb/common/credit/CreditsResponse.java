package dev.reuss.tmdb.common.credit;

import java.util.List;

/**
 * Common contract for TMDB responses that contain cast and crew credits.
 *
 * @param <C> cast credit type
 * @param <R> crew credit type
 */
public interface CreditsResponse<C, R> {

    /**
     * Returns the cast credits contained in the response.
     *
     * @return immutable list of cast credits
     */
    List<C> cast();

    /**
     * Returns the crew credits contained in the response.
     *
     * @return immutable list of crew credits
     */
    List<R> crew();

    /**
     * Returns whether the response contains no cast and no crew credits.
     *
     * @return {@code true} if cast and crew are empty
     */
    default boolean isEmpty() {
        return cast().isEmpty() && crew().isEmpty();
    }

    /**
     * Returns whether the response contains at least one cast credit.
     *
     * @return {@code true} if cast credits are present
     */
    default boolean hasCast() {
        return !cast().isEmpty();
    }

    /**
     * Returns whether the response contains at least one crew credit.
     *
     * @return {@code true} if crew credits are present
     */
    default boolean hasCrew() {
        return !crew().isEmpty();
    }

    /**
     * Returns whether the response contains at least one cast or crew credit.
     *
     * @return {@code true} if credits are present
     */
    default boolean hasCredits() {
        return !isEmpty();
    }

    /**
     * Returns the number of cast credits.
     *
     * @return cast count
     */
    default int castCount() {
        return cast().size();
    }

    /**
     * Returns the number of crew credits.
     *
     * @return crew count
     */
    default int crewCount() {
        return crew().size();
    }

    /**
     * Returns the total number of cast and crew credits.
     *
     * @return total credit count
     */
    default int creditCount() {
        return castCount() + crewCount();
    }
}
