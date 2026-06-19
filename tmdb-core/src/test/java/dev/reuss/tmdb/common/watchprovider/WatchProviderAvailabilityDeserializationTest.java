package dev.reuss.tmdb.common.watchprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.reuss.tmdb.domain.movie.model.MovieWatchProviders;
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonWatchProviders;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesWatchProviders;
import dev.reuss.tmdb.domain.watchproviders.model.WatchProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WatchProviderAvailabilityDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void deserializesMovieWatchProviders() throws Exception {
        MovieWatchProviders providers = objectMapper.readValue(watchProvidersJson(550), MovieWatchProviders.class);

        assertEquals(550, providers.id());
        assertAvailability(providers.results().get("DE"));
    }

    @Test
    void deserializesTvSeriesWatchProviders() throws Exception {
        TvSeriesWatchProviders providers = objectMapper.readValue(watchProvidersJson(1399), TvSeriesWatchProviders.class);

        assertEquals(1399, providers.id());
        assertAvailability(providers.results().get("DE"));
    }

    @Test
    void deserializesTvSeasonWatchProviders() throws Exception {
        TvSeasonWatchProviders providers = objectMapper.readValue(watchProvidersJson(3624), TvSeasonWatchProviders.class);

        assertEquals(3624, providers.id());
        assertAvailability(providers.results().get("DE"));
    }

    @Test
    void normalizesMissingProviderListsToEmptyLists() throws Exception {
        MovieWatchProviders providers = objectMapper.readValue("""
                {
                  "id": 550,
                  "results": {
                    "DE": {
                      "link": "https://www.themoviedb.org/movie/550-fight-club/watch?locale=DE",
                      "flatrate": null
                    }
                  }
                }
                """, MovieWatchProviders.class);

        WatchProviderAvailability availability = providers.results().get("DE");
        assertTrue(availability.flatrate().isEmpty());
        assertTrue(availability.rent().isEmpty());
        assertTrue(availability.buy().isEmpty());
        assertTrue(availability.ads().isEmpty());
        assertTrue(availability.free().isEmpty());
    }

    @Test
    void normalizesMissingResultsToEmptyMap() throws Exception {
        MovieWatchProviders providers = objectMapper.readValue("""
                {
                  "id": 550
                }
                """, MovieWatchProviders.class);

        assertTrue(providers.results().isEmpty());
    }

    private static void assertAvailability(WatchProviderAvailability availability) {
        assertEquals("https://www.themoviedb.org/movie/550-fight-club/watch?locale=DE", availability.link());
        assertProvider(availability.flatrate().get(0));
        assertProvider(availability.rent().get(0));
        assertProvider(availability.buy().get(0));
        assertProvider(availability.ads().get(0));
        assertProvider(availability.free().get(0));
    }

    private static void assertProvider(WatchProvider provider) {
        assertEquals("/provider.png", provider.logoPath());
        assertEquals("Example Provider", provider.providerName());
        assertEquals(337, provider.providerId());
        assertEquals(2, provider.displayPriority());
    }

    private static String watchProvidersJson(int id) {
        return """
                {
                  "id": %d,
                  "results": {
                    "DE": {
                      "link": "https://www.themoviedb.org/movie/550-fight-club/watch?locale=DE",
                      "flatrate": [%s],
                      "rent": [%s],
                      "buy": [%s],
                      "ads": [%s],
                      "free": [%s]
                    }
                  }
                }
                """.formatted(id, providerJson(), providerJson(), providerJson(), providerJson(), providerJson());
    }

    private static String providerJson() {
        return """
                {
                  "logo_path": "/provider.png",
                  "provider_name": "Example Provider",
                  "provider_id": 337,
                  "display_priority": 2
                }
                """;
    }
}
