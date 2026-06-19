package dev.reuss.tmdb.domain.companies;

import dev.reuss.tmdb.common.image.CompanyImages;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.companies.model.Company;
import dev.reuss.tmdb.domain.companies.model.CompanyAlternativeNames;
import dev.reuss.tmdb.value.id.CompanyId;

import java.util.Objects;

/**
 * Default {@link CompanyService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultCompanyService implements CompanyService {

    private final TmdbHttpClient httpClient;

    public DefaultCompanyService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public Company details(CompanyId companyId) {
        Objects.requireNonNull(companyId, "Company id must not be null");

        return httpClient.get(
                TmdbRequest.get(CompanyPaths.details(companyId)),
                Company.class
        );
    }

    @Override
    public CompanyAlternativeNames alternativeNames(CompanyId companyId) {
        Objects.requireNonNull(companyId, "Company id must not be null");

        return httpClient.get(
                TmdbRequest.get(CompanyPaths.alternativeNames(companyId)),
                CompanyAlternativeNames.class
        );
    }

    @Override
    public CompanyImages images(CompanyId companyId) {
        Objects.requireNonNull(companyId, "Company id must not be null");

        return httpClient.get(
                TmdbRequest.get(CompanyPaths.images(companyId)),
                CompanyImages.class
        );
    }
}