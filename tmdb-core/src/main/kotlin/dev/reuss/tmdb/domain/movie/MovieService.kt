package dev.reuss.tmdb.domain.movie

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.MovieImages
import dev.reuss.tmdb.domain.movie.model.MovieAlternativeTitles
import dev.reuss.tmdb.domain.movie.model.MovieChanges
import dev.reuss.tmdb.domain.movie.model.MovieCredits
import dev.reuss.tmdb.domain.movie.model.MovieDetails
import dev.reuss.tmdb.domain.movie.model.MovieKeywords
import dev.reuss.tmdb.domain.movie.model.MovieNowPlayingResponse
import dev.reuss.tmdb.domain.movie.model.MoviePopularResponse
import dev.reuss.tmdb.domain.movie.model.MovieRecommendations
import dev.reuss.tmdb.domain.movie.model.MovieReleaseDates
import dev.reuss.tmdb.domain.movie.model.MovieReviews
import dev.reuss.tmdb.domain.movie.model.MovieTopRatedResponse
import dev.reuss.tmdb.domain.movie.model.MovieTranslations
import dev.reuss.tmdb.domain.movie.model.MovieUpcomingResponse
import dev.reuss.tmdb.domain.movie.model.MovieVideos
import dev.reuss.tmdb.domain.movie.model.MovieWatchProviders
import dev.reuss.tmdb.domain.movie.model.SimilarMovies
import dev.reuss.tmdb.domain.movie.query.MovieNowPlayingQuery
import dev.reuss.tmdb.domain.movie.query.MoviePopularQuery
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery
import dev.reuss.tmdb.domain.movie.query.MovieReviewsQuery
import dev.reuss.tmdb.domain.movie.query.MovieSimilarQuery
import dev.reuss.tmdb.domain.movie.query.MovieTopRatedQuery
import dev.reuss.tmdb.domain.movie.query.MovieUpcomingQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.MovieId
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/** Loads movie lists, details, and related metadata from TMDB. */
interface MovieService {
    /**
     * Loads the details for a movie.
     */
    fun details(movieId: MovieId): MovieDetails

    /**
     * Loads the details for a movie using a specific language.
     */
    fun details(
        movieId: MovieId,
        language: Language,
    ): MovieDetails

    /** Returns movie details with the requested sub-resources appended. */
    fun details(
        movieId: MovieId,
        appendToResponse: AppendToResponse<MovieAppend>,
    ): MovieDetails

    /** Returns localized movie details with the requested sub-resources appended. */
    fun details(
        movieId: MovieId,
        language: Language,
        appendToResponse: AppendToResponse<MovieAppend>,
    ): MovieDetails

    /**
     * Loads alternative titles for a movie.
     */
    fun alternativeTitles(movieId: MovieId): MovieAlternativeTitles

    /**
     * Loads alternative titles for a movie filtered by country.
     */
    fun alternativeTitles(
        movieId: MovieId,
        country: Region,
    ): MovieAlternativeTitles

    /** Returns all tracked changes from the preceding 24 hours. */
    fun changes(movieId: MovieId): MovieChanges

    /**
     * Loads changes for a movie using query parameters.
     */
    fun changes(
        movieId: MovieId,
        query: ChangesQuery,
    ): MovieChanges

    /**
     * Loads credits for a movie.
     */
    fun credits(movieId: MovieId): MovieCredits

    /**
     * Loads credits for a movie using a specific language.
     */
    fun credits(
        movieId: MovieId,
        language: Language,
    ): MovieCredits

    /**
     * Loads external IDs for a movie.
     */
    fun externalIds(movieId: MovieId): ExternalIds

    /**
     * Loads keywords for a movie.
     */
    fun keywords(movieId: MovieId): MovieKeywords

    /** Returns the most recently created movie record on TMDB. */
    fun latest(): MovieDetails

    /**
     * Loads movies that are currently in theatres.
     */
    fun nowPlaying(): MovieNowPlayingResponse

    /**
     * Loads movies that are currently in theatres using a specific language.
     */
    fun nowPlaying(language: Language): MovieNowPlayingResponse

    /**
     * Loads movies that are currently in theatres using query parameters.
     */
    fun nowPlaying(query: MovieNowPlayingQuery): MovieNowPlayingResponse

    /**
     * Loads movies ordered by popularity.
     */
    fun popular(): MoviePopularResponse

    /**
     * Loads movies ordered by popularity using a specific language.
     */
    fun popular(language: Language): MoviePopularResponse

    /**
     * Loads movies ordered by popularity using query parameters.
     */
    fun popular(query: MoviePopularQuery): MoviePopularResponse

    /**
     * Loads movies ordered by rating.
     */
    fun topRated(): MovieTopRatedResponse

    /**
     * Loads movies ordered by rating using a specific language.
     */
    fun topRated(language: Language): MovieTopRatedResponse

    /**
     * Loads movies ordered by rating using query parameters.
     */
    fun topRated(query: MovieTopRatedQuery): MovieTopRatedResponse

    /**
     * Loads movies that are being released soon.
     */
    fun upcoming(): MovieUpcomingResponse

    /**
     * Loads movies that are being released soon using a specific language.
     */
    fun upcoming(language: Language): MovieUpcomingResponse

    /**
     * Loads movies that are being released soon using query parameters.
     */
    fun upcoming(query: MovieUpcomingQuery): MovieUpcomingResponse

    /**
     * Loads movie recommendations.
     */
    fun recommendations(movieId: MovieId): MovieRecommendations

    /**
     * Loads movie recommendations using a specific language.
     */
    fun recommendations(
        movieId: MovieId,
        language: Language,
    ): MovieRecommendations

    /**
     * Loads movie recommendations using a specific page.
     */
    fun recommendations(
        movieId: MovieId,
        page: Int,
    ): MovieRecommendations

    /**
     * Loads movie recommendations using query parameters.
     */
    fun recommendations(
        movieId: MovieId,
        query: MovieRecommendationsQuery,
    ): MovieRecommendations

    /**
     * Loads release dates and certifications for a movie.
     */
    fun releaseDates(movieId: MovieId): MovieReleaseDates

    /**
     * Loads reviews for a movie.
     */
    fun reviews(movieId: MovieId): MovieReviews

    /**
     * Loads reviews for a movie using a specific language.
     */
    fun reviews(
        movieId: MovieId,
        language: Language,
    ): MovieReviews

    /**
     * Loads reviews for a movie using a specific page.
     */
    fun reviews(
        movieId: MovieId,
        page: Int,
    ): MovieReviews

    /**
     * Loads reviews for a movie using query parameters.
     */
    fun reviews(
        movieId: MovieId,
        query: MovieReviewsQuery,
    ): MovieReviews

    /**
     * Returns movies TMDB considers similar based only on genres and plot keywords.
     * This is distinct from personalized or behavior-based recommendations.
     */
    fun similar(movieId: MovieId): SimilarMovies

    /**
     * Loads similar movies using a specific language.
     */
    fun similar(
        movieId: MovieId,
        language: Language,
    ): SimilarMovies

    /**
     * Loads similar movies using a specific page.
     */
    fun similar(
        movieId: MovieId,
        page: Int,
    ): SimilarMovies

    /**
     * Loads similar movies using query parameters.
     */
    fun similar(
        movieId: MovieId,
        query: MovieSimilarQuery,
    ): SimilarMovies

    /**
     * Loads translations for a movie.
     */
    fun translations(movieId: MovieId): MovieTranslations

    /**
     * Loads videos for a movie.
     */
    fun videos(movieId: MovieId): MovieVideos

    /**
     * Loads videos for a movie using a specific language.
     */
    fun videos(
        movieId: MovieId,
        language: Language,
    ): MovieVideos

    /** Returns regional streaming, rental, and purchase offers for the movie. */
    fun watchProviders(movieId: MovieId): MovieWatchProviders

    /** Returns movie backdrops, logos, and posters using default language filters. */
    fun images(movieId: MovieId): MovieImages

    /** Returns movie backdrops, logos, and posters using [query]. */
    fun images(
        movieId: MovieId,
        query: ImageQuery,
    ): MovieImages
}
