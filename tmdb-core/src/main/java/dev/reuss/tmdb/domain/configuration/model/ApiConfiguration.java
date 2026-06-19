package dev.reuss.tmdb.domain.configuration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

import java.util.List;

/**
 * TMDB API configuration response.
 *
 * <p>The configuration contains information required to build image URLs,
 * such as base URLs and available image sizes.</p>
 *
 * @param images image configuration
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiConfiguration(
        Images images
) implements TmdbModel {

    /**
     * TMDB image configuration.
     *
     * @param baseUrl       base image URL
     * @param secureBaseUrl secure HTTPS image URL
     * @param backdropSizes supported backdrop image sizes
     * @param logoSizes     supported logo image sizes
     * @param posterSizes   supported poster image sizes
     * @param profileSizes  supported profile image sizes
     * @param stillSizes    supported still image sizes
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Images(
            @JsonProperty("base_url")
            String baseUrl,

            @JsonProperty("secure_base_url")
            String secureBaseUrl,

            @JsonProperty("backdrop_sizes")
            List<String> backdropSizes,

            @JsonProperty("logo_sizes")
            List<String> logoSizes,

            @JsonProperty("poster_sizes")
            List<String> posterSizes,

            @JsonProperty("profile_sizes")
            List<String> profileSizes,

            @JsonProperty("still_sizes")
            List<String> stillSizes
    ) implements TmdbModel {
    }
}
