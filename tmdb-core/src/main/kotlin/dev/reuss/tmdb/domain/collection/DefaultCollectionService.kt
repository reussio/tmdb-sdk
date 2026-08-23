package dev.reuss.tmdb.domain.collection

import dev.reuss.tmdb.common.image.CollectionImages
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.collection.model.CollectionDetails
import dev.reuss.tmdb.domain.collection.model.CollectionTranslations
import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.value.id.CollectionId
import dev.reuss.tmdb.value.language.Language

/**
 * Default collection service implementation.
 */
internal class DefaultCollectionService(
    private val httpClient: TmdbHttpClient,
) : CollectionService {
    override fun details(collectionId: CollectionId): CollectionDetails =
        details(collectionId, CollectionDetailsQuery.empty())

    override fun details(
        collectionId: CollectionId,
        language: Language,
    ): CollectionDetails = details(collectionId, CollectionDetailsQuery.of(language))

    override fun details(
        collectionId: CollectionId,
        query: CollectionDetailsQuery,
    ): CollectionDetails =
        httpClient.get(
            TmdbRequest.get(
                CollectionPaths.details(collectionId),
                query.toQueryParams(),
            ),
            CollectionDetails::class.java,
        )

    override fun images(collectionId: CollectionId): CollectionImages = images(collectionId, ImageQuery.none())

    override fun images(
        collectionId: CollectionId,
        query: ImageQuery,
    ): CollectionImages =
        httpClient.get(
            TmdbRequest.get(
                CollectionPaths.images(collectionId),
                query.toQueryParams(),
            ),
            CollectionImages::class.java,
        )

    override fun translations(collectionId: CollectionId): CollectionTranslations =
        httpClient.get(
            TmdbRequest.get(CollectionPaths.translations(collectionId)),
            CollectionTranslations::class.java,
        )
}
