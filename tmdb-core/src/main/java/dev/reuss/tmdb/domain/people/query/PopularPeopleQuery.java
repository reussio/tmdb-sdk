package dev.reuss.tmdb.domain.people.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for popular people.
 *
 * <p>Both language and page are optional. Page values are validated by
 * {@link QueryValidation#validatePage(Integer)}.</p>
 */
public final class PopularPeopleQuery implements PagedQuery<PopularPeopleQuery> {

    private Language language;
    private Integer page;

    private PopularPeopleQuery() {
    }

    public static PopularPeopleQuery create() {
        return new PopularPeopleQuery();
    }

    public PopularPeopleQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public PopularPeopleQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language)
                .add("page", page);
    }
}
