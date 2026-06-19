package dev.reuss.tmdb;

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

/**
 * Main entry point for the TMDB Java SDK.
 *
 * <p>A {@code TmdbClient} provides access to TMDB API services such as
 * configuration, images, movies, TV shows, search and watch providers.</p>
 *
 * <p>Client instances should be created through {@link #builder()}.</p>
 *
 * <pre>{@code
 * TmdbClient tmdb = TmdbClient.builder()
 *         .accessToken("your-access-token")
 *         .build();
 * }</pre>
 *
 * <p>Implementations are expected to be reusable. SDK users should usually
 * create one client instance and share it where needed.</p>
 *
 * @see TmdbClientBuilder
 */
public interface TmdbClient {

    /**
     * Returns the configuration service.
     *
     * @return the configuration service
     */
    ConfigurationService configuration();

    /**
     * Returns the image url builder.
     *
     * @return the image url builder
     */
    ImageUrlBuilder imageUrls();

    CertificationService certifications();

    CompanyService companies();

    CreditService credits();

    DiscoverService discover();

    FindService find();

    GenreService genres();

    KeywordService keywords();

    NetworkService networks();

    ReviewService reviews();

    TrendingService trending();

    WatchProviderService watchProviders();

    SearchService search();

    PersonService people();

    TvSeriesService tvSeries();

    TvSeasonService tvSeason();

    TvEpisodeService tvEpisode();

    TvEpisodeGroupService tvEpisodeGroup();

    MovieService movies();

    /**
     * Creates a new TMDB client builder.
     *
     * @return a new client builder
     */
    static TmdbClientBuilder builder() {
        return new TmdbClientBuilder();
    }
}