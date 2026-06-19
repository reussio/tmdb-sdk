package dev.reuss.tmdb.domain.search.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.domain.search.SearchQuery;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

/**
 * Query parameters for searching TMDB collections.
 */
public final class SearchCollectionQuery implements SearchQuery, PagedQuery<SearchCollectionQuery> {

    private final String query;
    private Boolean includeAdult;
    private Language language;
    private Integer page;
    private Region region;

    private SearchCollectionQuery(String query) {
        this.query = QueryValidation.requireNotBlank(query, "Search query");
    }

    public static SearchCollectionQuery of(String query) {
        return new SearchCollectionQuery(query);
    }

    @Override
    public String query() {
        return query;
    }

    public SearchCollectionQuery includeAdult(Boolean includeAdult) {
        this.includeAdult = includeAdult;
        return this;
    }

    public SearchCollectionQuery language(Language language) {
        this.language = language;
        return this;
    }

    public SearchCollectionQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    public SearchCollectionQuery region(Region region) {
        this.region = region;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("query", query)
                .add("include_adult", includeAdult)
                .add("language", language)
                .add("page", page)
                .add("region", region);
    }
}
