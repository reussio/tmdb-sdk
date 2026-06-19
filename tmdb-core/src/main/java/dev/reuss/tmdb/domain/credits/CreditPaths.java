package dev.reuss.tmdb.domain.credits;


import dev.reuss.tmdb.value.id.CreditId;

final class CreditPaths {

    private static final String CREDIT = "/credit";

    private CreditPaths() {
    }

    static String details(CreditId creditId) {
        return CREDIT + "/" + creditId.asString();
    }
}