package dev.reuss.tmdb.common.keyword

/**
 * Common contract for TMDB responses that contain keywords.
 */

interface KeywordsResponse {
    val keywords: List<Keyword>

    fun isEmpty(): Boolean = keywords.isEmpty()

    fun hasKeywords(): Boolean = !isEmpty()

    fun keywordCount(): Int = keywords.size
}
