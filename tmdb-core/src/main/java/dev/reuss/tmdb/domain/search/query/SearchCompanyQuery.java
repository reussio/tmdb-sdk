package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;

/**
 * Query parameters for searching TMDB companies.
 */
public final class SearchCompanyQuery implements SearchQuery, PagedQuery<SearchCompanyQuery> {

    private final String query;
    private Integer page;

    private SearchCompanyQuery(String query) {
        this.query = QueryValidation.requireNotBlank(query, "Search query");
    }

    public static SearchCompanyQuery of(String query) {
        return new SearchCompanyQuery(query);
    }

    @Override
    public String query() {
        return query;
    }

    public SearchCompanyQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("query", query)
                .add("page", page);
    }
}