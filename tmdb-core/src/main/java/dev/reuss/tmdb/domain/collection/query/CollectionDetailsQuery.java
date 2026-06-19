package dev.reuss.tmdb.domain.collection.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.TmdbQuery;
import dev.reuss.tmdb.value.language.Language;

/**
 * Query parameters for collection details.
 *
 * @param language response language
 */
public record CollectionDetailsQuery(
        Language language
) implements TmdbQuery {

    public static CollectionDetailsQuery empty() {
        return new CollectionDetailsQuery(null);
    }

    public static CollectionDetailsQuery of(Language language) {
        return new CollectionDetailsQuery(language);
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language);
    }
}
