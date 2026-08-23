package dev.reuss.tmdb.common.change

/**
 * Common contract for TMDB responses that contain change entries.
 */
interface ChangesResponse {

    val changes: List<Change>

    fun isEmpty(): Boolean =
        changes.isEmpty()

    fun hasChanges(): Boolean =
        changes.isNotEmpty()

    fun changeCount(): Int =
        changes.size
}