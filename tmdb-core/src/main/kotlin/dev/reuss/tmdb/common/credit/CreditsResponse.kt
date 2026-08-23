package dev.reuss.tmdb.common.credit

/**
 * Common contract for TMDB responses that contain cast and crew credits.
 *
 * @param C cast credit type
 * @param R crew credit type
 */
interface CreditsResponse<C, R> {
    val cast: List<C>

    val crew: List<R>

    fun isEmpty(): Boolean = cast.isEmpty() && crew.isEmpty()

    fun hasCast(): Boolean = cast.isNotEmpty()

    fun hasCrew(): Boolean = crew.isNotEmpty()

    fun hasCredits(): Boolean = !isEmpty()

    fun castCount(): Int = cast.size

    fun crewCount(): Int = crew.size

    fun creditCount(): Int = castCount() + crewCount()
}
