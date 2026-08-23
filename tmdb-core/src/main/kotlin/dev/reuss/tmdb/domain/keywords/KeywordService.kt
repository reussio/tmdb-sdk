package dev.reuss.tmdb.domain.keywords

import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.value.id.KeywordId

/** Loads TMDB keyword metadata. */
interface KeywordService {
    /** Returns the keyword identified by [keywordId]. */
    fun details(keywordId: KeywordId): Keyword
}
