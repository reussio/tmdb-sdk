package dev.reuss.tmdb.quarkus.runtime

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
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
import io.quarkus.arc.DefaultBean
import jakarta.enterprise.inject.Produces
import jakarta.inject.Singleton

/**
 * Produces TMDB SDK beans for Quarkus applications.
 */
@Singleton
class TmdbProducer {
    @Produces
    @Singleton
    @DefaultBean
    fun tmdbMetricsRecorder(): TmdbMetricsRecorder = TmdbMetricsRecorder.NOOP

    @Produces
    @Singleton
    @DefaultBean
    fun configurationService(client: TmdbClient): ConfigurationService = client.configuration()

    @Produces
    @Singleton
    @DefaultBean
    fun imageUrlBuilder(client: TmdbClient): ImageUrlBuilder = client.imageUrls()

    @Produces
    @Singleton
    @DefaultBean
    fun certificationService(client: TmdbClient): CertificationService = client.certifications()

    @Produces
    @Singleton
    @DefaultBean
    fun collectionService(client: TmdbClient): CollectionService = client.collections()

    @Produces
    @Singleton
    @DefaultBean
    fun companyService(client: TmdbClient): CompanyService = client.companies()

    @Produces
    @Singleton
    @DefaultBean
    fun creditService(client: TmdbClient): CreditService = client.credits()

    @Produces
    @Singleton
    @DefaultBean
    fun discoverService(client: TmdbClient): DiscoverService = client.discover()

    @Produces
    @Singleton
    @DefaultBean
    fun findService(client: TmdbClient): FindService = client.find()

    @Produces
    @Singleton
    @DefaultBean
    fun genreService(client: TmdbClient): GenreService = client.genres()

    @Produces
    @Singleton
    @DefaultBean
    fun keywordService(client: TmdbClient): KeywordService = client.keywords()

    @Produces
    @Singleton
    @DefaultBean
    fun movieService(client: TmdbClient): MovieService = client.movies()

    @Produces
    @Singleton
    @DefaultBean
    fun networkService(client: TmdbClient): NetworkService = client.networks()

    @Produces
    @Singleton
    @DefaultBean
    fun personService(client: TmdbClient): PersonService = client.people()

    @Produces
    @Singleton
    @DefaultBean
    fun reviewService(client: TmdbClient): ReviewService = client.reviews()

    @Produces
    @Singleton
    @DefaultBean
    fun searchService(client: TmdbClient): SearchService = client.search()

    @Produces
    @Singleton
    @DefaultBean
    fun trendingService(client: TmdbClient): TrendingService = client.trending()

    @Produces
    @Singleton
    @DefaultBean
    fun tvEpisodeService(client: TmdbClient): TvEpisodeService = client.tvEpisode()

    @Produces
    @Singleton
    @DefaultBean
    fun tvEpisodeGroupService(client: TmdbClient): TvEpisodeGroupService = client.tvEpisodeGroup()

    @Produces
    @Singleton
    @DefaultBean
    fun tvSeasonService(client: TmdbClient): TvSeasonService = client.tvSeason()

    @Produces
    @Singleton
    @DefaultBean
    fun tvSeriesService(client: TmdbClient): TvSeriesService = client.tvSeries()

    @Produces
    @Singleton
    @DefaultBean
    fun watchProviderService(client: TmdbClient): WatchProviderService = client.watchProviders()
}
