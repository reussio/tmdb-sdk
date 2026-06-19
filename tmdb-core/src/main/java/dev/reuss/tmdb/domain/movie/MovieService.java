package dev.reuss.tmdb.domain.movie;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.MovieImages;
import dev.reuss.tmdb.domain.movie.model.*;
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieReviewsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieSimilarQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.MovieId;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

public interface MovieService {

    MovieDetails details(MovieId movieId);

    MovieDetails details(MovieId movieId, Language language);

    MovieDetails details(
            MovieId movieId,
            AppendToResponse<MovieAppend> appendToResponse
    );

    MovieDetails details(
            MovieId movieId,
            Language language,
            AppendToResponse<MovieAppend> appendToResponse
    );

    /**
     * Loads alternative titles for a movie.
     *
     * @param movieId the movie id
     * @return movie alternative titles
     */
    MovieAlternativeTitles alternativeTitles(MovieId movieId);

    /**
     * Loads alternative titles for a movie filtered by country.
     *
     * @param movieId the movie id
     * @param country country filter
     * @return movie alternative titles
     */
    MovieAlternativeTitles alternativeTitles(MovieId movieId, Region country);

    /**
     * Loads recent changes for a movie.
     *
     * @param movieId the movie id
     * @return movie changes
     */
    MovieChanges changes(MovieId movieId);

    /**
     * Loads changes for a movie using query parameters.
     *
     * @param movieId the movie id
     * @param query   changes query
     * @return movie changes
     */
    MovieChanges changes(MovieId movieId, ChangesQuery query);

    /**
     * Loads credits for a movie.
     *
     * @param movieId the movie id
     * @return movie credits
     */
    MovieCredits credits(MovieId movieId);

    /**
     * Loads credits for a movie using a specific language.
     *
     * @param movieId  the movie id
     * @param language response language
     * @return localized movie credits
     */
    MovieCredits credits(MovieId movieId, Language language);

    /**
     * Loads external IDs for a movie.
     *
     * @param movieId the movie id
     * @return movie external IDs
     */
    ExternalIds externalIds(MovieId movieId);

    /**
     * Loads keywords for a movie.
     *
     * @param movieId the movie id
     * @return movie keywords
     */
    MovieKeywords keywords(MovieId movieId);

    /**
     * Loads the latest movie.
     *
     * @return latest movie details
     */
    MovieDetails latest();

    /**
     * Loads movie recommendations.
     *
     * @param movieId the movie id
     * @return movie recommendations
     */
    MovieRecommendations recommendations(MovieId movieId);

    /**
     * Loads movie recommendations using a specific language.
     *
     * @param movieId  the movie id
     * @param language response language
     * @return localized movie recommendations
     */
    MovieRecommendations recommendations(MovieId movieId, Language language);

    /**
     * Loads movie recommendations using a specific page.
     *
     * @param movieId the movie id
     * @param page    page number
     * @return movie recommendations page
     */
    MovieRecommendations recommendations(MovieId movieId, int page);

    /**
     * Loads movie recommendations using query parameters.
     *
     * @param movieId the movie id
     * @param query   recommendations query
     * @return movie recommendations
     */
    MovieRecommendations recommendations(MovieId movieId, MovieRecommendationsQuery query);

    /**
     * Loads release dates and certifications for a movie.
     *
     * @param movieId the movie id
     * @return movie release dates
     */
    MovieReleaseDates releaseDates(MovieId movieId);

    /**
     * Loads reviews for a movie.
     *
     * @param movieId the movie id
     * @return movie reviews
     */
    MovieReviews reviews(MovieId movieId);

    /**
     * Loads reviews for a movie using a specific language.
     *
     * @param movieId  the movie id
     * @param language response language
     * @return localized movie reviews
     */
    MovieReviews reviews(MovieId movieId, Language language);

    /**
     * Loads reviews for a movie using a specific page.
     *
     * @param movieId the movie id
     * @param page    page number
     * @return movie reviews page
     */
    MovieReviews reviews(MovieId movieId, int page);

    /**
     * Loads reviews for a movie using query parameters.
     *
     * @param movieId the movie id
     * @param query   reviews query
     * @return movie reviews
     */
    MovieReviews reviews(MovieId movieId, MovieReviewsQuery query);

    /**
     * Loads similar movies.
     *
     * @param movieId the movie id
     * @return similar movies
     */
    SimilarMovies similar(MovieId movieId);

    /**
     * Loads similar movies using a specific language.
     *
     * @param movieId  the movie id
     * @param language response language
     * @return localized similar movies
     */
    SimilarMovies similar(MovieId movieId, Language language);

    /**
     * Loads similar movies using a specific page.
     *
     * @param movieId the movie id
     * @param page    page number
     * @return similar movies page
     */
    SimilarMovies similar(MovieId movieId, int page);

    /**
     * Loads similar movies using query parameters.
     *
     * @param movieId the movie id
     * @param query   similar movies query
     * @return similar movies
     */
    SimilarMovies similar(MovieId movieId, MovieSimilarQuery query);

    /**
     * Loads translations for a movie.
     *
     * @param movieId the movie id
     * @return movie translations
     */
    MovieTranslations translations(MovieId movieId);

    /**
     * Loads videos for a movie.
     *
     * @param movieId the movie id
     * @return movie videos
     */
    MovieVideos videos(MovieId movieId);

    /**
     * Loads videos for a movie using a specific language.
     *
     * @param movieId  the movie id
     * @param language response language
     * @return localized movie videos
     */
    MovieVideos videos(MovieId movieId, Language language);

    /**
     * Loads watch provider availabilities for a movie.
     *
     * @param movieId the movie id
     * @return movie watch providers
     */
    MovieWatchProviders watchProviders(MovieId movieId);

    MovieImages images(MovieId movieId);

    MovieImages images(MovieId movieId, ImageQuery query);

}