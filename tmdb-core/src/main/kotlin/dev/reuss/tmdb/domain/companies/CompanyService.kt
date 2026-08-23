package dev.reuss.tmdb.domain.companies

import dev.reuss.tmdb.common.image.CompanyImages
import dev.reuss.tmdb.domain.companies.model.Company
import dev.reuss.tmdb.domain.companies.model.CompanyAlternativeNames
import dev.reuss.tmdb.value.id.CompanyId

/**
 * Service for loading TMDB company metadata.
 */

interface CompanyService {
    fun details(companyId: CompanyId): Company

    fun alternativeNames(companyId: CompanyId): CompanyAlternativeNames

    fun images(companyId: CompanyId): CompanyImages
}
