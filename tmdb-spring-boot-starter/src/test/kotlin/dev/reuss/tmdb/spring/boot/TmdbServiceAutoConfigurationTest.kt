package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.domain.certifications.CertificationService
import dev.reuss.tmdb.domain.collection.CollectionService
import dev.reuss.tmdb.domain.companies.CompanyService
import dev.reuss.tmdb.domain.configuration.ConfigurationService
import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration
import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.configuration.model.JobDepartment
import dev.reuss.tmdb.domain.configuration.model.Timezone
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
import dev.reuss.tmdb.value.language.Language
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.AutoConfigurations
import org.springframework.boot.test.context.runner.ApplicationContextRunner

class TmdbServiceAutoConfigurationTest {
    private val contextRunner =
        ApplicationContextRunner()
            .withConfiguration(
                AutoConfigurations.of(
                    TmdbClientAutoConfiguration::class.java,
                    TmdbServiceAutoConfiguration::class.java,
                ),
            )

    @Test
    fun createsTmdbServiceBeans() {
        contextRunner
            .withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context).hasSingleBean(TmdbClient::class.java)
                assertThat(context).hasSingleBean(ConfigurationService::class.java)
                assertThat(context).hasSingleBean(ImageUrlBuilder::class.java)
                assertThat(context).hasSingleBean(CertificationService::class.java)
                assertThat(context).hasSingleBean(CompanyService::class.java)
                assertThat(context).hasSingleBean(CreditService::class.java)
                assertThat(context).hasSingleBean(DiscoverService::class.java)
                assertThat(context).hasSingleBean(FindService::class.java)
                assertThat(context).hasSingleBean(GenreService::class.java)
                assertThat(context).hasSingleBean(KeywordService::class.java)
                assertThat(context).hasSingleBean(NetworkService::class.java)
                assertThat(context).hasSingleBean(ReviewService::class.java)
                assertThat(context).hasSingleBean(TrendingService::class.java)
                assertThat(context).hasSingleBean(WatchProviderService::class.java)
                assertThat(context).hasSingleBean(SearchService::class.java)
                assertThat(context).hasSingleBean(PersonService::class.java)
                assertThat(context).hasSingleBean(TvSeriesService::class.java)
                assertThat(context).hasSingleBean(TvSeasonService::class.java)
                assertThat(context).hasSingleBean(TvEpisodeService::class.java)
                assertThat(context).hasSingleBean(TvEpisodeGroupService::class.java)
                assertThat(context).hasSingleBean(MovieService::class.java)
                assertThat(context).hasSingleBean(CollectionService::class.java)
            }
    }

    @Test
    fun serviceBeansUseConfiguredTmdbClient() {
        contextRunner
            .withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                val tmdbClient = context.getBean(TmdbClient::class.java)

                assertThat(context.getBean(ConfigurationService::class.java))
                    .isSameAs(tmdbClient.configuration())

                assertThat(context.getBean(ImageUrlBuilder::class.java))
                    .isSameAs(tmdbClient.imageUrls())

                assertThat(context.getBean(MovieService::class.java))
                    .isSameAs(tmdbClient.movies())

                assertThat(context.getBean(SearchService::class.java))
                    .isSameAs(tmdbClient.search())
            }
    }

    @Test
    fun doesNotOverrideCustomConfigurationServiceBean() {
        val customService = TestConfigurationService()

        contextRunner
            .withBean(
                ConfigurationService::class.java,
                { customService },
            ).withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context)
                    .hasSingleBean(ConfigurationService::class.java)

                assertThat(
                    context.getBean(ConfigurationService::class.java),
                ).isSameAs(customService)
            }
    }

    private class TestConfigurationService : ConfigurationService {
        override fun apiConfiguration(): ApiConfiguration = error("Not used in this test")

        override fun countries(): List<Country> = emptyList()

        override fun countries(language: Language): List<Country> = emptyList()

        override fun jobs(): List<JobDepartment> = emptyList()

        override fun languages(): List<ConfigurationLanguage> = emptyList()

        override fun primaryTranslations(): List<String> = emptyList()

        override fun timezones(): List<Timezone> = emptyList()
    }
}
