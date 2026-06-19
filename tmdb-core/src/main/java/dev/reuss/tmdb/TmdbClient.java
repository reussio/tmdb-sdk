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
     * Returns the service for TMDB API configuration metadata.
     *
     * @return configuration service
     */
    ConfigurationService configuration();

    /**
     * Returns the builder for TMDB image URLs.
     *
     * @return image URL builder
     */
    ImageUrlBuilder imageUrls();

    /**
     * Returns the service for movie and TV certification lists.
     *
     * @return certification service
     */
    CertificationService certifications();

    /**
     * Returns the service for TMDB companies.
     *
     * @return company service
     */
    CompanyService companies();

    /**
     * Returns the service for credit details.
     *
     * @return credit service
     */
    CreditService credits();

    /**
     * Returns the service for discovering movies and TV shows.
     *
     * @return discover service
     */
    DiscoverService discover();

    /**
     * Returns the service for resolving external ids to TMDB resources.
     *
     * @return find service
     */
    FindService find();

    /**
     * Returns the service for movie and TV genres.
     *
     * @return genre service
     */
    GenreService genres();

    /**
     * Returns the service for TMDB keywords.
     *
     * @return keyword service
     */
    KeywordService keywords();

    /**
     * Returns the service for TV networks.
     *
     * @return network service
     */
    NetworkService networks();

    /**
     * Returns the service for review details.
     *
     * @return review service
     */
    ReviewService reviews();

    /**
     * Returns the service for trending movies, TV shows, people and mixed results.
     *
     * @return trending service
     */
    TrendingService trending();

    /**
     * Returns the service for watch provider metadata.
     *
     * @return watch provider service
     */
    WatchProviderService watchProviders();

    /**
     * Returns the service for TMDB search endpoints.
     *
     * @return search service
     */
    SearchService search();

    /**
     * Returns the service for people endpoints.
     *
     * @return people service
     */
    PersonService people();

    /**
     * Returns the service for TV series endpoints.
     *
     * @return TV series service
     */
    TvSeriesService tvSeries();

    /**
     * Returns the service for TV season endpoints.
     *
     * @return TV season service
     */
    TvSeasonService tvSeason();

    /**
     * Returns the service for TV episode endpoints.
     *
     * @return TV episode service
     */
    TvEpisodeService tvEpisode();

    /**
     * Returns the service for TV episode group endpoints.
     *
     * @return TV episode group service
     */
    TvEpisodeGroupService tvEpisodeGroup();

    /**
     * Returns the service for movie endpoints.
     *
     * @return movie service
     */
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
