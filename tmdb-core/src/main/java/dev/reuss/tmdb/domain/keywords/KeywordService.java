package dev.reuss.tmdb.domain.keywords;

import dev.reuss.tmdb.common.keyword.Keyword;
import dev.reuss.tmdb.value.id.KeywordId;

/**
 * Service for loading TMDB keyword metadata.
 */
public interface KeywordService {

    /**
     * Loads keyword details by keyword id.
     *
     * @param keywordId the keyword id
     * @return keyword details
     */
    Keyword details(KeywordId keywordId);
}
