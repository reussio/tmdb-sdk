package dev.reuss.tmdb.common.watchprovider;

import dev.reuss.tmdb.value.region.Region;

import java.util.Map;
import java.util.Optional;

/**
 * Common contract for TMDB responses that contain watch provider
 * availabilities grouped by region.
 *
 * @param <T> watch provider region type
 */
public interface WatchProvidersResponse<T> {

    /**
     * Returns watch provider availabilities grouped by region code.
     *
     * @return immutable map of region code to watch provider availability
     */
    Map<String, T> results();

    /**
     * Returns whether the response contains no provider regions.
     *
     * @return {@code true} if there are no provider regions
     */
    default boolean isEmpty() {
        return results().isEmpty();
    }

    /**
     * Returns whether the response contains at least one provider region.
     *
     * @return {@code true} if provider regions are present
     */
    default boolean hasProviders() {
        return !isEmpty();
    }

    /**
     * Returns the number of provider regions.
     *
     * @return region count
     */
    default int regionCount() {
        return results().size();
    }

    /**
     * Returns whether providers are available for the given region.
     *
     * @param region region code, for example {@code DE}
     * @return {@code true} if the region exists
     */
    default boolean hasRegion(String region) {
        return region != null && results().containsKey(region.toUpperCase());
    }

    /**
     * Returns the provider availability for the given region.
     *
     * @param region region code, for example {@code DE}
     * @return optional provider availability
     */
    default Optional<T> region(String region) {
        if (region == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(results().get(region.toUpperCase()));
    }

    default Optional<T> region(Region region) {
        return region == null ? Optional.empty() : region(region.toString());
    }
}