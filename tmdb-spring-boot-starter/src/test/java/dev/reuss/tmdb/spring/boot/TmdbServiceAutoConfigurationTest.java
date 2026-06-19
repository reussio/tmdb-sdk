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
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TmdbServiceAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                    TmdbClientAutoConfiguration.class,
                    TmdbServiceAutoConfiguration.class
            ));

    @Test
    void createsTmdbServiceBeans() {
        contextRunner
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    assertThat(context).hasSingleBean(TmdbClient.class);
                    assertThat(context).hasSingleBean(ConfigurationService.class);
                    assertThat(context).hasSingleBean(ImageUrlBuilder.class);
                    assertThat(context).hasSingleBean(CertificationService.class);
                    assertThat(context).hasSingleBean(CompanyService.class);
                    assertThat(context).hasSingleBean(CreditService.class);
                    assertThat(context).hasSingleBean(DiscoverService.class);
                    assertThat(context).hasSingleBean(FindService.class);
                    assertThat(context).hasSingleBean(GenreService.class);
                    assertThat(context).hasSingleBean(KeywordService.class);
                    assertThat(context).hasSingleBean(NetworkService.class);
                    assertThat(context).hasSingleBean(ReviewService.class);
                    assertThat(context).hasSingleBean(TrendingService.class);
                    assertThat(context).hasSingleBean(WatchProviderService.class);
                    assertThat(context).hasSingleBean(SearchService.class);
                    assertThat(context).hasSingleBean(PersonService.class);
                    assertThat(context).hasSingleBean(TvSeriesService.class);
                    assertThat(context).hasSingleBean(TvSeasonService.class);
                    assertThat(context).hasSingleBean(TvEpisodeService.class);
                    assertThat(context).hasSingleBean(TvEpisodeGroupService.class);
                    assertThat(context).hasSingleBean(MovieService.class);
                });
    }

    @Test
    void serviceBeansUseConfiguredTmdbClient() {
        contextRunner
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    TmdbClient tmdbClient = context.getBean(TmdbClient.class);

                    assertThat(context.getBean(ConfigurationService.class))
                            .isSameAs(tmdbClient.configuration());
                    assertThat(context.getBean(ImageUrlBuilder.class))
                            .isSameAs(tmdbClient.imageUrls());
                    assertThat(context.getBean(MovieService.class))
                            .isSameAs(tmdbClient.movies());
                    assertThat(context.getBean(SearchService.class))
                            .isSameAs(tmdbClient.search());
                });
    }

    @Test
    void doesNotOverrideCustomConfigurationServiceBean() {
        ConfigurationService customService = mock(ConfigurationService.class);

        contextRunner
                .withBean(ConfigurationService.class, () -> customService)
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    assertThat(context).hasSingleBean(ConfigurationService.class);
                    assertThat(context.getBean(ConfigurationService.class)).isSameAs(customService);
                });
    }
}
