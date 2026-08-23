package dev.reuss.tmdb.domain.companies

import dev.reuss.tmdb.common.image.CompanyImages
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.companies.model.Company
import dev.reuss.tmdb.domain.companies.model.CompanyAlternativeNames
import dev.reuss.tmdb.value.id.CompanyId

/**
 * Default [CompanyService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultCompanyService(
    private val httpClient: TmdbHttpClient,
) : CompanyService {
    override fun details(companyId: CompanyId): Company =
        httpClient.get(
            TmdbRequest.get(CompanyPaths.details(companyId)),
            Company::class.java,
        )

    override fun alternativeNames(companyId: CompanyId): CompanyAlternativeNames =
        httpClient.get(
            TmdbRequest.get(CompanyPaths.alternativeNames(companyId)),
            CompanyAlternativeNames::class.java,
        )

    override fun images(companyId: CompanyId): CompanyImages =
        httpClient.get(
            TmdbRequest.get(CompanyPaths.images(companyId)),
            CompanyImages::class.java,
        )
}
