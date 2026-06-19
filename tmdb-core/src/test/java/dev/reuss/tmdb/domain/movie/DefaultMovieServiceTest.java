package dev.reuss.tmdb.domain.movie;

import dev.reuss.tmdb.domain.movie.model.MovieDetails;
import dev.reuss.tmdb.domain.movie.model.MovieRecommendations;
import dev.reuss.tmdb.domain.movie.model.MovieReviews;
import dev.reuss.tmdb.domain.movie.model.SimilarMovies;
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieReviewsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieSimilarQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.id.MovieId;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultMovieServiceTest {

    @Test
    void detailsPassesMoviePathLanguageAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultMovieService(http).details(MovieId.of(550), Language.of("de-DE"));

        assertLastRequest(http, "/movie/550", Map.of("language", "de-DE"), MovieDetails.class);
    }

    @Test
    void detailsPassesAppendToResponse() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultMovieService(http).details(
                MovieId.of(550),
                AppendToResponse.of(MovieAppend.CREDITS, MovieAppend.WATCH_PROVIDERS)
        );

        assertLastRequest(
                http,
                "/movie/550",
                Map.of("append_to_response", "credits,watch/providers"),
                MovieDetails.class
        );
    }

    @Test
    void recommendationsPassesQueryParams() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultMovieService(http).recommendations(
                MovieId.of(550),
                MovieRecommendationsQuery.create().language(Language.of("de-DE")).page(2)
        );

        assertLastRequest(
                http,
                "/movie/550/recommendations",
                Map.of("language", "de-DE", "page", "2"),
                MovieRecommendations.class
        );
    }

    @Test
    void reviewsPassesQueryParams() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultMovieService(http).reviews(
                MovieId.of(550),
                MovieReviewsQuery.create().language(Language.of("en-US")).page(3)
        );

        assertLastRequest(
                http,
                "/movie/550/reviews",
                Map.of("language", "en-US", "page", "3"),
                MovieReviews.class
        );
    }

    @Test
    void similarPassesQueryParams() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultMovieService(http).similar(
                MovieId.of(550),
                MovieSimilarQuery.create().language(Language.of("de-DE")).page(4)
        );

        assertLastRequest(
                http,
                "/movie/550/similar",
                Map.of("language", "de-DE", "page", "4"),
                SimilarMovies.class
        );
    }

    @Test
    void rejectsNullRequiredInputs() {
        DefaultMovieService service = new DefaultMovieService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.details(null));
        assertThrows(NullPointerException.class, () -> service.details(MovieId.of(550), (Language) null));
        assertThrows(NullPointerException.class, () -> service.recommendations(MovieId.of(550), (MovieRecommendationsQuery) null));
    }
}
