package dev.reuss.tmdb.domain.companies;


import dev.reuss.tmdb.value.id.CompanyId;

final class CompanyPaths {

    private static final String COMPANY = "/company";

    private CompanyPaths() {
    }

    static String details(CompanyId companyId) {
        return COMPANY + "/" + companyId.asString();
    }

    static String alternativeNames(CompanyId companyId) {
        return details(companyId) + "/alternative_names";
    }

    static String images(CompanyId companyId) {
        return details(companyId) + "/images";
    }
}
