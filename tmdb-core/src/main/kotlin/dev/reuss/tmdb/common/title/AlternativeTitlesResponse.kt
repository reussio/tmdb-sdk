package dev.reuss.tmdb.common.title

/**
 * Common contract for TMDB responses that contain alternative titles.
 */

interface AlternativeTitlesResponse {

    val alternativeTitles: List<AlternativeTitle>

    fun isEmpty(): Boolean {
        return alternativeTitles.isEmpty()
    }

    fun hasAlternativeTitles(): Boolean {
        return !isEmpty()
    }

    fun alternativeTitleCount(): Int {
        return alternativeTitles.size
    }
}
