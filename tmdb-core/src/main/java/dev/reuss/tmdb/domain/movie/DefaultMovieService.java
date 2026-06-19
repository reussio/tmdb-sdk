package dev.reuss.tmdb.domain.movie;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.MovieImages;
import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.movie.model.*;
import dev.reuss.tmdb.domain.movie.query.MovieRecommendationsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieReviewsQuery;
import dev.reuss.tmdb.domain.movie.query.MovieSimilarQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.id.MovieId;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

import java.util.Objects;

public final class DefaultMovieService implements MovieService {

    private final TmdbHttpClient httpClient;

    public DefaultMovieService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public MovieDetails details(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.details(movieId)),
                MovieDetails.class
        );
    }

    @Override
    public MovieDetails details(MovieId movieId, Language language) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.details(movieId),
                        QueryParams.create().add("language", language)
                ),
                MovieDetails.class
        );
    }

    @Override
    public MovieDetails details(
            MovieId movieId,
            AppendToResponse<MovieAppend> appendToResponse
    ) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.details(movieId),
                        QueryParams.create().add("append_to_response", appendToResponse)
                ),
                MovieDetails.class
        );
    }

    @Override
    public MovieDetails details(
            MovieId movieId,
            Language language,
            AppendToResponse<MovieAppend> appendToResponse
    ) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");
        Objects.requireNonNull(appendToResponse, "Append to response must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.details(movieId),
                        QueryParams.create()
                                .add("language", language)
                                .add("append_to_response", appendToResponse)
                ),
                MovieDetails.class
        );
    }

    @Override
    public MovieAlternativeTitles alternativeTitles(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.alternativeTitles(movieId)),
                MovieAlternativeTitles.class
        );
    }

    @Override
    public MovieAlternativeTitles alternativeTitles(MovieId movieId, Region country) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(country, "Country must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.alternativeTitles(movieId),
                        QueryParams.create().add("country", country)
                ),
                MovieAlternativeTitles.class
        );
    }

    @Override
    public MovieChanges changes(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.changes(movieId)),
                MovieChanges.class
        );
    }

    @Override
    public MovieChanges changes(MovieId movieId, ChangesQuery query) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(query, "Changes query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.changes(movieId),
                        query.toQueryParams()
                ),
                MovieChanges.class
        );
    }

    @Override
    public MovieCredits credits(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.credits(movieId)),
                MovieCredits.class
        );
    }

    @Override
    public MovieCredits credits(MovieId movieId, Language language) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.credits(movieId),
                        QueryParams.create().add("language", language)
                ),
                MovieCredits.class
        );
    }

    @Override
    public ExternalIds externalIds(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.externalIds(movieId)),
                ExternalIds.class
        );
    }

    @Override
    public MovieKeywords keywords(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.keywords(movieId)),
                MovieKeywords.class
        );
    }

    @Override
    public MovieDetails latest() {
        return httpClient.get(
                TmdbRequest.get(MoviePaths.latest()),
                MovieDetails.class
        );
    }

    @Override
    public MovieRecommendations recommendations(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.recommendations(movieId)),
                MovieRecommendations.class
        );
    }

    @Override
    public MovieRecommendations recommendations(MovieId movieId, Language language) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.recommendations(movieId),
                        QueryParams.create().add("language", language)
                ),
                MovieRecommendations.class
        );
    }

    @Override
    public MovieRecommendations recommendations(MovieId movieId, int page) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        QueryValidation.validatePage(page);

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.recommendations(movieId),
                        QueryParams.create().add("page", page)
                ),
                MovieRecommendations.class
        );
    }

    @Override
    public MovieRecommendations recommendations(MovieId movieId, MovieRecommendationsQuery query) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(query, "Movie recommendations query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.recommendations(movieId),
                        query.toQueryParams()
                ),
                MovieRecommendations.class
        );
    }

    @Override
    public MovieReleaseDates releaseDates(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.releaseDates(movieId)),
                MovieReleaseDates.class
        );
    }

    @Override
    public MovieReviews reviews(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.reviews(movieId)),
                MovieReviews.class
        );
    }

    @Override
    public MovieReviews reviews(MovieId movieId, Language language) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.reviews(movieId),
                        QueryParams.create().add("language", language)
                ),
                MovieReviews.class
        );
    }

    @Override
    public MovieReviews reviews(MovieId movieId, int page) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        QueryValidation.validatePage(page);

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.reviews(movieId),
                        QueryParams.create().add("page", page)
                ),
                MovieReviews.class
        );
    }

    @Override
    public MovieReviews reviews(MovieId movieId, MovieReviewsQuery query) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(query, "Movie reviews query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.reviews(movieId),
                        query.toQueryParams()
                ),
                MovieReviews.class
        );
    }

    @Override
    public SimilarMovies similar(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.similar(movieId)),
                SimilarMovies.class
        );
    }

    @Override
    public SimilarMovies similar(MovieId movieId, Language language) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.similar(movieId),
                        QueryParams.create().add("language", language)
                ),
                SimilarMovies.class
        );
    }

    @Override
    public SimilarMovies similar(MovieId movieId, int page) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        QueryValidation.validatePage(page);

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.similar(movieId),
                        QueryParams.create().add("page", page)
                ),
                SimilarMovies.class
        );
    }

    @Override
    public SimilarMovies similar(MovieId movieId, MovieSimilarQuery query) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(query, "Movie similar query must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.similar(movieId),
                        query.toQueryParams()
                ),
                SimilarMovies.class
        );
    }

    @Override
    public MovieTranslations translations(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.translations(movieId)),
                MovieTranslations.class
        );
    }

    @Override
    public MovieVideos videos(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.videos(movieId)),
                MovieVideos.class
        );
    }

    @Override
    public MovieVideos videos(MovieId movieId, Language language) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        MoviePaths.videos(movieId),
                        QueryParams.create().add("language", language)
                ),
                MovieVideos.class
        );
    }

    @Override
    public MovieWatchProviders watchProviders(MovieId movieId) {
        Objects.requireNonNull(movieId, "Movie id must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.watchProviders(movieId)),
                MovieWatchProviders.class
        );
    }

    @Override
    public MovieImages images(MovieId movieId) {
        return images(movieId, ImageQuery.none());
    }

    @Override
    public MovieImages images(MovieId movieId, ImageQuery query) {
        Objects.requireNonNull(movieId, "Movie id must not be null");
        Objects.requireNonNull(query, "Image query must not be null");

        return httpClient.get(
                TmdbRequest.get(MoviePaths.images(movieId), query.toQueryParams()),
                MovieImages.class
        );
    }
}
