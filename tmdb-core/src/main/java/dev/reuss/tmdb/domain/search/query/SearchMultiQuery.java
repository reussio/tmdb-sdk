package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for searching movies, TV shows and people.
 *
 * <p>The search text is required and must not be blank. Optional filters are
 * adult content inclusion, language and page. Page values are validated by
 * {@link QueryValidation#validatePage(Integer)}.</p>
 */
public final class SearchMultiQuery implements SearchQuery, PagedQuery<SearchMultiQuery> {

    private final String query;
    private Boolean includeAdult;
    private Language language;
    private Integer page;

    private SearchMultiQuery(String query) {
        this.query = QueryValidation.requireNotBlank(query, "Search query");
    }

    public static SearchMultiQuery of(String query) {
        return new SearchMultiQuery(query);
    }

    @Override
    public String query() {
        return query;
    }

    public SearchMultiQuery includeAdult(Boolean includeAdult) {
        this.includeAdult = includeAdult;
        return this;
    }

    public SearchMultiQuery language(Language language) {
        this.language = language;
        return this;
    }

    public SearchMultiQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("query", query)
                .add("include_adult", includeAdult)
                .add("language", language)
                .add("page", page);
    }
}
