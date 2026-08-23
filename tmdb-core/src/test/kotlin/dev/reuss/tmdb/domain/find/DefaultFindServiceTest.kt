package dev.reuss.tmdb.domain.find

import dev.reuss.tmdb.domain.find.model.ExternalSource
import dev.reuss.tmdb.domain.find.model.FindResults
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.ExternalId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultFindServiceTest {
    private val externalId = ExternalId.of("tt0137523")

    @Test
    fun byExternalId_shouldRequireSourceAndSupportLanguageOverload() {
        assertRequest<FindResults>(
            "/find/tt0137523",
            mapOf("external_source" to "imdb_id"),
        ) {
            DefaultFindService(it).byExternalId(externalId, ExternalSource.IMDB)
        }
        assertRequest<FindResults>(
            "/find/tt0137523",
            mapOf("external_source" to "imdb_id", "language" to "de-DE"),
        ) {
            DefaultFindService(it).byExternalId(
                externalId,
                ExternalSource.IMDB,
                Languages.DE_DE,
            )
        }
    }
}
