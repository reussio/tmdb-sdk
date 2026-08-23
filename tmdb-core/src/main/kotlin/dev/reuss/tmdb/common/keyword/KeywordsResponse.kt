package dev.reuss.tmdb.common.keyword

/**
 * Common contract for TMDB responses that contain keywords.
 */

interface KeywordsResponse {

    val keywords: List<Keyword>

    fun isEmpty(): Boolean {
        return keywords.isEmpty()
    }

    fun hasKeywords(): Boolean {
        return !isEmpty()
    }

    fun keywordCount(): Int {
        return keywords.size
    }
}
