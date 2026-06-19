package dev.reuss.tmdb.domain.watchproviders;

import dev.reuss.tmdb.domain.watchproviders.model.WatchProviderRegions;
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviders;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

/**
 * Service for loading TMDB watch provider metadata.
 */
public interface WatchProviderService {

    WatchProviderRegions regions();

    WatchProviderRegions regions(Language language);

    /**
     * Loads all available movie watch providers.
     *
     * @return movie watch providers
     */
    WatchProviders movies();

    /**
     * Loads all available movie watch providers using a specific language.
     *
     * @param language response language
     * @return localized movie watch providers
     */
    WatchProviders movies(Language language);

    /**
     * Loads movie watch providers for a specific watch region.
     *
     * @param watchRegion watch region
     * @return movie watch providers for the region
     */
    WatchProviders movies(Region watchRegion);

    /**
     * Loads movie watch providers for a specific watch region using a specific language.
     *
     * @param watchRegion watch region
     * @param language    response language
     * @return localized movie watch providers for the region
     */
    WatchProviders movies(Region watchRegion, Language language);

    /**
     * Loads all available TV watch providers.
     *
     * @return TV watch providers
     */
    WatchProviders tv();

    /**
     * Loads all available TV watch providers using a specific language.
     *
     * @param language response language
     * @return localized TV watch providers
     */
    WatchProviders tv(Language language);

    /**
     * Loads TV watch providers for a specific watch region.
     *
     * @param watchRegion watch region
     * @return TV watch providers for the region
     */
    WatchProviders tv(Region watchRegion);

    /**
     * Loads TV watch providers for a specific watch region using a specific language.
     *
     * @param watchRegion watch region
     * @param language    response language
     * @return localized TV watch providers for the region
     */
    WatchProviders tv(Region watchRegion, Language language);
}