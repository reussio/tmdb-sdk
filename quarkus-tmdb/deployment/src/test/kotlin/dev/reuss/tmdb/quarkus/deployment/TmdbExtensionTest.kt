package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.domain.certifications.CertificationService
import dev.reuss.tmdb.domain.collection.CollectionService
import dev.reuss.tmdb.domain.companies.CompanyService
import dev.reuss.tmdb.domain.configuration.ConfigurationService
import dev.reuss.tmdb.domain.credits.CreditService
import dev.reuss.tmdb.domain.discover.DiscoverService
import dev.reuss.tmdb.domain.find.FindService
import dev.reuss.tmdb.domain.genres.GenreService
import dev.reuss.tmdb.domain.images.url.ImageUrlBuilder
import dev.reuss.tmdb.domain.keywords.KeywordService
import dev.reuss.tmdb.domain.movie.MovieService
import dev.reuss.tmdb.domain.networks.NetworkService
import dev.reuss.tmdb.domain.people.PersonService
import dev.reuss.tmdb.domain.reviews.ReviewService
import dev.reuss.tmdb.domain.search.SearchService
import dev.reuss.tmdb.domain.trending.TrendingService
import dev.reuss.tmdb.domain.tv.episode.TvEpisodeService
import dev.reuss.tmdb.domain.tv.episodegroup.TvEpisodeGroupService
import dev.reuss.tmdb.domain.tv.season.TvSeasonService
import dev.reuss.tmdb.domain.tv.series.TvSeriesService
import dev.reuss.tmdb.domain.watchproviders.WatchProviderService
import dev.reuss.tmdb.quarkus.runtime.TmdbConfig
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer
import io.quarkus.test.QuarkusExtensionTest
import jakarta.inject.Inject
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.asset.StringAsset
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class TmdbExtensionTest {
    @Inject
    lateinit var client: TmdbClient

    @Inject
    lateinit var configurationService: ConfigurationService

    @Inject
    lateinit var imageUrlBuilder: ImageUrlBuilder

    @Inject
    lateinit var certificationService: CertificationService

    @Inject
    lateinit var collectionService: CollectionService

    @Inject
    lateinit var companyService: CompanyService

    @Inject
    lateinit var creditService: CreditService

    @Inject
    lateinit var discoverService: DiscoverService

    @Inject
    lateinit var findService: FindService

    @Inject
    lateinit var genreService: GenreService

    @Inject
    lateinit var keywordService: KeywordService

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var reviewService: ReviewService

    @Inject
    lateinit var trendingService: TrendingService

    @Inject
    lateinit var watchProviderService: WatchProviderService

    @Inject
    lateinit var searchService: SearchService

    @Inject
    lateinit var personService: PersonService

    @Inject
    lateinit var tvSeriesService: TvSeriesService

    @Inject
    lateinit var tvSeasonService: TvSeasonService

    @Inject
    lateinit var tvEpisodeService: TvEpisodeService

    @Inject
    lateinit var tvEpisodeGroupService: TvEpisodeGroupService

    @Inject
    lateinit var movieService: MovieService

    @Test
    fun shouldProduceTmdbClient() {
        assertNotNull(client)
    }

    @Test
    fun shouldProduceAllDomainServices() {
        assertNotNull(configurationService)
        assertNotNull(imageUrlBuilder)
        assertNotNull(certificationService)
        assertNotNull(collectionService)
        assertNotNull(companyService)
        assertNotNull(creditService)
        assertNotNull(discoverService)
        assertNotNull(findService)
        assertNotNull(genreService)
        assertNotNull(keywordService)
        assertNotNull(networkService)
        assertNotNull(reviewService)
        assertNotNull(trendingService)
        assertNotNull(watchProviderService)
        assertNotNull(searchService)
        assertNotNull(personService)
        assertNotNull(tvSeriesService)
        assertNotNull(tvSeasonService)
        assertNotNull(tvEpisodeService)
        assertNotNull(tvEpisodeGroupService)
        assertNotNull(movieService)
    }

    @Test
    fun shouldUseSameClientForProducedServices() {
        assertSame(client.configuration(), configurationService)
        assertSame(client.imageUrls(), imageUrlBuilder)
        assertSame(client.certifications(), certificationService)
        assertSame(client.collections(), collectionService)
        assertSame(client.companies(), companyService)
        assertSame(client.credits(), creditService)
        assertSame(client.discover(), discoverService)
        assertSame(client.find(), findService)
        assertSame(client.genres(), genreService)
        assertSame(client.keywords(), keywordService)
        assertSame(client.networks(), networkService)
        assertSame(client.reviews(), reviewService)
        assertSame(client.trending(), trendingService)
        assertSame(client.watchProviders(), watchProviderService)
        assertSame(client.search(), searchService)
        assertSame(client.people(), personService)
        assertSame(client.tvSeries(), tvSeriesService)
        assertSame(client.tvSeason(), tvSeasonService)
        assertSame(client.tvEpisode(), tvEpisodeService)
        assertSame(client.tvEpisodeGroup(), tvEpisodeGroupService)
        assertSame(client.movies(), movieService)
    }

    companion object {
        @JvmField
        @RegisterExtension
        val app =
            QuarkusExtensionTest()
                .withApplicationRoot { jar ->
                    jar
                        .addClasses(
                            TmdbProducer::class.java,
                            TmdbConfig::class.java,
                        ).addAsManifestResource(
                            EmptyAsset.INSTANCE,
                            "beans.xml",
                        ).addAsResource(
                            StringAsset(
                                """
                                tmdb.access-token=test-token
                                tmdb.default-language=de-DE
                                tmdb.default-region=DE
                                """.trimIndent(),
                            ),
                            "application.properties",
                        )
                }
    }
}
