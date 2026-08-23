package dev.reuss.tmdb.domain.collection

import dev.reuss.tmdb.common.image.CollectionImages
import dev.reuss.tmdb.domain.collection.model.CollectionDetails
import dev.reuss.tmdb.domain.collection.model.CollectionTranslations
import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.CollectionId
import dev.reuss.tmdb.value.language.Language

/**
 * Service for loading TMDB collection data.
 */
interface CollectionService {

    /**
     * Loads collection details.
     */
    fun details(collectionId: CollectionId): CollectionDetails

    /**
     * Loads collection details using a specific language.
     */
    fun details(
        collectionId: CollectionId,
        language: Language
    ): CollectionDetails

    /**
     * Loads collection details using explicit query parameters.
     */
    fun details(
        collectionId: CollectionId,
        query: CollectionDetailsQuery
    ): CollectionDetails

    /**
     * Loads images for a collection.
     */
    fun images(collectionId: CollectionId): CollectionImages

    /**
     * Loads images for a collection using query parameters.
     */
    fun images(
        collectionId: CollectionId,
        query: ImageQuery
    ): CollectionImages

    /**
     * Loads translations for a collection.
     */
    fun translations(collectionId: CollectionId): CollectionTranslations
}