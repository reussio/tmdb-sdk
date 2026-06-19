package dev.reuss.tmdb.domain.movie.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for movie recommendations.
 *
 * <p>Both language and page are optional. Page values are validated by
 * {@link QueryValidation#validatePage(Integer)}.</p>
 */
public final class MovieRecommendationsQuery implements PagedQuery<MovieRecommendationsQuery> {

    private Language language;
    private Integer page;

    private MovieRecommendationsQuery() {
    }

    public static MovieRecommendationsQuery create() {
        return new MovieRecommendationsQuery();
    }

    public MovieRecommendationsQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public MovieRecommendationsQuery page(Integer page) {
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
