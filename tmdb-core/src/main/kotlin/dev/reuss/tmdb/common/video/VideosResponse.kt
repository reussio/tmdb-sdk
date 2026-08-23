package dev.reuss.tmdb.common.video

/**
 * Common contract for TMDB responses that contain videos.
 *
 * @property <T> video item type
 */

interface VideosResponse<T> {

    val results: List<T>

    fun isEmpty(): Boolean {
        return results.isEmpty()
    }

    fun hasVideos(): Boolean {
        return !isEmpty()
    }

    fun videoCount(): Int {
        return results.size
    }
}
