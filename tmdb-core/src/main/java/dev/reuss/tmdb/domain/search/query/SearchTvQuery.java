package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for searching TMDB TV shows.
 */
public final class SearchTvQuery implements SearchQuery, PagedQuery<SearchTvQuery> {

    private final String query;
    private Integer firstAirDateYear;
    private Boolean includeAdult;
    private Language language;
    private Integer page;
    private Integer year;

    private SearchTvQuery(String query) {
        if (query == null || query.isBlank()) {
            throw new IllegalArgumentException("Search query must not be blank");
        }

        this.query = query.trim();
    }

    public static SearchTvQuery of(String query) {
        return new SearchTvQuery(query);
    }

    public String query() {
        return this.query;
    }

    public SearchTvQuery firstAirDateYear(Integer firstAirDateYear) {
        QueryValidation.validateYear(firstAirDateYear, "First air date year");

        this.firstAirDateYear = firstAirDateYear;
        return this;
    }

    public SearchTvQuery includeAdult(Boolean includeAdult) {
        this.includeAdult = includeAdult;
        return this;
    }

    public SearchTvQuery language(Language language) {
        this.language = language;
        return this;
    }

    public SearchTvQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    public SearchTvQuery year(Integer year) {
        QueryValidation.validateYear(year, "Year");

        this.year = year;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("query", query)
                .add("first_air_date_year", firstAirDateYear)
                .add("include_adult", includeAdult)
                .add("language", language)
                .add("page", page)
                .add("year", year);
    }

}
