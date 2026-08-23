package dev.reuss.tmdb.domain.collection

import dev.reuss.tmdb.common.image.CollectionImages
import dev.reuss.tmdb.domain.collection.model.CollectionDetails
import dev.reuss.tmdb.domain.collection.model.CollectionTranslations
import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery
import dev.reuss.tmdb.query.ImageQuery
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.CollectionId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultCollectionServiceTest {
    private val collectionId = CollectionId.of(10)

    @Test
    fun details_shouldSupportDefaultLanguageAndQueryOverloads() {
        assertRequest<CollectionDetails>("/collection/10") {
            DefaultCollectionService(it).details(collectionId)
        }
        assertRequest<CollectionDetails>("/collection/10", mapOf("language" to "de-DE")) {
            DefaultCollectionService(it).details(collectionId, Languages.DE_DE)
        }
        assertRequest<CollectionDetails>("/collection/10", mapOf("language" to "en-US")) {
            DefaultCollectionService(it).details(
                collectionId,
                CollectionDetailsQuery.of(Languages.EN_US),
            )
        }
    }

    @Test
    fun images_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<CollectionImages>("/collection/10/images") {
            DefaultCollectionService(it).images(collectionId)
        }
        assertRequest<CollectionImages>(
            "/collection/10/images",
            mapOf("include_image_language" to "de,null"),
        ) {
            DefaultCollectionService(it).images(
                collectionId,
                ImageQuery.includeImageLanguage("de,null"),
            )
        }
    }

    @Test
    fun translations_shouldUseCollectionTranslationsContract() {
        assertRequest<CollectionTranslations>("/collection/10/translations") {
            DefaultCollectionService(it).translations(collectionId)
        }
    }
}
