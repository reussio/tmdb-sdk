package dev.reuss.tmdb.domain.movie

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.MovieImages
import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.movie.model.*
import dev.reuss.tmdb.domain.movie.query.*
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.query.QueryValidation
import dev.reuss.tmdb.value.id.MovieId
import dev.reuss.tmdb.value.language.Language
import dev.reuss.tmdb.value.region.Region

/**
 * Default [MovieService] implementation backed by TMDB HTTP requests.
 */
internal class DefaultMovieService(
    private val httpClient: TmdbHttpClient
) : MovieService {

    override fun details(movieId: MovieId): MovieDetails =
        httpClient.get(
            TmdbRequest.get(MoviePaths.details(movieId)),
            MovieDetails::class.java
        )

    override fun details(
        movieId: MovieId,
        language: Language
    ): MovieDetails =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.details(movieId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieDetails::class.java
        )

    override fun details(
        movieId: MovieId,
        appendToResponse: AppendToResponse<MovieAppend>
    ): MovieDetails =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.details(movieId),
                QueryParams.create()
                    .add("append_to_response", appendToResponse)
            ),
            MovieDetails::class.java
        )

    override fun details(
        movieId: MovieId,
        language: Language,
        appendToResponse: AppendToResponse<MovieAppend>
    ): MovieDetails =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.details(movieId),
                QueryParams.create()
                    .add("language", language.value)
                    .add("append_to_response", appendToResponse)
            ),
            MovieDetails::class.java
        )

    override fun alternativeTitles(movieId: MovieId): MovieAlternativeTitles =
        httpClient.get(
            TmdbRequest.get(MoviePaths.alternativeTitles(movieId)),
            MovieAlternativeTitles::class.java
        )

    override fun alternativeTitles(
        movieId: MovieId,
        country: Region
    ): MovieAlternativeTitles =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.alternativeTitles(movieId),
                QueryParams.create()
                    .add("country", country.value)
            ),
            MovieAlternativeTitles::class.java
        )

    override fun changes(movieId: MovieId): MovieChanges =
        httpClient.get(
            TmdbRequest.get(MoviePaths.changes(movieId)),
            MovieChanges::class.java
        )

    override fun changes(
        movieId: MovieId,
        query: ChangesQuery
    ): MovieChanges =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.changes(movieId),
                query.toQueryParams()
            ),
            MovieChanges::class.java
        )

    override fun credits(movieId: MovieId): MovieCredits =
        httpClient.get(
            TmdbRequest.get(MoviePaths.credits(movieId)),
            MovieCredits::class.java
        )

    override fun credits(
        movieId: MovieId,
        language: Language
    ): MovieCredits =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.credits(movieId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieCredits::class.java
        )

    override fun externalIds(movieId: MovieId): ExternalIds =
        httpClient.get(
            TmdbRequest.get(MoviePaths.externalIds(movieId)),
            ExternalIds::class.java
        )

    override fun keywords(movieId: MovieId): MovieKeywords =
        httpClient.get(
            TmdbRequest.get(MoviePaths.keywords(movieId)),
            MovieKeywords::class.java
        )

    override fun latest(): MovieDetails =
        httpClient.get(
            TmdbRequest.get(MoviePaths.latest()),
            MovieDetails::class.java
        )

    override fun nowPlaying(): MovieNowPlayingResponse =
        httpClient.get(
            TmdbRequest.get(MoviePaths.nowPlaying()),
            MovieNowPlayingResponse::class.java
        )

    override fun nowPlaying(language: Language): MovieNowPlayingResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.nowPlaying(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieNowPlayingResponse::class.java
        )

    override fun nowPlaying(query: MovieNowPlayingQuery): MovieNowPlayingResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.nowPlaying(),
                query.toQueryParams()
            ),
            MovieNowPlayingResponse::class.java
        )

    override fun popular(): MoviePopularResponse =
        httpClient.get(
            TmdbRequest.get(MoviePaths.popular()),
            MoviePopularResponse::class.java
        )

    override fun popular(language: Language): MoviePopularResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.popular(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MoviePopularResponse::class.java
        )

    override fun popular(query: MoviePopularQuery): MoviePopularResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.popular(),
                query.toQueryParams()
            ),
            MoviePopularResponse::class.java
        )

    override fun topRated(): MovieTopRatedResponse =
        httpClient.get(
            TmdbRequest.get(MoviePaths.topRated()),
            MovieTopRatedResponse::class.java
        )

    override fun topRated(language: Language): MovieTopRatedResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.topRated(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieTopRatedResponse::class.java
        )

    override fun topRated(query: MovieTopRatedQuery): MovieTopRatedResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.topRated(),
                query.toQueryParams()
            ),
            MovieTopRatedResponse::class.java
        )

    override fun upcoming(): MovieUpcomingResponse =
        httpClient.get(
            TmdbRequest.get(MoviePaths.upcoming()),
            MovieUpcomingResponse::class.java
        )

    override fun upcoming(language: Language): MovieUpcomingResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.upcoming(),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieUpcomingResponse::class.java
        )

    override fun upcoming(query: MovieUpcomingQuery): MovieUpcomingResponse =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.upcoming(),
                query.toQueryParams()
            ),
            MovieUpcomingResponse::class.java
        )

    override fun recommendations(movieId: MovieId): MovieRecommendations =
        httpClient.get(
            TmdbRequest.get(MoviePaths.recommendations(movieId)),
            MovieRecommendations::class.java
        )

    override fun recommendations(
        movieId: MovieId,
        language: Language
    ): MovieRecommendations =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.recommendations(movieId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieRecommendations::class.java
        )

    override fun recommendations(
        movieId: MovieId,
        page: Int
    ): MovieRecommendations {
        QueryValidation.validatePage(page)

        return httpClient.get(
            TmdbRequest.get(
                MoviePaths.recommendations(movieId),
                QueryParams.create()
                    .add("page", page)
            ),
            MovieRecommendations::class.java
        )
    }

    override fun recommendations(
        movieId: MovieId,
        query: MovieRecommendationsQuery
    ): MovieRecommendations =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.recommendations(movieId),
                query.toQueryParams()
            ),
            MovieRecommendations::class.java
        )

    override fun releaseDates(movieId: MovieId): MovieReleaseDates =
        httpClient.get(
            TmdbRequest.get(MoviePaths.releaseDates(movieId)),
            MovieReleaseDates::class.java
        )

    override fun reviews(movieId: MovieId): MovieReviews =
        httpClient.get(
            TmdbRequest.get(MoviePaths.reviews(movieId)),
            MovieReviews::class.java
        )

    override fun reviews(
        movieId: MovieId,
        language: Language
    ): MovieReviews =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.reviews(movieId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieReviews::class.java
        )

    override fun reviews(
        movieId: MovieId,
        page: Int
    ): MovieReviews {
        QueryValidation.validatePage(page)

        return httpClient.get(
            TmdbRequest.get(
                MoviePaths.reviews(movieId),
                QueryParams.create()
                    .add("page", page)
            ),
            MovieReviews::class.java
        )
    }

    override fun reviews(
        movieId: MovieId,
        query: MovieReviewsQuery
    ): MovieReviews =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.reviews(movieId),
                query.toQueryParams()
            ),
            MovieReviews::class.java
        )

    override fun similar(movieId: MovieId): SimilarMovies =
        httpClient.get(
            TmdbRequest.get(MoviePaths.similar(movieId)),
            SimilarMovies::class.java
        )

    override fun similar(
        movieId: MovieId,
        language: Language
    ): SimilarMovies =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.similar(movieId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            SimilarMovies::class.java
        )

    override fun similar(
        movieId: MovieId,
        page: Int
    ): SimilarMovies {
        QueryValidation.validatePage(page)

        return httpClient.get(
            TmdbRequest.get(
                MoviePaths.similar(movieId),
                QueryParams.create()
                    .add("page", page)
            ),
            SimilarMovies::class.java
        )
    }

    override fun similar(
        movieId: MovieId,
        query: MovieSimilarQuery
    ): SimilarMovies =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.similar(movieId),
                query.toQueryParams()
            ),
            SimilarMovies::class.java
        )

    override fun translations(movieId: MovieId): MovieTranslations =
        httpClient.get(
            TmdbRequest.get(MoviePaths.translations(movieId)),
            MovieTranslations::class.java
        )

    override fun videos(movieId: MovieId): MovieVideos =
        httpClient.get(
            TmdbRequest.get(MoviePaths.videos(movieId)),
            MovieVideos::class.java
        )

    override fun videos(
        movieId: MovieId,
        language: Language
    ): MovieVideos =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.videos(movieId),
                QueryParams.create()
                    .add("language", language.value)
            ),
            MovieVideos::class.java
        )

    override fun watchProviders(movieId: MovieId): MovieWatchProviders =
        httpClient.get(
            TmdbRequest.get(MoviePaths.watchProviders(movieId)),
            MovieWatchProviders::class.java
        )

    override fun images(movieId: MovieId): MovieImages =
        images(movieId, ImageQuery.none())

    override fun images(
        movieId: MovieId,
        query: ImageQuery
    ): MovieImages =
        httpClient.get(
            TmdbRequest.get(
                MoviePaths.images(movieId),
                query.toQueryParams()
            ),
            MovieImages::class.java
        )
}