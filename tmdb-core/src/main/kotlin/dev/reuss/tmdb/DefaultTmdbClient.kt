package dev.reuss.tmdb

import dev.reuss.tmdb.core.config.TmdbClientConfig
import dev.reuss.tmdb.core.http.JavaNetTmdbHttpClient
import dev.reuss.tmdb.domain.certifications.CertificationService
import dev.reuss.tmdb.domain.certifications.DefaultCertificationService
import dev.reuss.tmdb.domain.collection.CollectionService
import dev.reuss.tmdb.domain.collection.DefaultCollectionService
import dev.reuss.tmdb.domain.companies.CompanyService
import dev.reuss.tmdb.domain.companies.DefaultCompanyService
import dev.reuss.tmdb.domain.configuration.ConfigurationService
import dev.reuss.tmdb.domain.configuration.DefaultConfigurationService
import dev.reuss.tmdb.domain.credits.CreditService
import dev.reuss.tmdb.domain.credits.DefaultCreditService
import dev.reuss.tmdb.domain.discover.DefaultDiscoverService
import dev.reuss.tmdb.domain.discover.DiscoverService
import dev.reuss.tmdb.domain.find.DefaultFindService
import dev.reuss.tmdb.domain.find.FindService
import dev.reuss.tmdb.domain.genres.DefaultGenreService
import dev.reuss.tmdb.domain.genres.GenreService
import dev.reuss.tmdb.domain.images.url.DefaultImageUrlBuilder
import dev.reuss.tmdb.domain.images.url.ImageUrlBuilder
import dev.reuss.tmdb.domain.keywords.DefaultKeywordService
import dev.reuss.tmdb.domain.keywords.KeywordService
import dev.reuss.tmdb.domain.movie.DefaultMovieService
import dev.reuss.tmdb.domain.movie.MovieService
import dev.reuss.tmdb.domain.networks.DefaultNetworkService
import dev.reuss.tmdb.domain.networks.NetworkService
import dev.reuss.tmdb.domain.people.DefaultPersonService
import dev.reuss.tmdb.domain.people.PersonService
import dev.reuss.tmdb.domain.reviews.DefaultReviewService
import dev.reuss.tmdb.domain.reviews.ReviewService
import dev.reuss.tmdb.domain.search.DefaultSearchService
import dev.reuss.tmdb.domain.search.SearchService
import dev.reuss.tmdb.domain.trending.DefaultTrendingService
import dev.reuss.tmdb.domain.trending.TrendingService
import dev.reuss.tmdb.domain.tv.episode.DefaultTvEpisodeService
import dev.reuss.tmdb.domain.tv.episode.TvEpisodeService
import dev.reuss.tmdb.domain.tv.episodegroup.DefaultTvEpisodeGroupService
import dev.reuss.tmdb.domain.tv.episodegroup.TvEpisodeGroupService
import dev.reuss.tmdb.domain.tv.season.DefaultTvSeasonService
import dev.reuss.tmdb.domain.tv.season.TvSeasonService
import dev.reuss.tmdb.domain.tv.series.DefaultTvSeriesService
import dev.reuss.tmdb.domain.tv.series.TvSeriesService
import dev.reuss.tmdb.domain.watchproviders.DefaultWatchProviderService
import dev.reuss.tmdb.domain.watchproviders.WatchProviderService

internal class DefaultTmdbClient(
    config: TmdbClientConfig,
) : TmdbClient {
    private val httpClient = JavaNetTmdbHttpClient(config)

    private val configuration = DefaultConfigurationService(httpClient)
    private val imageUrls = DefaultImageUrlBuilder(configuration)
    private val certifications = DefaultCertificationService(httpClient)
    private val companies = DefaultCompanyService(httpClient)
    private val credits = DefaultCreditService(httpClient)
    private val discover = DefaultDiscoverService(httpClient)
    private val find = DefaultFindService(httpClient)
    private val genres = DefaultGenreService(httpClient)
    private val keywords = DefaultKeywordService(httpClient)
    private val networks = DefaultNetworkService(httpClient)
    private val reviews = DefaultReviewService(httpClient)
    private val trending = DefaultTrendingService(httpClient)
    private val watchProviders = DefaultWatchProviderService(httpClient)
    private val search = DefaultSearchService(httpClient)
    private val people = DefaultPersonService(httpClient)
    private val tvSeries = DefaultTvSeriesService(httpClient)
    private val tvSeason = DefaultTvSeasonService(httpClient)
    private val tvEpisode = DefaultTvEpisodeService(httpClient)
    private val tvEpisodeGroup = DefaultTvEpisodeGroupService(httpClient)
    private val movies = DefaultMovieService(httpClient)
    private val collections = DefaultCollectionService(httpClient)

    override fun configuration(): ConfigurationService = configuration

    override fun imageUrls(): ImageUrlBuilder = imageUrls

    override fun certifications(): CertificationService = certifications

    override fun companies(): CompanyService = companies

    override fun credits(): CreditService = credits

    override fun discover(): DiscoverService = discover

    override fun find(): FindService = find

    override fun genres(): GenreService = genres

    override fun keywords(): KeywordService = keywords

    override fun networks(): NetworkService = networks

    override fun reviews(): ReviewService = reviews

    override fun trending(): TrendingService = trending

    override fun watchProviders(): WatchProviderService = watchProviders

    override fun search(): SearchService = search

    override fun people(): PersonService = people

    override fun tvSeries(): TvSeriesService = tvSeries

    override fun tvSeason(): TvSeasonService = tvSeason

    override fun tvEpisode(): TvEpisodeService = tvEpisode

    override fun tvEpisodeGroup(): TvEpisodeGroupService = tvEpisodeGroup

    override fun movies(): MovieService = movies

    override fun collections(): CollectionService = collections
}
