package dev.reuss.tmdb.domain.movie.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.PagedQuery;
import dev.reuss.tmdb.query.QueryValidation;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for similar movies.
 *
 * <p>Both language and page are optional. Page values are validated by
 * {@link QueryValidation#validatePage(Integer)}.</p>
 */
public final class MovieSimilarQuery implements PagedQuery<MovieSimilarQuery> {

    private Language language;
    private Integer page;

    private MovieSimilarQuery() {
    }

    public static MovieSimilarQuery create() {
        return new MovieSimilarQuery();
    }

    public MovieSimilarQuery language(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public MovieSimilarQuery page(Integer page) {
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
