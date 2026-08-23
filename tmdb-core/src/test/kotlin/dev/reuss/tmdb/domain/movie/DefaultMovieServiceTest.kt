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
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.MovieId
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class DefaultMovieServiceTest {
    private val movieId = MovieId.of(550)

    @Test
    fun details_shouldSupportLanguageAndAppendOverloads() {
        val append = AppendToResponse.of(MovieAppend.CREDITS, MovieAppend.VIDEOS)

        assertRequest<MovieDetails>("/movie/550") {
            DefaultMovieService(it).details(movieId)
        }
        assertRequest<MovieDetails>("/movie/550", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).details(movieId, Languages.DE_DE)
        }
        assertRequest<MovieDetails>(
            "/movie/550",
            mapOf("append_to_response" to "credits,videos"),
        ) {
            DefaultMovieService(it).details(movieId, append)
        }
        assertRequest<MovieDetails>(
            "/movie/550",
            mapOf("language" to "de-DE", "append_to_response" to "credits,videos"),
        ) {
            DefaultMovieService(it).details(movieId, Languages.DE_DE, append)
        }
    }

    @Test
    fun alternativeTitles_shouldSupportOptionalCountry() {
        assertRequest<MovieAlternativeTitles>("/movie/550/alternative_titles") {
            DefaultMovieService(it).alternativeTitles(movieId)
        }
        assertRequest<MovieAlternativeTitles>(
            "/movie/550/alternative_titles",
            mapOf("country" to "DE"),
        ) {
            DefaultMovieService(it).alternativeTitles(movieId, Regions.DE)
        }
    }

    @Test
    fun changes_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<MovieChanges>("/movie/550/changes") {
            DefaultMovieService(it).changes(movieId)
        }
        assertRequest<MovieChanges>(
            "/movie/550/changes",
            mapOf("end_date" to "2024-01-14", "page" to "2", "start_date" to "2024-01-01"),
        ) {
            DefaultMovieService(it).changes(
                movieId,
                ChangesQuery
                    .create()
                    .startDate(LocalDate.of(2024, 1, 1))
                    .endDate(LocalDate.of(2024, 1, 14))
                    .page(2),
            )
        }
    }

    @Test
    fun credits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<MovieCredits>("/movie/550/credits") {
            DefaultMovieService(it).credits(movieId)
        }
        assertRequest<MovieCredits>("/movie/550/credits", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).credits(movieId, Languages.DE_DE)
        }
    }

    @Test
    fun nowPlaying_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<MovieNowPlayingResponse>("/movie/now_playing") {
            DefaultMovieService(it).nowPlaying()
        }
        assertRequest<MovieNowPlayingResponse>(
            "/movie/now_playing",
            mapOf("language" to "de-DE"),
        ) {
            DefaultMovieService(it).nowPlaying(Languages.DE_DE)
        }
        assertRequest<MovieNowPlayingResponse>(
            "/movie/now_playing",
            mapOf("language" to "de-DE", "page" to "2", "region" to "DE"),
        ) {
            DefaultMovieService(it).nowPlaying(
                MovieNowPlayingQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
            )
        }
    }

    @Test
    fun popular_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<MoviePopularResponse>("/movie/popular") {
            DefaultMovieService(it).popular()
        }
        assertRequest<MoviePopularResponse>("/movie/popular", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).popular(Languages.DE_DE)
        }
        assertRequest<MoviePopularResponse>(
            "/movie/popular",
            mapOf("language" to "de-DE", "page" to "2", "region" to "DE"),
        ) {
            DefaultMovieService(it).popular(
                MoviePopularQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
            )
        }
    }

    @Test
    fun topRated_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<MovieTopRatedResponse>("/movie/top_rated") {
            DefaultMovieService(it).topRated()
        }
        assertRequest<MovieTopRatedResponse>("/movie/top_rated", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).topRated(Languages.DE_DE)
        }
        assertRequest<MovieTopRatedResponse>(
            "/movie/top_rated",
            mapOf("language" to "de-DE", "page" to "2", "region" to "DE"),
        ) {
            DefaultMovieService(it).topRated(
                MovieTopRatedQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
            )
        }
    }

    @Test
    fun upcoming_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<MovieUpcomingResponse>("/movie/upcoming") {
            DefaultMovieService(it).upcoming()
        }
        assertRequest<MovieUpcomingResponse>("/movie/upcoming", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).upcoming(Languages.DE_DE)
        }
        assertRequest<MovieUpcomingResponse>(
            "/movie/upcoming",
            mapOf("language" to "de-DE", "page" to "2", "region" to "DE"),
        ) {
            DefaultMovieService(it).upcoming(
                MovieUpcomingQuery
                    .create()
                    .language(Languages.DE_DE)
                    .page(2)
                    .region(Regions.DE),
            )
        }
    }

    @Test
    fun recommendations_shouldSupportAllOverloads() {
        assertRequest<MovieRecommendations>("/movie/550/recommendations") {
            DefaultMovieService(it).recommendations(movieId)
        }
        assertRequest<MovieRecommendations>(
            "/movie/550/recommendations",
            mapOf("language" to "de-DE"),
        ) {
            DefaultMovieService(it).recommendations(movieId, Languages.DE_DE)
        }
        assertRequest<MovieRecommendations>(
            "/movie/550/recommendations",
            mapOf("page" to "2"),
        ) {
            DefaultMovieService(it).recommendations(movieId, 2)
        }
        assertRequest<MovieRecommendations>(
            "/movie/550/recommendations",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultMovieService(it).recommendations(
                movieId,
                MovieRecommendationsQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun reviews_shouldSupportAllOverloads() {
        assertRequest<MovieReviews>("/movie/550/reviews") {
            DefaultMovieService(it).reviews(movieId)
        }
        assertRequest<MovieReviews>("/movie/550/reviews", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).reviews(movieId, Languages.DE_DE)
        }
        assertRequest<MovieReviews>("/movie/550/reviews", mapOf("page" to "2")) {
            DefaultMovieService(it).reviews(movieId, 2)
        }
        assertRequest<MovieReviews>(
            "/movie/550/reviews",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultMovieService(it).reviews(
                movieId,
                MovieReviewsQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun similar_shouldSupportAllOverloads() {
        assertRequest<SimilarMovies>("/movie/550/similar") {
            DefaultMovieService(it).similar(movieId)
        }
        assertRequest<SimilarMovies>("/movie/550/similar", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).similar(movieId, Languages.DE_DE)
        }
        assertRequest<SimilarMovies>("/movie/550/similar", mapOf("page" to "2")) {
            DefaultMovieService(it).similar(movieId, 2)
        }
        assertRequest<SimilarMovies>(
            "/movie/550/similar",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultMovieService(it).similar(
                movieId,
                MovieSimilarQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun pageOverloads_shouldRejectInvalidPageBeforeHttpCall() {
        val http = RecordingTmdbHttpClient()
        val service = DefaultMovieService(http)

        assertThrows<IllegalArgumentException> { service.recommendations(movieId, 0) }
        assertThrows<IllegalArgumentException> { service.reviews(movieId, -1) }
        assertThrows<IllegalArgumentException> { service.similar(movieId, 0) }
        assertEquals(0, http.calls())
    }

    @Test
    fun videos_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<MovieVideos>("/movie/550/videos") {
            DefaultMovieService(it).videos(movieId)
        }
        assertRequest<MovieVideos>("/movie/550/videos", mapOf("language" to "de-DE")) {
            DefaultMovieService(it).videos(movieId, Languages.DE_DE)
        }
    }

    @Test
    fun images_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<MovieImages>("/movie/550/images") {
            DefaultMovieService(it).images(movieId)
        }
        assertRequest<MovieImages>(
            "/movie/550/images",
            mapOf("language" to "de-DE", "include_image_language" to "de,en,null"),
        ) {
            DefaultMovieService(it).images(
                movieId,
                ImageQuery(Languages.DE_DE, "de,en,null"),
            )
        }
    }

    @Test
    fun remainingResourceMethods_shouldUseExpectedPathsAndTypes() {
        assertRequest<ExternalIds>("/movie/550/external_ids") {
            DefaultMovieService(it).externalIds(movieId)
        }
        assertRequest<MovieKeywords>("/movie/550/keywords") {
            DefaultMovieService(it).keywords(movieId)
        }
        assertRequest<MovieDetails>("/movie/latest") {
            DefaultMovieService(it).latest()
        }
        assertRequest<MovieReleaseDates>("/movie/550/release_dates") {
            DefaultMovieService(it).releaseDates(movieId)
        }
        assertRequest<MovieTranslations>("/movie/550/translations") {
            DefaultMovieService(it).translations(movieId)
        }
        assertRequest<MovieWatchProviders>("/movie/550/watch/providers") {
            DefaultMovieService(it).watchProviders(movieId)
        }
    }
}
