package dev.reuss.tmdb.domain.collection

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.CollectionId

internal object CollectionPaths {
    fun details(collectionId: CollectionId): String = tmdbPath("collection", collectionId)

    fun images(collectionId: CollectionId): String = tmdbPath("collection", collectionId, "images")

    fun translations(collectionId: CollectionId): String = tmdbPath("collection", collectionId, "translations")
}
