package dev.reuss.tmdb.domain.companies

import dev.reuss.tmdb.common.image.CompanyImages
import dev.reuss.tmdb.domain.companies.model.Company
import dev.reuss.tmdb.domain.companies.model.CompanyAlternativeNames
import dev.reuss.tmdb.value.id.CompanyId

/** Loads TMDB production-company metadata. */
interface CompanyService {
    /** Returns the company identified by [companyId]. */
    fun details(companyId: CompanyId): Company

    /** Returns alternative names recorded for the company. */
    fun alternativeNames(companyId: CompanyId): CompanyAlternativeNames

    /** Returns the company's PNG and SVG logos. */
    fun images(companyId: CompanyId): CompanyImages
}
