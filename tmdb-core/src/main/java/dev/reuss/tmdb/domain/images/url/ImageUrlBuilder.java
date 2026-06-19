package dev.reuss.tmdb.domain.images.url;

import dev.reuss.tmdb.value.image.size.*;

import java.net.URI;

/**
 * Service for creating TMDB image URLs.
 *
 * <p>TMDB exposes image paths in many API responses. This service combines
 * those paths with the configured TMDB image base URL and a requested size.</p>
 */
public interface ImageUrlBuilder {

    URI poster(String path, PosterSize size);

    URI backdrop(String path, BackdropSize size);

    URI logo(String path, LogoSize size);

    URI profile(String path, ProfileSize size);

    URI still(String path, StillSize size);
}