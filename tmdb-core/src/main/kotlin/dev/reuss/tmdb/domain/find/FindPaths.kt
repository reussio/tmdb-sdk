package dev.reuss.tmdb.domain.find

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.ExternalId

internal object FindPaths {
    fun byExternalId(externalId: ExternalId): String = tmdbPath("find", externalId)
}
