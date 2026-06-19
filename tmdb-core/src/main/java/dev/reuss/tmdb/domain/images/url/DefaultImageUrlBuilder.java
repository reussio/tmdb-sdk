package dev.reuss.tmdb.domain.images.url;

import dev.reuss.tmdb.domain.configuration.ConfigurationService;
import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration;
import dev.reuss.tmdb.value.image.size.*;

import java.net.URI;
import java.util.Objects;

/**
 * Default image service implementation.
 */
public final class DefaultImageUrlBuilder implements ImageUrlBuilder {

    private final ConfigurationService configurationService;

    private ApiConfiguration cachedConfiguration;

    public DefaultImageUrlBuilder(ConfigurationService configurationService) {
        this.configurationService = Objects.requireNonNull(
                configurationService,
                "Configuration service must not be null"
        );
    }

    @Override
    public URI poster(String path, PosterSize size) {
        Objects.requireNonNull(size, "Poster size must not be null");
        return imageUrl(path, size);
    }

    @Override
    public URI backdrop(String path, BackdropSize size) {
        Objects.requireNonNull(size, "Backdrop size must not be null");
        return imageUrl(path, size);
    }

    @Override
    public URI logo(String path, LogoSize size) {
        Objects.requireNonNull(size, "Logo size must not be null");
        return imageUrl(path, size);
    }

    @Override
    public URI profile(String path, ProfileSize size) {
        Objects.requireNonNull(size, "Profile size must not be null");
        return imageUrl(path, size);
    }

    @Override
    public URI still(String path, StillSize size) {
        Objects.requireNonNull(size, "Still size must not be null");
        return imageUrl(path, size);
    }

    private URI imageUrl(String path, ImageSize size) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Image path must not be blank");
        }

        String normalizedPath = path.startsWith("/") ? path : "/" + path;

        String secureBaseUrl = configuration()
                .images()
                .secureBaseUrl();

        return URI.create(secureBaseUrl + size.value() + normalizedPath);
    }

    private ApiConfiguration configuration() {
        if (cachedConfiguration == null) {
            cachedConfiguration = configurationService.apiConfiguration();
        }

        return cachedConfiguration;
    }
}