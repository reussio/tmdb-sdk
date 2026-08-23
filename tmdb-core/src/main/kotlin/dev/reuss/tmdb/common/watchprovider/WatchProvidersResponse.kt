package dev.reuss.tmdb.common.watchprovider

import dev.reuss.tmdb.value.region.Region
import java.util.*

/**
 * Common contract for TMDB responses that contain watch provider
 * availabilities grouped by region.
 *
 * @property <T> watch provider region type
 */

interface WatchProvidersResponse<T : Any> {

    val results: Map<String, T>

    fun isEmpty(): Boolean {
        return results.isEmpty()
    }

    fun hasProviders(): Boolean {
        return !isEmpty()
    }

    fun regionCount(): Int {
        return results.size
    }

    fun hasRegion(region: String?): Boolean {
        return region != null && results.containsKey(region.uppercase())
    }

    fun region(region: String?): Optional<T> {
        if (region == null) {
            return Optional.empty<T>()
        }

        return Optional.ofNullable(results.get(region.uppercase()))
    }

    fun region(region: Region?): Optional<T> {
        return if (region == null) Optional.empty<T>() else region(region.toString())
    }
}
