package dev.reuss.tmdb.domain.collection.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.TmdbQuery
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for collection details.
 *
 * @property language response language
 */
data class CollectionDetailsQuery(
    val language: Language? = null,
) : TmdbQuery {
    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("language", language?.value)

    companion object {
        @JvmStatic
        fun empty(): CollectionDetailsQuery = CollectionDetailsQuery()

        @JvmStatic
        fun of(language: Language): CollectionDetailsQuery = CollectionDetailsQuery(language)
    }
}
