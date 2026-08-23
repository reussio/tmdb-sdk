package dev.reuss.tmdb.domain.watchproviders

import dev.reuss.tmdb.domain.watchproviders.model.WatchProviderRegions
import dev.reuss.tmdb.domain.watchproviders.model.WatchProviders
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Test

class DefaultWatchProviderServiceTest {
    @Test
    fun regions_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<WatchProviderRegions>("/watch/providers/regions") {
            DefaultWatchProviderService(it).regions()
        }
        assertRequest<WatchProviderRegions>(
            "/watch/providers/regions",
            mapOf("language" to "de-DE"),
        ) {
            DefaultWatchProviderService(it).regions(Languages.DE_DE)
        }
    }

    @Test
    fun movies_shouldSupportAllLanguageAndRegionOverloads() {
        assertRequest<WatchProviders>("/watch/providers/movie") {
            DefaultWatchProviderService(it).movies()
        }
        assertRequest<WatchProviders>(
            "/watch/providers/movie",
            mapOf("language" to "de-DE"),
        ) {
            DefaultWatchProviderService(it).movies(Languages.DE_DE)
        }
        assertRequest<WatchProviders>(
            "/watch/providers/movie",
            mapOf("watch_region" to "DE"),
        ) {
            DefaultWatchProviderService(it).movies(Regions.DE)
        }
        assertRequest<WatchProviders>(
            "/watch/providers/movie",
            mapOf("watch_region" to "DE", "language" to "de-DE"),
        ) {
            DefaultWatchProviderService(it).movies(Regions.DE, Languages.DE_DE)
        }
    }

    @Test
    fun tv_shouldSupportAllLanguageAndRegionOverloads() {
        assertRequest<WatchProviders>("/watch/providers/tv") {
            DefaultWatchProviderService(it).tv()
        }
        assertRequest<WatchProviders>(
            "/watch/providers/tv",
            mapOf("language" to "de-DE"),
        ) {
            DefaultWatchProviderService(it).tv(Languages.DE_DE)
        }
        assertRequest<WatchProviders>(
            "/watch/providers/tv",
            mapOf("watch_region" to "DE"),
        ) {
            DefaultWatchProviderService(it).tv(Regions.DE)
        }
        assertRequest<WatchProviders>(
            "/watch/providers/tv",
            mapOf("watch_region" to "DE", "language" to "de-DE"),
        ) {
            DefaultWatchProviderService(it).tv(Regions.DE, Languages.DE_DE)
        }
    }
}
