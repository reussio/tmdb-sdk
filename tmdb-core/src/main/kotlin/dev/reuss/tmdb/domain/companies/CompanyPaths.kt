package dev.reuss.tmdb.domain.companies

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.CompanyId

internal object CompanyPaths {
    fun details(companyId: CompanyId): String = tmdbPath("company", companyId)

    fun alternativeNames(companyId: CompanyId): String = tmdbPath("company", companyId, "alternative_names")

    fun images(companyId: CompanyId): String = tmdbPath("company", companyId, "images")
}
