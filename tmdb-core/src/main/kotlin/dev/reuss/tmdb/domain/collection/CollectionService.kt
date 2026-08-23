package dev.reuss.tmdb.domain.collection

import dev.reuss.tmdb.common.image.CollectionImages
import dev.reuss.tmdb.domain.collection.model.CollectionDetails
import dev.reuss.tmdb.domain.collection.model.CollectionTranslations
import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.CollectionId
import dev.reuss.tmdb.value.language.Language

/** Loads movie-collection metadata, artwork, and translations. */
interface CollectionService {
    /** Returns collection details using the client's default language. */
    fun details(collectionId: CollectionId): CollectionDetails

    /** Returns collection details localized in [language]. */
    fun details(
        collectionId: CollectionId,
        language: Language,
    ): CollectionDetails

    /** Returns collection details using [query]. */
    fun details(
        collectionId: CollectionId,
        query: CollectionDetailsQuery,
    ): CollectionDetails

    /** Returns collection backdrops and posters using the client's default language filters. */
    fun images(collectionId: CollectionId): CollectionImages

    /** Returns collection backdrops and posters using the language filters in [query]. */
    fun images(
        collectionId: CollectionId,
        query: ImageQuery,
    ): CollectionImages

    /** Returns every translation recorded for the collection. */
    fun translations(collectionId: CollectionId): CollectionTranslations
}
