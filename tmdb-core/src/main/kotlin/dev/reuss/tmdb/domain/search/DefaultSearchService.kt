package dev.reuss.tmdb.domain.search

import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.search.model.collection.SearchCollectionResponse
import dev.reuss.tmdb.domain.search.model.company.SearchCompanyResponse
import dev.reuss.tmdb.domain.search.model.keyword.SearchKeywordResponse
import dev.reuss.tmdb.domain.search.model.movie.SearchMovieResponse
import dev.reuss.tmdb.domain.search.model.multi.SearchMultiResponse
import dev.reuss.tmdb.domain.search.model.person.SearchPersonResponse
import dev.reuss.tmdb.domain.search.model.tv.SearchTvShowResponse
import dev.reuss.tmdb.domain.search.query.SearchCollectionQuery
import dev.reuss.tmdb.domain.search.query.SearchCompanyQuery
import dev.reuss.tmdb.domain.search.query.SearchKeywordQuery
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery
import dev.reuss.tmdb.domain.search.query.SearchMultiQuery
import dev.reuss.tmdb.domain.search.query.SearchPersonQuery
import dev.reuss.tmdb.domain.search.query.SearchTvQuery

/**
 * Default [SearchService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultSearchService(
    private val httpClient: TmdbHttpClient,
) : SearchService {
    override fun collections(query: String): SearchCollectionResponse = collections(SearchCollectionQuery.of(query))

    override fun collections(query: SearchCollectionQuery): SearchCollectionResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.collections(),
                query.toQueryParams(),
            ),
            SearchCollectionResponse::class.java,
        )

    override fun companies(query: String): SearchCompanyResponse = companies(SearchCompanyQuery.of(query))

    override fun companies(query: SearchCompanyQuery): SearchCompanyResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.companies(),
                query.toQueryParams(),
            ),
            SearchCompanyResponse::class.java,
        )

    override fun keywords(query: String): SearchKeywordResponse = keywords(SearchKeywordQuery.of(query))

    override fun keywords(query: SearchKeywordQuery): SearchKeywordResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.keywords(),
                query.toQueryParams(),
            ),
            SearchKeywordResponse::class.java,
        )

    override fun movies(query: String): SearchMovieResponse = movies(SearchMovieQuery.of(query))

    override fun movies(query: SearchMovieQuery): SearchMovieResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.movies(),
                query.toQueryParams(),
            ),
            SearchMovieResponse::class.java,
        )

    override fun multi(query: String): SearchMultiResponse = multi(SearchMultiQuery.of(query))

    override fun multi(query: SearchMultiQuery): SearchMultiResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.multi(),
                query.toQueryParams(),
            ),
            SearchMultiResponse::class.java,
        )

    override fun people(query: String): SearchPersonResponse = people(SearchPersonQuery.of(query))

    override fun people(query: SearchPersonQuery): SearchPersonResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.people(),
                query.toQueryParams(),
            ),
            SearchPersonResponse::class.java,
        )

    override fun tv(query: String): SearchTvShowResponse = tv(SearchTvQuery.of(query))

    override fun tv(query: SearchTvQuery): SearchTvShowResponse =
        httpClient.get(
            TmdbRequest.get(
                SearchPaths.tvShows(),
                query.toQueryParams(),
            ),
            SearchTvShowResponse::class.java,
        )
}
