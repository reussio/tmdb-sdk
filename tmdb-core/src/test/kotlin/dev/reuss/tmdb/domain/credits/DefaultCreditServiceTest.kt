package dev.reuss.tmdb.domain.credits

import dev.reuss.tmdb.domain.credits.model.CreditDetails
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.CreditId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Test

class DefaultCreditServiceTest {
    private val creditId = CreditId.of("credit-1")

    @Test
    fun details_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<CreditDetails>("/credit/credit-1") {
            DefaultCreditService(it).details(creditId)
        }
        assertRequest<CreditDetails>("/credit/credit-1", mapOf("language" to "de-DE")) {
            DefaultCreditService(it).details(creditId, Languages.DE_DE)
        }
    }
}
