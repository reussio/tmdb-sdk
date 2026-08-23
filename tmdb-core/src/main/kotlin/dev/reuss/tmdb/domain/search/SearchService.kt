package dev.reuss.tmdb.domain.search

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

/** Searches TMDB resources by their names, titles, or other text metadata. */
interface SearchService {
    /** Searches collection names using the client's default paging and language settings. */
    fun collections(query: String): SearchCollectionResponse

    /** Searches original, translated, and alternative collection names using [query]. */
    fun collections(query: SearchCollectionQuery): SearchCollectionResponse

    /** Searches company names using the client's default paging settings. */
    fun companies(query: String): SearchCompanyResponse

    /** Searches original and alternative company names using [query]. */
    fun companies(query: SearchCompanyQuery): SearchCompanyResponse

    /** Searches keyword names using the client's default paging settings. */
    fun keywords(query: String): SearchKeywordResponse

    /** Searches keyword names using [query]. */
    fun keywords(query: SearchKeywordQuery): SearchKeywordResponse

    /** Searches movie titles using the client's default paging and language settings. */
    fun movies(query: String): SearchMovieResponse

    /** Searches original, translated, and alternative movie titles using [query]. */
    fun movies(query: SearchMovieQuery): SearchMovieResponse

    /** Searches movies, TV series, and people in one request with default query settings. */
    fun multi(query: String): SearchMultiResponse

    /** Searches movies, TV series, and people in one request using [query]. */
    fun multi(query: SearchMultiQuery): SearchMultiResponse

    /** Searches person names and aliases using the client's default query settings. */
    fun people(query: String): SearchPersonResponse

    /** Searches person names and aliases using [query]. */
    fun people(query: SearchPersonQuery): SearchPersonResponse

    /** Searches TV-series names using the client's default query settings. */
    fun tv(query: String): SearchTvShowResponse

    /** Searches original, translated, and alternative TV-series names using [query]. */
    fun tv(query: SearchTvQuery): SearchTvShowResponse
}
