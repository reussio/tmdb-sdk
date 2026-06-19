package dev.reuss.tmdb.domain.tv.series.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for date-based TMDB TV series list endpoints.
 */
public final class TvSeriesDateListQuery implements PagedQuery<TvSeriesDateListQuery> {

    private Language language;
    private Integer page;
    private String timezone;

    private TvSeriesDateListQuery() {
    }

    public static TvSeriesDateListQuery create() {
        return new TvSeriesDateListQuery();
    }

    public TvSeriesDateListQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public TvSeriesDateListQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    /**
     * Sets the timezone used by date-based TV list endpoints.
     *
     * @param timezone timezone, for example {@code Europe/Berlin}
     * @return this query
     */
    public TvSeriesDateListQuery timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language)
                .add("page", page)
                .add("timezone", timezone);
    }
}