package dev.reuss.tmdb.domain.tv.series.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for TMDB TV series list endpoints.
 */
public final class TvSeriesListQuery implements PagedQuery<TvSeriesListQuery> {

    private Language language;
    private Integer page;

    private TvSeriesListQuery() {
    }

    public static TvSeriesListQuery create() {
        return new TvSeriesListQuery();
    }

    public TvSeriesListQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public TvSeriesListQuery page(Integer page) {
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