package dev.reuss.tmdb.domain.movie.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;

/**
 * Query parameters for TMDB top rated movie lists.
 *
 * <p>Language, page and region are optional. Page values are validated by
 * {@link QueryValidation#validatePage(Integer)}.</p>
 */
public final class MovieTopRatedQuery implements PagedQuery<MovieTopRatedQuery> {

    private Language language;
    private Integer page;
    private Region region;

    private MovieTopRatedQuery() {
    }

    public static MovieTopRatedQuery create() {
        return new MovieTopRatedQuery();
    }

    public MovieTopRatedQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public MovieTopRatedQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    public MovieTopRatedQuery region(Region region) {
        this.region = region;
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language)
                .add("page", page)
                .add("region", region);
    }
}
