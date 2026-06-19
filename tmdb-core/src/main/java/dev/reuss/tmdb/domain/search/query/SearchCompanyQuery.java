package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;

/**
 * Query parameters for searching TMDB companies.
 *
 * <p>The search text is required and must not be blank. The optional page value
 * is validated by {@link QueryValidation#validatePage(Integer)}.</p>
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
