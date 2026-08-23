package dev.reuss.tmdb.domain.movie

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.MovieImages
import dev.reuss.tmdb.domain.movie.model.*
import dev.reuss.tmdb.domain.movie.query.*
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.MovieId
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Service for TMDB movie endpoints.
 */
interface MovieService {

    /**
     * Loads the details for a movie.
     *
     * @param movieId TMDB movie id
     * @return movie details
     */
    fun details(movieId: MovieId): MovieDetails

    /**
     * Loads the details for a movie using a specific language.
     *
     * @param movieId TMDB movie id
     * @param language response language
     * @return localized movie details
     */
    fun details(
        movieId: MovieId,
        language: Language
    ): MovieDetails

    /**
     * Loads the details for a movie with appended responses.
     *
     * @param movieId TMDB movie id
     * @param appendToResponse appended responses
     * @return movie details with appended responses
     */
    fun details(
        movieId: MovieId,
        appendToResponse: AppendToResponse<MovieAppend>
    ): MovieDetails

    /**
     * Loads the details for a movie using a specific language and appended responses.
     *
     * @param movieId TMDB movie id
     * @param language response language
     * @param appendToResponse appended responses
     * @return localized movie details with appended responses
     */
    fun details(
        movieId: MovieId,
        language: Language,
        appendToResponse: AppendToResponse<MovieAppend>
    ): MovieDetails

    /**
     * Loads alternative titles for a movie.
     *
     * @param movieId the movie id
     * @return movie alternative titles
     */
    fun alternativeTitles(movieId: MovieId): MovieAlternativeTitles

    /**
     * Loads alternative titles for a movie filtered by country.
     *
     * @param movieId the movie id
     * @param country country filter
     * @return movie alternative titles
     */
    fun alternativeTitles(
        movieId: MovieId,
        country: Region
    ): MovieAlternativeTitles

    /**
     * Loads recent changes for a movie.
     *
     * @param movieId the movie id
     * @return movie changes
     */
    fun changes(movieId: MovieId): MovieChanges

    /**
     * Loads changes for a movie using query parameters.
     *
     * @param movieId the movie id
     * @param query changes query
     * @return movie changes
     */
    fun changes(
        movieId: MovieId,
        query: ChangesQuery
    ): MovieChanges

    /**
     * Loads credits for a movie.
     *
     * @param movieId the movie id
     * @return movie credits
     */
    fun credits(movieId: MovieId): MovieCredits

    /**
     * Loads credits for a movie using a specific language.
     *
     * @param movieId the movie id
     * @param language response language
     * @return localized movie credits
     */
    fun credits(
        movieId: MovieId,
        language: Language
    ): MovieCredits

    /**
     * Loads external IDs for a movie.
     *
     * @param movieId the movie id
     * @return movie external IDs
     */
    fun externalIds(movieId: MovieId): ExternalIds

    /**
     * Loads keywords for a movie.
     *
     * @param movieId the movie id
     * @return movie keywords
     */
    fun keywords(movieId: MovieId): MovieKeywords

    /**
     * Loads the latest movie.
     *
     * @return latest movie details
     */
    fun latest(): MovieDetails

    /**
     * Loads movies that are currently in theatres.
     *
     * @return now playing movies
     */
    fun nowPlaying(): MovieNowPlayingResponse

    /**
     * Loads movies that are currently in theatres using a specific language.
     *
     * @param language response language
     * @return localized now playing movies
     */
    fun nowPlaying(language: Language): MovieNowPlayingResponse

    /**
     * Loads movies that are currently in theatres using query parameters.
     *
     * @param query now playing query
     * @return now playing movies
     */
    fun nowPlaying(query: MovieNowPlayingQuery): MovieNowPlayingResponse

    /**
     * Loads movies ordered by popularity.
     *
     * @return popular movies
     */
    fun popular(): MoviePopularResponse

    /**
     * Loads movies ordered by popularity using a specific language.
     *
     * @param language response language
     * @return localized popular movies
     */
    fun popular(language: Language): MoviePopularResponse

    /**
     * Loads movies ordered by popularity using query parameters.
     *
     * @param query popular movies query
     * @return popular movies
     */
    fun popular(query: MoviePopularQuery): MoviePopularResponse

    /**
     * Loads movies ordered by rating.
     *
     * @return top rated movies
     */
    fun topRated(): MovieTopRatedResponse

    /**
     * Loads movies ordered by rating using a specific language.
     *
     * @param language response language
     * @return localized top rated movies
     */
    fun topRated(language: Language): MovieTopRatedResponse

    /**
     * Loads movies ordered by rating using query parameters.
     *
     * @param query top rated movies query
     * @return top rated movies
     */
    fun topRated(query: MovieTopRatedQuery): MovieTopRatedResponse

    /**
     * Loads movies that are being released soon.
     *
     * @return upcoming movies
     */
    fun upcoming(): MovieUpcomingResponse

    /**
     * Loads movies that are being released soon using a specific language.
     *
     * @param language response language
     * @return localized upcoming movies
     */
    fun upcoming(language: Language): MovieUpcomingResponse

    /**
     * Loads movies that are being released soon using query parameters.
     *
     * @param query upcoming movies query
     * @return upcoming movies
     */
    fun upcoming(query: MovieUpcomingQuery): MovieUpcomingResponse

    /**
     * Loads movie recommendations.
     *
     * @param movieId the movie id
     * @return movie recommendations
     */
    fun recommendations(movieId: MovieId): MovieRecommendations

    /**
     * Loads movie recommendations using a specific language.
     *
     * @param movieId the movie id
     * @param language response language
     * @return localized movie recommendations
     */
    fun recommendations(
        movieId: MovieId,
        language: Language
    ): MovieRecommendations

    /**
     * Loads movie recommendations using a specific page.
     *
     * @param movieId the movie id
     * @param page page number
     * @return movie recommendations page
     */
    fun recommendations(
        movieId: MovieId,
        page: Int
    ): MovieRecommendations

    /**
     * Loads movie recommendations using query parameters.
     *
     * @param movieId the movie id
     * @param query recommendations query
     * @return movie recommendations
     */
    fun recommendations(
        movieId: MovieId,
        query: MovieRecommendationsQuery
    ): MovieRecommendations

    /**
     * Loads release dates and certifications for a movie.
     *
     * @param movieId the movie id
     * @return movie release dates
     */
    fun releaseDates(movieId: MovieId): MovieReleaseDates

    /**
     * Loads reviews for a movie.
     *
     * @param movieId the movie id
     * @return movie reviews
     */
    fun reviews(movieId: MovieId): MovieReviews

    /**
     * Loads reviews for a movie using a specific language.
     *
     * @param movieId the movie id
     * @param language response language
     * @return localized movie reviews
     */
    fun reviews(
        movieId: MovieId,
        language: Language
    ): MovieReviews

    /**
     * Loads reviews for a movie using a specific page.
     *
     * @param movieId the movie id
     * @param page page number
     * @return movie reviews page
     */
    fun reviews(
        movieId: MovieId,
        page: Int
    ): MovieReviews

    /**
     * Loads reviews for a movie using query parameters.
     *
     * @param movieId the movie id
     * @param query reviews query
     * @return movie reviews
     */
    fun reviews(
        movieId: MovieId,
        query: MovieReviewsQuery
    ): MovieReviews

    /**
     * Loads similar movies.
     *
     * @param movieId the movie id
     * @return similar movies
     */
    fun similar(movieId: MovieId): SimilarMovies

    /**
     * Loads similar movies using a specific language.
     *
     * @param movieId the movie id
     * @param language response language
     * @return localized similar movies
     */
    fun similar(
        movieId: MovieId,
        language: Language
    ): SimilarMovies

    /**
     * Loads similar movies using a specific page.
     *
     * @param movieId the movie id
     * @param page page number
     * @return similar movies page
     */
    fun similar(
        movieId: MovieId,
        page: Int
    ): SimilarMovies

    /**
     * Loads similar movies using query parameters.
     *
     * @param movieId the movie id
     * @param query similar movies query
     * @return similar movies
     */
    fun similar(
        movieId: MovieId,
        query: MovieSimilarQuery
    ): SimilarMovies

    /**
     * Loads translations for a movie.
     *
     * @param movieId the movie id
     * @return movie translations
     */
    fun translations(movieId: MovieId): MovieTranslations

    /**
     * Loads videos for a movie.
     *
     * @param movieId the movie id
     * @return movie videos
     */
    fun videos(movieId: MovieId): MovieVideos

    /**
     * Loads videos for a movie using a specific language.
     *
     * @param movieId the movie id
     * @param language response language
     * @return localized movie videos
     */
    fun videos(
        movieId: MovieId,
        language: Language
    ): MovieVideos

    /**
     * Loads watch provider availabilities for a movie.
     *
     * @param movieId the movie id
     * @return movie watch providers
     */
    fun watchProviders(movieId: MovieId): MovieWatchProviders

    /**
     * Loads images for a movie.
     *
     * @param movieId TMDB movie id
     * @return movie images
     */
    fun images(movieId: MovieId): MovieImages

    /**
     * Loads images for a movie using query parameters.
     *
     * @param movieId TMDB movie id
     * @param query image query
     * @return movie images
     */
    fun images(
        movieId: MovieId,
        query: ImageQuery
    ): MovieImages
}