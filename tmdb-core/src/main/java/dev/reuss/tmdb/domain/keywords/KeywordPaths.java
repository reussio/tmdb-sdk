package dev.reuss.tmdb.domain.keywords;

import dev.reuss.tmdb.value.id.KeywordId;

final class KeywordPaths {

    private static final String KEYWORD = "/keyword";

    private KeywordPaths() {
    }

    static String details(KeywordId keywordId) {
        return KEYWORD + "/" + keywordId.asString();
    }
}
