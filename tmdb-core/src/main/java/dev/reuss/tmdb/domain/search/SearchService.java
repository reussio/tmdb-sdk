package dev.reuss.tmdb.domain.search;

import dev.reuss.tmdb.domain.search.model.collection.SearchCollectionResponse;
import dev.reuss.tmdb.domain.search.model.company.SearchCompanyResponse;
import dev.reuss.tmdb.domain.search.model.keyword.SearchKeywordResponse;
import dev.reuss.tmdb.domain.search.model.movie.SearchMovieResponse;
import dev.reuss.tmdb.domain.search.model.multi.SearchMultiResponse;
import dev.reuss.tmdb.domain.search.model.person.SearchPersonResponse;
import dev.reuss.tmdb.domain.search.model.tv.SearchTvShowResponse;
import dev.reuss.tmdb.domain.search.query.*;

/**
 * Service for searching TMDB resources.
 */
public interface SearchService {

    /**
     * Searches for collections by their original, translated and alternative names.
     *
     * @param query search query
     * @return collection search results
     */
    SearchCollectionResponse collections(String query);

    /**
     * Searches for collections by their original, translated and alternative names.
     *
     * @param query search collection query
     * @return collection search results
     */
    SearchCollectionResponse collections(SearchCollectionQuery query);

    /**
     * Searches for companies by their original and alternative names.
     *
     * @param query search query
     * @return company search results
     */
    SearchCompanyResponse companies(String query);

    /**
     * Searches for companies by their original and alternative names.
     *
     * @param query search company query
     * @return company search results
     */
    SearchCompanyResponse companies(SearchCompanyQuery query);

    /**
     * Searches for keywords by their name.
     *
     * @param query search query
     * @return keyword search results
     */
    SearchKeywordResponse keywords(String query);

    /**
     * Searches for keywords by their name.
     *
     * @param query search keyword query
     * @return keyword search results
     */
    SearchKeywordResponse keywords(SearchKeywordQuery query);

    /**
     * Searches for movies by their original, translated and alternative titles.
     *
     * @param query search query
     * @return movie search results
     */
    SearchMovieResponse movies(String query);

    /**
     * Searches for movies by their original, translated and alternative titles.
     *
     * @param query search movie query
     * @return movie search results
     */
    SearchMovieResponse movies(SearchMovieQuery query);

    /**
     * Searches for movies, TV shows and people in a single request.
     *
     * @param query search query
     * @return multi search results
     */
    SearchMultiResponse multi(String query);

    /**
     * Searches for movies, TV shows and people in a single request.
     *
     * @param query search multi query
     * @return multi search results
     */
    SearchMultiResponse multi(SearchMultiQuery query);

    /**
     * Searches for people by their name and also known as names.
     *
     * @param query search query
     * @return person search results
     */
    SearchPersonResponse people(String query);

    /**
     * Searches for people by their name and also known as names.
     *
     * @param query search person query
     * @return person search results
     */
    SearchPersonResponse people(SearchPersonQuery query);

    /**
     * Searches for TV shows by their original, translated and also known as names.
     *
     * @param query search query
     * @return TV show search results
     */
    SearchTvShowResponse tv(String query);

    /**
     * Searches for TV shows by their original, translated and also known as names.
     *
     * @param query search TV query
     * @return TV show search results
     */
    SearchTvShowResponse tv(SearchTvQuery query);
}