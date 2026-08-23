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
 * Main entry point for the TMDB SDK.
 *
 * A [TmdbClient] provides access to TMDB API services such as configuration,
 * images, movies, TV shows, search and watch providers.
 *
 * Client instances should be created through [builder].
 *
 * Example:
 *
 * ```
 * val tmdb = TmdbClient.builder()
 *     .accessToken("your-access-token")
 *     .build()
 * ```
 *
 * Implementations are expected to be reusable. SDK users should usually
 * create one client instance and share it where needed.
 *
 * @see TmdbClientBuilder
 */
interface TmdbClient {

    /**
     * Returns the service for TMDB API configuration metadata.
     */
    fun configuration(): ConfigurationService

    /**
     * Returns the builder for TMDB image URLs.
     */
    fun imageUrls(): ImageUrlBuilder

    /**
     * Returns the service for movie and TV certification lists.
     */
    fun certifications(): CertificationService

    /**
     * Returns the service for TMDB companies.
     */
    fun companies(): CompanyService

    /**
     * Returns the service for credit details.
     */
    fun credits(): CreditService

    /**
     * Returns the service for discovering movies and TV shows.
     */
    fun discover(): DiscoverService

    /**
     * Returns the service for resolving external ids to TMDB resources.
     */
    fun find(): FindService

    /**
     * Returns the service for movie and TV genres.
     */
    fun genres(): GenreService

    /**
     * Returns the service for TMDB keywords.
     */
    fun keywords(): KeywordService

    /**
     * Returns the service for TV networks.
     */
    fun networks(): NetworkService

    /**
     * Returns the service for review details.
     */
    fun reviews(): ReviewService

    /**
     * Returns the service for trending movies, TV shows, people and mixed results.
     */
    fun trending(): TrendingService

    /**
     * Returns the service for watch provider metadata.
     */
    fun watchProviders(): WatchProviderService

    /**
     * Returns the service for TMDB search endpoints.
     */
    fun search(): SearchService

    /**
     * Returns the service for people endpoints.
     */
    fun people(): PersonService

    /**
     * Returns the service for TV series endpoints.
     */
    fun tvSeries(): TvSeriesService

    /**
     * Returns the service for TV season endpoints.
     */
    fun tvSeason(): TvSeasonService

    /**
     * Returns the service for TV episode endpoints.
     */
    fun tvEpisode(): TvEpisodeService

    /**
     * Returns the service for TV episode group endpoints.
     */
    fun tvEpisodeGroup(): TvEpisodeGroupService

    /**
     * Returns the service for movie endpoints.
     */
    fun movies(): MovieService

    /**
     * Returns the service for collection endpoints.
     */
    fun collections(): CollectionService

    companion object {

        /**
         * Creates a new TMDB client builder.
         */
        @JvmStatic
        fun builder(): TmdbClientBuilder = TmdbClientBuilder()
    }

}