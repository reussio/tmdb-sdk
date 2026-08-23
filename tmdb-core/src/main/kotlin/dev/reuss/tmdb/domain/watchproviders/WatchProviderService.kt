package dev.reuss.tmdb.domain.watchproviders

import dev.reuss.tmdb.domain.watchproviders.model.WatchProviderRegions
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviders
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Service for loading TMDB watch provider metadata.
 */
interface WatchProviderService {

    /**
     * Loads all available watch provider regions.
     *
     * @return watch provider regions
     */
    fun regions(): WatchProviderRegions

    /**
     * Loads all available watch provider regions using a specific language.
     *
     * @param language response language
     * @return localized watch provider regions
     */
    fun regions(language: Language): WatchProviderRegions

    /**
     * Loads all available movie watch providers.
     *
     * @return movie watch providers
     */
    fun movies(): WatchProviders

    /**
     * Loads all available movie watch providers using a specific language.
     *
     * @param language response language
     * @return localized movie watch providers
     */
    fun movies(language: Language): WatchProviders

    /**
     * Loads movie watch providers for a specific watch region.
     *
     * @param watchRegion watch region
     * @return movie watch providers for the region
     */
    fun movies(watchRegion: Region): WatchProviders

    /**
     * Loads movie watch providers for a specific watch region using a specific language.
     *
     * @param watchRegion watch region
     * @param language response language
     * @return localized movie watch providers for the region
     */
    fun movies(
        watchRegion: Region,
        language: Language
    ): WatchProviders

    /**
     * Loads all available TV watch providers.
     *
     * @return TV watch providers
     */
    fun tv(): WatchProviders

    /**
     * Loads all available TV watch providers using a specific language.
     *
     * @param language response language
     * @return localized TV watch providers
     */
    fun tv(language: Language): WatchProviders

    /**
     * Loads TV watch providers for a specific watch region.
     *
     * @param watchRegion watch region
     * @return TV watch providers for the region
     */
    fun tv(watchRegion: Region): WatchProviders

    /**
     * Loads TV watch providers for a specific watch region using a specific language.
     *
     * @param watchRegion watch region
     * @param language response language
     * @return localized TV watch providers for the region
     */
    fun tv(
        watchRegion: Region,
        language: Language
    ): WatchProviders
}