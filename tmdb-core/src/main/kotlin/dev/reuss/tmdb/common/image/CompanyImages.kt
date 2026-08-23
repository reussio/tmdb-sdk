package dev.reuss.tmdb.common.image

import dev.reuss.tmdb.common.TmdbModel

/**
 * Image metadata for a TMDB company.
 *
 * @property id TMDB company id
 * @property logos company logo images
 */
@JvmRecord
data class CompanyImages(
    val id: Int,
    override val logos: List<LogoImage> = emptyList(),
) : LogoImagesResponse,
    TmdbModel
