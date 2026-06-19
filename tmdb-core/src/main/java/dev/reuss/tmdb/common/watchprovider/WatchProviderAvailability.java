package dev.reuss.tmdb.common.watchprovider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.domain.watchproviders.model.WatchProvider;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Watch provider availability for a specific region.
 *
 * @param link     TMDB watch provider link
 * @param flatrate flatrate streaming providers
 * @param rent     rental providers
 * @param buy      purchase providers
 * @param ads      ad-supported providers
 * @param free     free providers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WatchProviderAvailability(
        String link,
        List<WatchProvider> flatrate,
        List<WatchProvider> rent,
        List<WatchProvider> buy,
        List<WatchProvider> ads,
        List<WatchProvider> free
) implements TmdbModel {

    public WatchProviderAvailability {
        flatrate = TmdbCollections.list(flatrate);
        rent = TmdbCollections.list(rent);
        buy = TmdbCollections.list(buy);
        ads = TmdbCollections.list(ads);
        free = TmdbCollections.list(free);
    }
}
