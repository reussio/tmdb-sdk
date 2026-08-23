package dev.reuss.tmdb.domain.companies

import dev.reuss.tmdb.common.image.CompanyImages
import dev.reuss.tmdb.domain.companies.model.Company
import dev.reuss.tmdb.domain.companies.model.CompanyAlternativeNames
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.CompanyId
import org.junit.jupiter.api.Test

class DefaultCompanyServiceTest {
    private val companyId = CompanyId.of(420)

    @Test
    fun companyMethods_shouldUseExpectedPathsAndResponseTypes() {
        assertRequest<Company>("/company/420") {
            DefaultCompanyService(it).details(companyId)
        }
        assertRequest<CompanyAlternativeNames>("/company/420/alternative_names") {
            DefaultCompanyService(it).alternativeNames(companyId)
        }
        assertRequest<CompanyImages>("/company/420/images") {
            DefaultCompanyService(it).images(companyId)
        }
    }
}
