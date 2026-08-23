package dev.reuss.tmdb.domain.find

import dev.reuss.tmdb.domain.find.model.ExternalSource
import dev.reuss.tmdb.domain.find.model.FindResults
import dev.reuss.tmdb.value.id.ExternalId
import dev.reuss.tmdb.value.language.Language

/**
 * Resolves identifiers from supported external databases to TMDB resources.
 *
 * Results are separated into movie, person, TV series, TV season, and TV episode groups; groups
 * that do not apply to the selected [ExternalSource] are empty.
 */
interface FindService {
    /** Resolves [externalId] from [externalSource] using the client's default language. */
    fun byExternalId(
        externalId: ExternalId,
        externalSource: ExternalSource,
    ): FindResults

    /** Resolves [externalId] from [externalSource], localizing results in [language]. */
    fun byExternalId(
        externalId: ExternalId,
        externalSource: ExternalSource,
        language: Language,
    ): FindResults
}
