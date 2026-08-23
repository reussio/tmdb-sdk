package dev.reuss.tmdb.domain.keywords

import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.value.id.KeywordId

/**
 * Service for loading TMDB keyword metadata.
 */

interface KeywordService {
    fun details(keywordId: KeywordId): Keyword
}
