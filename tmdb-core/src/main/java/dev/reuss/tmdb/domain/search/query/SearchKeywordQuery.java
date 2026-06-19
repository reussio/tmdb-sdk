package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;

/**
 * Query parameters for searching TMDB keywords.
 */
public final class SearchKeywordQuery implements SearchQuery, PagedQuery<SearchKeywordQuery> {

    private final String query;
    private Integer page;

    private SearchKeywordQuery(String query) {
        this.query = QueryValidation.requireNotBlank(query, "Search query");
    }

    public static SearchKeywordQuery of(String query) {
        return new SearchKeywordQuery(query);
    }

    @Override
    public String query() {
        return query;
    }

    public SearchKeywordQuery page(Integer page) {
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