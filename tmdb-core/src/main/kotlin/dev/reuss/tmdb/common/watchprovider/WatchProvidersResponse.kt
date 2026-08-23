package dev.reuss.tmdb.common.watchprovider

import dev.reuss.tmdb.value.region.Region
import java.util.Optional

/**
 * Common contract for TMDB responses that contain watch provider
 * availabilities grouped by region.
 *
 * @property <T> watch provider region type
 */

interface WatchProvidersResponse<T : Any> {
    val results: Map<String, T>

    fun isEmpty(): Boolean = results.isEmpty()

    fun hasProviders(): Boolean = !isEmpty()

    fun regionCount(): Int = results.size

    fun hasRegion(region: String?): Boolean = region != null && results.containsKey(region.uppercase())

    fun region(region: String?): Optional<T> {
        if (region == null) {
            return Optional.empty<T>()
        }

        return Optional.ofNullable(results.get(region.uppercase()))
    }

    fun region(region: Region?): Optional<T> = if (region == null) Optional.empty<T>() else region(region.toString())
}
