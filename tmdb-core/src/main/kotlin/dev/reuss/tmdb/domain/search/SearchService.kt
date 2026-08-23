package dev.reuss.tmdb.domain.search

import dev.reuss.tmdb.domain.search.model.collection.SearchCollectionResponse
import dev.reuss.tmdb.domain.search.model.company.SearchCompanyResponse
import dev.reuss.tmdb.domain.search.model.keyword.SearchKeywordResponse
import dev.reuss.tmdb.domain.search.model.movie.SearchMovieResponse
import dev.reuss.tmdb.domain.search.model.multi.SearchMultiResponse
import dev.reuss.tmdb.domain.search.model.person.SearchPersonResponse
import dev.reuss.tmdb.domain.search.model.tv.SearchTvShowResponse
import dev.reuss.tmdb.domain.search.query.*

/**
 * Service for searching TMDB resources.
 */
interface SearchService {

    /**
     * Searches for collections by their original, translated and alternative names.
     *
     * @param query search query
     * @return collection search results
     */
    fun collections(query: String): SearchCollectionResponse

    /**
     * Searches for collections by their original, translated and alternative names.
     *
     * @param query search collection query
     * @return collection search results
     */
    fun collections(query: SearchCollectionQuery): SearchCollectionResponse

    /**
     * Searches for companies by their original and alternative names.
     *
     * @param query search query
     * @return company search results
     */
    fun companies(query: String): SearchCompanyResponse

    /**
     * Searches for companies by their original and alternative names.
     *
     * @param query search company query
     * @return company search results
     */
    fun companies(query: SearchCompanyQuery): SearchCompanyResponse

    /**
     * Searches for keywords by their name.
     *
     * @param query search query
     * @return keyword search results
     */
    fun keywords(query: String): SearchKeywordResponse

    /**
     * Searches for keywords by their name.
     *
     * @param query search keyword query
     * @return keyword search results
     */
    fun keywords(query: SearchKeywordQuery): SearchKeywordResponse

    /**
     * Searches for movies by their original, translated and alternative titles.
     *
     * @param query search query
     * @return movie search results
     */
    fun movies(query: String): SearchMovieResponse

    /**
     * Searches for movies by their original, translated and alternative titles.
     *
     * @param query search movie query
     * @return movie search results
     */
    fun movies(query: SearchMovieQuery): SearchMovieResponse

    /**
     * Searches for movies, TV shows and people in a single request.
     *
     * @param query search query
     * @return multi search results
     */
    fun multi(query: String): SearchMultiResponse

    /**
     * Searches for movies, TV shows and people in a single request.
     *
     * @param query search multi query
     * @return multi search results
     */
    fun multi(query: SearchMultiQuery): SearchMultiResponse

    /**
     * Searches for people by their name and also known as names.
     *
     * @param query search query
     * @return person search results
     */
    fun people(query: String): SearchPersonResponse

    /**
     * Searches for people by their name and also known as names.
     *
     * @param query search person query
     * @return person search results
     */
    fun people(query: SearchPersonQuery): SearchPersonResponse

    /**
     * Searches for TV shows by their original, translated and also known as names.
     *
     * @param query search query
     * @return TV show search results
     */
    fun tv(query: String): SearchTvShowResponse

    /**
     * Searches for TV shows by their original, translated and also known as names.
     *
     * @param query search TV query
     * @return TV show search results
     */
    fun tv(query: SearchTvQuery): SearchTvShowResponse
}