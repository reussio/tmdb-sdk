package dev.reuss.tmdb.common.title

/**
 * Common contract for TMDB responses that contain alternative titles.
 */

interface AlternativeTitlesResponse {
    val alternativeTitles: List<AlternativeTitle>

    fun isEmpty(): Boolean = alternativeTitles.isEmpty()

    fun hasAlternativeTitles(): Boolean = !isEmpty()

    fun alternativeTitleCount(): Int = alternativeTitles.size
}
