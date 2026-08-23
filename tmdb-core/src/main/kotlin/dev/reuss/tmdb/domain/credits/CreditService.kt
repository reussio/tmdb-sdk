package dev.reuss.tmdb.domain.credits

import dev.reuss.tmdb.domain.credits.model.CreditDetails
import dev.reuss.tmdb.value.id.CreditId
import dev.reuss.tmdb.value.language.Language

/** Loads one cast or crew credit independently of its associated media item. */
interface CreditService {
    /** Returns the credit identified by [creditId] using the client's default language. */
    fun details(creditId: CreditId): CreditDetails

    /** Returns the credit identified by [creditId], localized in [language]. */
    fun details(
        creditId: CreditId,
        language: Language,
    ): CreditDetails
}
