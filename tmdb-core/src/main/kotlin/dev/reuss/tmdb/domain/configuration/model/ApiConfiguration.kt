package dev.reuss.tmdb.domain.configuration.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB API configuration response.
 *
 * The configuration contains information required to build image URLs,
 * such as base URLs and available image sizes.
 *
 * @property images image configuration
 */
@JvmRecord
data class ApiConfiguration(
    @all:JsonProperty("images")
    val images: Images,
) : TmdbModel {
    /**
     * TMDB image configuration.
     *
     * @property baseUrl base image URL
     * @property secureBaseUrl secure HTTPS image URL
     * @property backdropSizes supported backdrop image sizes
     * @property logoSizes supported logo image sizes
     * @property posterSizes supported poster image sizes
     * @property profileSizes supported profile image sizes
     * @property stillSizes supported still image sizes
     */
    @JvmRecord
    data class Images(
        @all:JsonProperty("base_url")
        val baseUrl: String?,
        @all:JsonProperty("secure_base_url")
        val secureBaseUrl: String?,
        @all:JsonProperty("backdrop_sizes")
        val backdropSizes: List<String> = emptyList(),
        @all:JsonProperty("logo_sizes")
        val logoSizes: List<String> = emptyList(),
        @all:JsonProperty("poster_sizes")
        val posterSizes: List<String> = emptyList(),
        @all:JsonProperty("profile_sizes")
        val profileSizes: List<String> = emptyList(),
        @all:JsonProperty("still_sizes")
        val stillSizes: List<String> = emptyList(),
    ) : TmdbModel
}
