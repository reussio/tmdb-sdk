package dev.reuss.tmdb

import dev.reuss.tmdb.TmdbClient.Companion.builder
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

/**
 * Entry point for the TMDB API exposed by this SDK.
 *
 * Create the default implementation with [builder]. The resulting client reuses
 * its service instances and underlying HTTP client, so applications can share one
 * client instead of creating one per request. API, transport, and response-mapping
 * failures are reported through the SDK exception hierarchy rooted at
 * [dev.reuss.tmdb.core.exception.TmdbException].
 *
 * Example:
 *
 * ```
 * val tmdb = TmdbClient.builder()
 *     .accessToken("your-access-token")
 *     .build()
 * ```
 *
 * @see TmdbClientBuilder
 */
interface TmdbClient {
    fun configuration(): ConfigurationService

    fun imageUrls(): ImageUrlBuilder

    fun certifications(): CertificationService

    fun companies(): CompanyService

    fun credits(): CreditService

    fun discover(): DiscoverService

    fun find(): FindService

    fun genres(): GenreService

    fun keywords(): KeywordService

    fun networks(): NetworkService

    fun reviews(): ReviewService

    fun trending(): TrendingService

    fun watchProviders(): WatchProviderService

    fun search(): SearchService

    fun people(): PersonService

    fun tvSeries(): TvSeriesService

    fun tvSeason(): TvSeasonService

    fun tvEpisode(): TvEpisodeService

    fun tvEpisodeGroup(): TvEpisodeGroupService

    fun movies(): MovieService

    fun collections(): CollectionService

    companion object {
        /** Creates an independently configurable client builder. */
        @JvmStatic
        fun builder(): TmdbClientBuilder = TmdbClientBuilder()
    }
}
