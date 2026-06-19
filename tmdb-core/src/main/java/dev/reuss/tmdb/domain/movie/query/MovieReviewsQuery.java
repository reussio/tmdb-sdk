package dev.reuss.tmdb.domain.movie.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for movie reviews.
 */
public final class MovieReviewsQuery implements PagedQuery<MovieReviewsQuery> {

    private Language language;
    private Integer page;

    private MovieReviewsQuery() {
    }

    public static MovieReviewsQuery create() {
        return new MovieReviewsQuery();
    }

    public MovieReviewsQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public MovieReviewsQuery page(Integer page) {
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