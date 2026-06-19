package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

/**
 * Query parameters for searching TMDB movies.
 */
public final class SearchMovieQuery implements SearchQuery, PagedQuery<SearchMovieQuery> {

    private final String query;
    private Boolean includeAdult;
    private Language language;
    private String primaryReleaseYear;
    private Integer page;
    private Region region;
    private String year;

    private SearchMovieQuery(String query) {
        this.query = QueryValidation.requireNotBlank(query, "Search query");
    }

    public static SearchMovieQuery of(String query) {
        return new SearchMovieQuery(query);
    }

    @Override
    public String query() {
        return query;
    }

    public SearchMovieQuery includeAdult(Boolean includeAdult) {
        this.includeAdult = includeAdult;
        return this;
    }

    public SearchMovieQuery language(Language language) {
        this.language = language;
        return this;
    }

    public SearchMovieQuery primaryReleaseYear(String primaryReleaseYear) {
        QueryValidation.validateYear(primaryReleaseYear, "Primary release year");
        this.primaryReleaseYear = primaryReleaseYear;
        return this;
    }

    public SearchMovieQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    public SearchMovieQuery region(Region region) {
        this.region = region;
        return this;
    }

    public SearchMovieQuery year(String year) {
        QueryValidation.validateYear(year, "Year");
        this.year = year;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("query", query)
                .add("include_adult", includeAdult)
                .add("language", language)
                .add("primary_release_year", primaryReleaseYear)
                .add("page", page)
                .add("region", region)
                .add("year", year);
    }
}
