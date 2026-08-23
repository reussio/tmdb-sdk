package dev.reuss.tmdb.domain.find

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.find.model.ExternalSource
import dev.reuss.tmdb.domain.find.model.FindResults
import dev.reuss.tmdb.value.id.ExternalId
import dev.reuss.tmdb.value.language.Language

/**
 * Default [FindService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultFindService(
    private val httpClient: TmdbHttpClient
) : FindService {

    override fun byExternalId(
        externalId: ExternalId,
        externalSource: ExternalSource
    ): FindResults =
        httpClient.get(
            TmdbRequest.get(
                FindPaths.byExternalId(externalId),
                QueryParams.create()
                    .add("external_source", externalSource.value)
            ),
            FindResults::class.java
        )

    override fun byExternalId(
        externalId: ExternalId,
        externalSource: ExternalSource,
        language: Language
    ): FindResults =
        httpClient.get(
            TmdbRequest.get(
                FindPaths.byExternalId(externalId),
                QueryParams.create()
                    .add("external_source", externalSource.value)
                    .add("language", language.value)
            ),
            FindResults::class.java
        )
}