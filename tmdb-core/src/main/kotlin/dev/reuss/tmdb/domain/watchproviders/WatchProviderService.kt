package dev.reuss.tmdb.domain.watchproviders

import dev.reuss.tmdb.domain.watchproviders.model.WatchProviderRegions
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviders
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Loads the streaming and purchase providers known to TMDB.
 *
 * These endpoints describe provider catalogs and their display priorities. Availability for one
 * particular movie or TV series is exposed by that resource's watch-provider endpoint.
 */
interface WatchProviderService {
    /** Returns countries for which TMDB has watch-provider data. */
    fun regions(): WatchProviderRegions

    /** Returns watch-provider countries with their names localized in [language]. */
    fun regions(language: Language): WatchProviderRegions

    /** Returns movie providers for all regions using default localization. */
    fun movies(): WatchProviders

    /** Returns movie providers for all regions, localized in [language]. */
    fun movies(language: Language): WatchProviders

    /** Returns movie providers available in [watchRegion]. */
    fun movies(watchRegion: Region): WatchProviders

    /** Returns movie providers in [watchRegion], localized in [language]. */
    fun movies(
        watchRegion: Region,
        language: Language,
    ): WatchProviders

    /** Returns TV providers for all regions using default localization. */
    fun tv(): WatchProviders

    /** Returns TV providers for all regions, localized in [language]. */
    fun tv(language: Language): WatchProviders

    /** Returns TV providers available in [watchRegion]. */
    fun tv(watchRegion: Region): WatchProviders

    /** Returns TV providers in [watchRegion], localized in [language]. */
    fun tv(
        watchRegion: Region,
        language: Language,
    ): WatchProviders
}
