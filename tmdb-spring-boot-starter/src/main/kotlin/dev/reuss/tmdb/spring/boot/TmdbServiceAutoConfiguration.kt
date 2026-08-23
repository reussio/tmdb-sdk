package dev.reuss.tmdb.spring.boot

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
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.SmartInitializingSingleton
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean

/**
 * Autoconfiguration for TMDB domain service beans.
 *
 * This configuration exposes the service instances provided by the configured
 * [TmdbClient] as individual Spring beans.
 */
@AutoConfiguration(after = [TmdbClientAutoConfiguration::class])
@ConditionalOnBean(TmdbClient::class)
class TmdbServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun configurationService(tmdbClient: TmdbClient): ConfigurationService =
        tmdbClient.configuration()

    @Bean
    @ConditionalOnMissingBean
    fun imageUrlBuilder(tmdbClient: TmdbClient): ImageUrlBuilder =
        tmdbClient.imageUrls()

    @Bean
    @ConditionalOnMissingBean
    fun certificationService(tmdbClient: TmdbClient): CertificationService =
        tmdbClient.certifications()

    @Bean
    @ConditionalOnMissingBean
    fun companyService(tmdbClient: TmdbClient): CompanyService =
        tmdbClient.companies()

    @Bean
    @ConditionalOnMissingBean
    fun creditService(tmdbClient: TmdbClient): CreditService =
        tmdbClient.credits()

    @Bean
    @ConditionalOnMissingBean
    fun discoverService(tmdbClient: TmdbClient): DiscoverService =
        tmdbClient.discover()

    @Bean
    @ConditionalOnMissingBean
    fun findService(tmdbClient: TmdbClient): FindService =
        tmdbClient.find()

    @Bean
    @ConditionalOnMissingBean
    fun genreService(tmdbClient: TmdbClient): GenreService =
        tmdbClient.genres()

    @Bean
    @ConditionalOnMissingBean
    fun keywordService(tmdbClient: TmdbClient): KeywordService =
        tmdbClient.keywords()

    @Bean
    @ConditionalOnMissingBean
    fun networkService(tmdbClient: TmdbClient): NetworkService =
        tmdbClient.networks()

    @Bean
    @ConditionalOnMissingBean
    fun reviewService(tmdbClient: TmdbClient): ReviewService =
        tmdbClient.reviews()

    @Bean
    @ConditionalOnMissingBean
    fun trendingService(tmdbClient: TmdbClient): TrendingService =
        tmdbClient.trending()

    @Bean
    @ConditionalOnMissingBean
    fun watchProviderService(tmdbClient: TmdbClient): WatchProviderService =
        tmdbClient.watchProviders()

    @Bean
    @ConditionalOnMissingBean
    fun searchService(tmdbClient: TmdbClient): SearchService =
        tmdbClient.search()

    @Bean
    @ConditionalOnMissingBean
    fun personService(tmdbClient: TmdbClient): PersonService =
        tmdbClient.people()

    @Bean
    @ConditionalOnMissingBean
    fun tvSeriesService(tmdbClient: TmdbClient): TvSeriesService =
        tmdbClient.tvSeries()

    @Bean
    @ConditionalOnMissingBean
    fun tvSeasonService(tmdbClient: TmdbClient): TvSeasonService =
        tmdbClient.tvSeason()

    @Bean
    @ConditionalOnMissingBean
    fun tvEpisodeService(tmdbClient: TmdbClient): TvEpisodeService =
        tmdbClient.tvEpisode()

    @Bean
    @ConditionalOnMissingBean
    fun tvEpisodeGroupService(tmdbClient: TmdbClient): TvEpisodeGroupService =
        tmdbClient.tvEpisodeGroup()

    @Bean
    @ConditionalOnMissingBean
    fun movieService(tmdbClient: TmdbClient): MovieService =
        tmdbClient.movies()

    @Bean
    @ConditionalOnMissingBean
    fun collectionService(tmdbClient: TmdbClient): CollectionService =
        tmdbClient.collections()

    @Bean
    fun tmdbServiceBeansLogger(): SmartInitializingSingleton =
        SmartInitializingSingleton {
            log.debug("Configured TMDB JVM SDK domain service beans")
        }

    companion object {
        private val log =
            LoggerFactory.getLogger(TmdbServiceAutoConfiguration::class.java)
    }
}