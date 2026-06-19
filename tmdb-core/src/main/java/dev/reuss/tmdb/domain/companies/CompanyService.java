package dev.reuss.tmdb.domain.companies;

import dev.reuss.tmdb.common.image.CompanyImages;
import dev.reuss.tmdb.domain.companies.model.Company;
import dev.reuss.tmdb.domain.companies.model.CompanyAlternativeNames;
import dev.reuss.tmdb.value.id.CompanyId;

/**
 * Service for loading TMDB company metadata.
 */
public interface CompanyService {

    /**
     * Loads company details by company id.
     *
     * @param companyId the company id
     * @return company details
     */
    Company details(CompanyId companyId);

    /**
     * Loads alternative names for a company.
     *
     * @param companyId the company id
     * @return alternative company names
     */
    CompanyAlternativeNames alternativeNames(CompanyId companyId);

    CompanyImages images(CompanyId companyId);

}
