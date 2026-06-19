package dev.reuss.tmdb.domain.find;


import dev.reuss.tmdb.value.id.ExternalId;

final class FindPaths {

    private static final String FIND = "/find";

    private FindPaths() {
    }

    static String byExternalId(ExternalId externalId) {
        return FIND + "/" + externalId.value();
    }
}
