package dev.reuss.tmdb.domain.images.url

import dev.reuss.tmdb.domain.configuration.ConfigurationService
import dev.reuss.tmdb.value.image.size.BackdropSize
import dev.reuss.tmdb.value.image.size.ImageSize
import dev.reuss.tmdb.value.image.size.LogoSize
import dev.reuss.tmdb.value.image.size.PosterSize
import dev.reuss.tmdb.value.image.size.ProfileSize
import dev.reuss.tmdb.value.image.size.StillSize
import java.net.URI

/**
 * Default image URL builder implementation.
 */
internal class DefaultImageUrlBuilder(
    private val configurationService: ConfigurationService,
) : ImageUrlBuilder {
    private val configuration by lazy {
        configurationService.apiConfiguration()
    }

    override fun poster(
        path: String,
        size: PosterSize,
    ): URI = imageUrl(path, size)

    override fun backdrop(
        path: String,
        size: BackdropSize,
    ): URI = imageUrl(path, size)

    override fun logo(
        path: String,
        size: LogoSize,
    ): URI = imageUrl(path, size)

    override fun profile(
        path: String,
        size: ProfileSize,
    ): URI = imageUrl(path, size)

    override fun still(
        path: String,
        size: StillSize,
    ): URI = imageUrl(path, size)

    private fun imageUrl(
        path: String,
        size: ImageSize,
    ): URI {
        require(path.isNotBlank()) {
            "Image path must not be blank"
        }

        val normalizedPath =
            if (path.startsWith('/')) path else "/$path"

        val secureBaseUrl =
            checkNotNull(
                configuration.images.secureBaseUrl?.takeIf { it.isNotBlank() },
            ) {
                "TMDB secure image base URL is missing"
            }

        return URI.create(
            secureBaseUrl.trimEnd('/') +
                "/" +
                size.value +
                normalizedPath,
        )
    }
}
