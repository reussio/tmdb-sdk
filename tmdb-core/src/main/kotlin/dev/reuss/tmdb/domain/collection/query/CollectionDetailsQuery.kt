package dev.reuss.tmdb.domain.collection.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.TmdbQuery
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for collection details.
 *
 * @property language Language used to localize the response.
 */
data class CollectionDetailsQuery(
    val language: Language? = null,
) : TmdbQuery {
    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("language", language?.value)

    companion object {
        /** Creates a query that relies on the client's default language. */
        @JvmStatic
        fun empty(): CollectionDetailsQuery = CollectionDetailsQuery()

        /** Creates a query that requests [language]. */
        @JvmStatic
        fun of(language: Language): CollectionDetailsQuery = CollectionDetailsQuery(language)
    }
}
