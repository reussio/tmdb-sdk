package dev.reuss.tmdb.domain.search;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.search.model.collection.SearchCollectionResponse;
import dev.reuss.tmdb.domain.search.model.company.SearchCompanyResponse;
import dev.reuss.tmdb.domain.search.model.keyword.SearchKeywordResponse;
import dev.reuss.tmdb.domain.search.model.movie.SearchMovieResponse;
import dev.reuss.tmdb.domain.search.model.multi.SearchMultiResponse;
import dev.reuss.tmdb.domain.search.model.person.SearchPersonResponse;
import dev.reuss.tmdb.domain.search.model.tv.SearchTvShowResponse;
import dev.reuss.tmdb.domain.search.query.*;

import java.util.Objects;

/**
 * Default {@link SearchService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultSearchService implements SearchService {

    private final TmdbHttpClient httpClient;

    public DefaultSearchService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public SearchCollectionResponse collections(String query) {
        return collections(SearchCollectionQuery.of(query));
    }

    @Override
    public SearchCollectionResponse collections(SearchCollectionQuery query) {
        Objects.requireNonNull(query, "Search collection query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.collections(), query.toQueryParams()),
                SearchCollectionResponse.class
        );
    }

    @Override
    public SearchCompanyResponse companies(String query) {
        return companies(SearchCompanyQuery.of(query));
    }

    @Override
    public SearchCompanyResponse companies(SearchCompanyQuery query) {
        Objects.requireNonNull(query, "Search company query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.companies(), query.toQueryParams()),
                SearchCompanyResponse.class
        );
    }

    @Override
    public SearchKeywordResponse keywords(String query) {
        return keywords(SearchKeywordQuery.of(query));
    }

    @Override
    public SearchKeywordResponse keywords(SearchKeywordQuery query) {
        Objects.requireNonNull(query, "Search keyword query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.keywords(), query.toQueryParams()),
                SearchKeywordResponse.class
        );
    }

    @Override
    public SearchMovieResponse movies(String query) {
        return movies(SearchMovieQuery.of(query));
    }

    @Override
    public SearchMovieResponse movies(SearchMovieQuery query) {
        Objects.requireNonNull(query, "Search movie query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.movies(), query.toQueryParams()),
                SearchMovieResponse.class
        );
    }

    @Override
    public SearchMultiResponse multi(String query) {
        return multi(SearchMultiQuery.of(query));
    }

    @Override
    public SearchMultiResponse multi(SearchMultiQuery query) {
        Objects.requireNonNull(query, "Search multi query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.multi(), query.toQueryParams()),
                SearchMultiResponse.class
        );
    }

    @Override
    public SearchPersonResponse people(String query) {
        return people(SearchPersonQuery.of(query));
    }

    @Override
    public SearchPersonResponse people(SearchPersonQuery query) {
        Objects.requireNonNull(query, "Search person query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.people(), query.toQueryParams()),
                SearchPersonResponse.class
        );
    }

    @Override
    public SearchTvShowResponse tv(String query) {
        return tv(SearchTvQuery.of(query));
    }

    @Override
    public SearchTvShowResponse tv(SearchTvQuery query) {
        Objects.requireNonNull(query, "Search TV query must not be null");

        return httpClient.get(
                TmdbRequest.get(SearchPaths.tvShows(), query.toQueryParams()),
                SearchTvShowResponse.class
        );
    }
}
