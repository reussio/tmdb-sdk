package dev.reuss.tmdb;

import dev.reuss.tmdb.core.config.TmdbClientConfig;
import dev.reuss.tmdb.core.http.JavaNetTmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.domain.certifications.CertificationService;
import dev.reuss.tmdb.domain.certifications.DefaultCertificationService;
import dev.reuss.tmdb.domain.companies.CompanyService;
import dev.reuss.tmdb.domain.companies.DefaultCompanyService;
import dev.reuss.tmdb.domain.configuration.ConfigurationService;
import dev.reuss.tmdb.domain.configuration.DefaultConfigurationService;
import dev.reuss.tmdb.domain.credits.CreditService;
import dev.reuss.tmdb.domain.credits.DefaultCreditService;
import dev.reuss.tmdb.domain.discover.DefaultDiscoverService;
import dev.reuss.tmdb.domain.discover.DiscoverService;
import dev.reuss.tmdb.domain.find.DefaultFindService;
import dev.reuss.tmdb.domain.find.FindService;
import dev.reuss.tmdb.domain.genres.DefaultGenreService;
import dev.reuss.tmdb.domain.genres.GenreService;
import dev.reuss.tmdb.domain.images.url.DefaultImageUrlBuilder;
import dev.reuss.tmdb.domain.images.url.ImageUrlBuilder;
import dev.reuss.tmdb.domain.keywords.DefaultKeywordService;
import dev.reuss.tmdb.domain.keywords.KeywordService;
import dev.reuss.tmdb.domain.movie.DefaultMovieService;
import dev.reuss.tmdb.domain.movie.MovieService;
import dev.reuss.tmdb.domain.networks.DefaultNetworkService;
import dev.reuss.tmdb.domain.networks.NetworkService;
import dev.reuss.tmdb.domain.people.DefaultPersonService;
import dev.reuss.tmdb.domain.people.PersonService;
import dev.reuss.tmdb.domain.reviews.DefaultReviewService;
import dev.reuss.tmdb.domain.reviews.ReviewService;
import dev.reuss.tmdb.domain.search.DefaultSearchService;
import dev.reuss.tmdb.domain.search.SearchService;
import dev.reuss.tmdb.domain.trending.DefaultTrendingService;
import dev.reuss.tmdb.domain.trending.TrendingService;
import dev.reuss.tmdb.domain.tv.episode.DefaultTvEpisodeService;
import dev.reuss.tmdb.domain.tv.episode.TvEpisodeService;
import dev.reuss.tmdb.domain.tv.episodegroup.DefaultTvEpisodeGroupService;
import dev.reuss.tmdb.domain.tv.episodegroup.TvEpisodeGroupService;
import dev.reuss.tmdb.domain.tv.season.DefaultTvSeasonService;
import dev.reuss.tmdb.domain.tv.season.TvSeasonService;
import dev.reuss.tmdb.domain.tv.series.DefaultTvSeriesService;
import dev.reuss.tmdb.domain.tv.series.TvSeriesService;
import dev.reuss.tmdb.domain.watchproviders.DefaultWatchProviderService;
import dev.reuss.tmdb.domain.watchproviders.WatchProviderService;

import java.util.Objects;

final class DefaultTmdbClient implements TmdbClient {

    private final ConfigurationService configuration;
    private final ImageUrlBuilder imageUrls;
    private final CertificationService certifications;
    private final CompanyService companies;
    private final CreditService credits;
    private final DiscoverService discover;
    private final FindService find;
    private final GenreService genres;
    private final KeywordService keywords;
    private final NetworkService networks;
    private final ReviewService reviews;
    private final TrendingService trending;
    private final WatchProviderService watchProviders;
    private final SearchService search;
    private final PersonService people;
    private final TvSeriesService tvSeries;
    private final TvSeasonService tvSeason;
    private final TvEpisodeService tvEpisode;
    private final TvEpisodeGroupService tvEpisodeGroup;
    private final MovieService movies;

    DefaultTmdbClient(TmdbClientConfig config) {
        Objects.requireNonNull(config, "TMDB client config must not be null");

        TmdbHttpClient httpClient = new JavaNetTmdbHttpClient(config);

        this.configuration = new DefaultConfigurationService(httpClient);
        this.imageUrls = new DefaultImageUrlBuilder(configuration);
        this.certifications = new DefaultCertificationService(httpClient);
        this.companies = new DefaultCompanyService(httpClient);
        this.credits = new DefaultCreditService(httpClient);
        this.discover = new DefaultDiscoverService(httpClient);
        this.find = new DefaultFindService(httpClient);
        this.genres = new DefaultGenreService(httpClient);
        this.keywords = new DefaultKeywordService(httpClient);
        this.networks = new DefaultNetworkService(httpClient);
        this.reviews = new DefaultReviewService(httpClient);
        this.trending = new DefaultTrendingService(httpClient);
        this.watchProviders = new DefaultWatchProviderService(httpClient);
        this.search = new DefaultSearchService(httpClient);
        this.people = new DefaultPersonService(httpClient);
        this.tvSeries = new DefaultTvSeriesService(httpClient);
        this.tvSeason = new DefaultTvSeasonService(httpClient);
        this.tvEpisode = new DefaultTvEpisodeService(httpClient);
        this.tvEpisodeGroup = new DefaultTvEpisodeGroupService(httpClient);
        this.movies = new DefaultMovieService(httpClient);
    }

    @Override
    public ConfigurationService configuration() {
        return configuration;
    }

    @Override
    public ImageUrlBuilder imageUrls() {
        return imageUrls;
    }

    @Override
    public CertificationService certifications() {
        return certifications;
    }

    @Override
    public CompanyService companies() {
        return companies;
    }

    @Override
    public CreditService credits() {
        return credits;
    }

    @Override
    public DiscoverService discover() {
        return discover;
    }

    @Override
    public FindService find() {
        return find;
    }

    @Override
    public GenreService genres() {
        return genres;
    }

    @Override
    public KeywordService keywords() {
        return keywords;
    }

    @Override
    public NetworkService networks() {
        return networks;
    }

    @Override
    public ReviewService reviews() {
        return reviews;
    }

    @Override
    public TrendingService trending() {
        return trending;
    }

    @Override
    public WatchProviderService watchProviders() {
        return watchProviders;
    }

    @Override
    public SearchService search() {
        return search;
    }

    @Override
    public PersonService people() {
        return people;
    }

    @Override
    public TvSeriesService tvSeries() {
        return tvSeries;
    }

    @Override
    public TvSeasonService tvSeason() {
        return tvSeason;
    }

    @Override
    public TvEpisodeService tvEpisode() {
        return tvEpisode;
    }

    @Override
    public TvEpisodeGroupService tvEpisodeGroup() {
        return tvEpisodeGroup;
    }

    @Override
    public MovieService movies() {
        return movies;
    }
}