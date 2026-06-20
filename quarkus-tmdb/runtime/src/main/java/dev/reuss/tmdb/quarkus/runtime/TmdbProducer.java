package dev.reuss.tmdb.quarkus.runtime;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import dev.reuss.tmdb.domain.certifications.CertificationService;
import dev.reuss.tmdb.domain.collection.CollectionService;
import dev.reuss.tmdb.domain.companies.CompanyService;
import dev.reuss.tmdb.domain.configuration.ConfigurationService;
import dev.reuss.tmdb.domain.credits.CreditService;
import dev.reuss.tmdb.domain.discover.DiscoverService;
import dev.reuss.tmdb.domain.find.FindService;
import dev.reuss.tmdb.domain.genres.GenreService;
import dev.reuss.tmdb.domain.images.url.ImageUrlBuilder;
import dev.reuss.tmdb.domain.keywords.KeywordService;
import dev.reuss.tmdb.domain.movie.MovieService;
import dev.reuss.tmdb.domain.networks.NetworkService;
import dev.reuss.tmdb.domain.people.PersonService;
import dev.reuss.tmdb.domain.reviews.ReviewService;
import dev.reuss.tmdb.domain.search.SearchService;
import dev.reuss.tmdb.domain.trending.TrendingService;
import dev.reuss.tmdb.domain.tv.episode.TvEpisodeService;
import dev.reuss.tmdb.domain.tv.episodegroup.TvEpisodeGroupService;
import dev.reuss.tmdb.domain.tv.season.TvSeasonService;
import dev.reuss.tmdb.domain.tv.series.TvSeriesService;
import dev.reuss.tmdb.domain.watchproviders.WatchProviderService;
import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

/**
 * Produces TMDB SDK beans for Quarkus applications.
 */
@Singleton
public class TmdbProducer {

    @Produces
    @Singleton
    @DefaultBean
    public TmdbMetricsRecorder tmdbMetricsRecorder() {
        return TmdbMetricsRecorder.NOOP;
    }

    @Produces
    @Singleton
    @DefaultBean
    public ConfigurationService configurationService(TmdbClient client) {
        return client.configuration();
    }

    @Produces
    @Singleton
    @DefaultBean
    public ImageUrlBuilder imageUrlBuilder(TmdbClient client) {
        return client.imageUrls();
    }

    @Produces
    @Singleton
    @DefaultBean
    public CertificationService certificationService(TmdbClient client) {
        return client.certifications();
    }

    @Produces
    @Singleton
    @DefaultBean
    public CollectionService collectionService(TmdbClient client) {
        return client.collections();
    }

    @Produces
    @Singleton
    @DefaultBean
    public CompanyService companyService(TmdbClient client) {
        return client.companies();
    }

    @Produces
    @Singleton
    @DefaultBean
    public CreditService creditService(TmdbClient client) {
        return client.credits();
    }

    @Produces
    @Singleton
    @DefaultBean
    public DiscoverService discoverService(TmdbClient client) {
        return client.discover();
    }

    @Produces
    @Singleton
    @DefaultBean
    public FindService findService(TmdbClient client) {
        return client.find();
    }

    @Produces
    @Singleton
    @DefaultBean
    public GenreService genreService(TmdbClient client) {
        return client.genres();
    }

    @Produces
    @Singleton
    @DefaultBean
    public KeywordService keywordService(TmdbClient client) {
        return client.keywords();
    }

    @Produces
    @Singleton
    @DefaultBean
    public MovieService movieService(TmdbClient client) {
        return client.movies();
    }

    @Produces
    @Singleton
    @DefaultBean
    public NetworkService networkService(TmdbClient client) {
        return client.networks();
    }

    @Produces
    @Singleton
    @DefaultBean
    public PersonService personService(TmdbClient client) {
        return client.people();
    }

    @Produces
    @Singleton
    @DefaultBean
    public ReviewService reviewService(TmdbClient client) {
        return client.reviews();
    }

    @Produces
    @Singleton
    @DefaultBean
    public SearchService searchService(TmdbClient client) {
        return client.search();
    }

    @Produces
    @Singleton
    @DefaultBean
    public TrendingService trendingService(TmdbClient client) {
        return client.trending();
    }

    @Produces
    @Singleton
    @DefaultBean
    public TvEpisodeService tvEpisodeService(TmdbClient client) {
        return client.tvEpisode();
    }

    @Produces
    @Singleton
    @DefaultBean
    public TvEpisodeGroupService tvEpisodeGroupService(TmdbClient client) {
        return client.tvEpisodeGroup();
    }

    @Produces
    @Singleton
    @DefaultBean
    public TvSeasonService tvSeasonService(TmdbClient client) {
        return client.tvSeason();
    }

    @Produces
    @Singleton
    @DefaultBean
    public TvSeriesService tvSeriesService(TmdbClient client) {
        return client.tvSeries();
    }

    @Produces
    @Singleton
    @DefaultBean
    public WatchProviderService watchProviderService(TmdbClient client) {
        return client.watchProviders();
    }
}
