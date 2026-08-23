package dev.reuss.tmdb.common.video

/**
 * Common contract for TMDB responses that contain videos.
 *
 * @property <T> video item type
 */

interface VideosResponse<T> {
    val results: List<T>

    fun isEmpty(): Boolean = results.isEmpty()

    fun hasVideos(): Boolean = !isEmpty()

    fun videoCount(): Int = results.size
}
