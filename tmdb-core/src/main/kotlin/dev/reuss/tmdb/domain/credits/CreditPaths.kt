package dev.reuss.tmdb.domain.credits

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.CreditId

internal object CreditPaths {

    fun details(creditId: CreditId): String =
        tmdbPath("credit", creditId)
}