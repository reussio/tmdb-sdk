package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.domain.certifications.CertificationService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Autoconfiguration for TMDB domain service beans.
 *
 * <p>This configuration exposes the service instances provided by the configured
 * {@link TmdbClient} as individual Spring beans.</p>
 */
@AutoConfiguration(after = TmdbClientAutoConfiguration.class)
@ConditionalOnBean(TmdbClient.class)
public class TmdbServiceAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(TmdbServiceAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public ConfigurationService configurationService(TmdbClient tmdbClient) {
        return tmdbClient.configuration();
    }

    @Bean
    @ConditionalOnMissingBean
    public ImageUrlBuilder imageUrlBuilder(TmdbClient tmdbClient) {
        return tmdbClient.imageUrls();
    }

    @Bean
    @ConditionalOnMissingBean
    public CertificationService certificationService(TmdbClient tmdbClient) {
        return tmdbClient.certifications();
    }

    @Bean
    @ConditionalOnMissingBean
    public CompanyService companyService(TmdbClient tmdbClient) {
        return tmdbClient.companies();
    }

    @Bean
    @ConditionalOnMissingBean
    public CreditService creditService(TmdbClient tmdbClient) {
        return tmdbClient.credits();
    }

    @Bean
    @ConditionalOnMissingBean
    public DiscoverService discoverService(TmdbClient tmdbClient) {
        return tmdbClient.discover();
    }

    @Bean
    @ConditionalOnMissingBean
    public FindService findService(TmdbClient tmdbClient) {
        return tmdbClient.find();
    }

    @Bean
    @ConditionalOnMissingBean
    public GenreService genreService(TmdbClient tmdbClient) {
        return tmdbClient.genres();
    }

    @Bean
    @ConditionalOnMissingBean
    public KeywordService keywordService(TmdbClient tmdbClient) {
        return tmdbClient.keywords();
    }

    @Bean
    @ConditionalOnMissingBean
    public NetworkService networkService(TmdbClient tmdbClient) {
        return tmdbClient.networks();
    }

    @Bean
    @ConditionalOnMissingBean
    public ReviewService reviewService(TmdbClient tmdbClient) {
        return tmdbClient.reviews();
    }

    @Bean
    @ConditionalOnMissingBean
    public TrendingService trendingService(TmdbClient tmdbClient) {
        return tmdbClient.trending();
    }

    @Bean
    @ConditionalOnMissingBean
    public WatchProviderService watchProviderService(TmdbClient tmdbClient) {
        return tmdbClient.watchProviders();
    }

    @Bean
    @ConditionalOnMissingBean
    public SearchService searchService(TmdbClient tmdbClient) {
        return tmdbClient.search();
    }

    @Bean
    @ConditionalOnMissingBean
    public PersonService personService(TmdbClient tmdbClient) {
        return tmdbClient.people();
    }

    @Bean
    @ConditionalOnMissingBean
    public TvSeriesService tvSeriesService(TmdbClient tmdbClient) {
        return tmdbClient.tvSeries();
    }

    @Bean
    @ConditionalOnMissingBean
    public TvSeasonService tvSeasonService(TmdbClient tmdbClient) {
        return tmdbClient.tvSeason();
    }

    @Bean
    @ConditionalOnMissingBean
    public TvEpisodeService tvEpisodeService(TmdbClient tmdbClient) {
        return tmdbClient.tvEpisode();
    }

    @Bean
    @ConditionalOnMissingBean
    public TvEpisodeGroupService tvEpisodeGroupService(TmdbClient tmdbClient) {
        return tmdbClient.tvEpisodeGroup();
    }

    @Bean
    @ConditionalOnMissingBean
    public MovieService movieService(TmdbClient tmdbClient) {
        return tmdbClient.movies();
    }

    @Bean
    public SmartInitializingSingleton tmdbServiceBeansLogger() {
        return () -> log.debug("Configured TMDB Java SDK domain service beans");
    }
}
