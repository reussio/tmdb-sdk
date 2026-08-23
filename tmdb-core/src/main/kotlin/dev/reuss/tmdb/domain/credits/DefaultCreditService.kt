package dev.reuss.tmdb.domain.credits

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.credits.model.CreditDetails
import dev.reuss.tmdb.value.id.CreditId
import dev.reuss.tmdb.value.language.Language

/**
 * Default [CreditService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultCreditService(
    private val httpClient: TmdbHttpClient,
) : CreditService {
    override fun details(creditId: CreditId): CreditDetails =
        httpClient.get(
            TmdbRequest.get(CreditPaths.details(creditId)),
            CreditDetails::class.java,
        )

    override fun details(
        creditId: CreditId,
        language: Language,
    ): CreditDetails =
        httpClient.get(
            TmdbRequest.get(
                CreditPaths.details(creditId),
                QueryParams.create().add("language", language.value),
            ),
            CreditDetails::class.java,
        )
}
