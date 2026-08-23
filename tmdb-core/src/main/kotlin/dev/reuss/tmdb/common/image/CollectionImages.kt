package dev.reuss.tmdb.common.image

/**
 * Images for a TMDB collection.
 *
 * @property id collection id
 * @property backdrops backdrop images
 * @property posters poster images
 */
@JvmRecord
data class CollectionImages(
    val id: Int,
    val backdrops: List<TmdbImage> = emptyList(),
    val posters: List<TmdbImage> = emptyList(),
) {
    fun isEmpty(): Boolean = backdrops.isEmpty() && posters.isEmpty()

    fun hasImages(): Boolean = !isEmpty()

    fun hasBackdrops(): Boolean = backdrops.isNotEmpty()

    fun hasPosters(): Boolean = posters.isNotEmpty()

    fun backdropCount(): Int = backdrops.size

    fun posterCount(): Int = posters.size

    fun imageCount(): Int = backdrops.size + posters.size
}
