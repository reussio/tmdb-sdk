package dev.reuss.tmdb.value.region;

import dev.reuss.tmdb.common.TmdbModel;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a TMDB region parameter.
 *
 * <p>TMDB expects regions as ISO 3166-1 alpha-2 country codes,
 * for example {@code DE}, {@code US}, {@code GB} or {@code BR}.</p>
 *
 * <p>The region parameter is used by TMDB as a regional filter or
 * presentation hint, for example for release dates, watch providers
 * and discover/search requests.</p>
 *
 * @param value the ISO 3166-1 alpha-2 region code
 * @see Regions
 * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
 * @see <a href="https://developer.themoviedb.org/docs/region-support">TMDB Regions</a>
 */
public record Region(String value) implements TmdbModel {

    private static final Set<String> ISO_COUNTRIES = Arrays.stream(Locale.getISOCountries())
            .collect(Collectors.toUnmodifiableSet());

    /**
     * Creates a new region.
     *
     * <p>The value is normalized to uppercase.</p>
     *
     * @throws IllegalArgumentException if {@code value} is {@code null}, blank,
     *                                  empty, not a two-letter code or not known
     *                                  as an ISO 3166-1 alpha-2 country code
     */
    public Region {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Region must not be blank");
        }

        value = value.toUpperCase(Locale.ROOT);

        if (!value.matches("^[A-Z]{2}$")) {
            throw new IllegalArgumentException("Region must be a two-letter ISO 3166-1 alpha-2 code");
        }

        if (!ISO_COUNTRIES.contains(value)) {
            throw new IllegalArgumentException("Unknown ISO 3166-1 alpha-2 region: " + value);
        }
    }

    /**
     * Creates a region from a string value.
     *
     * @param value the ISO 3166-1 alpha-2 region code
     * @return a new region
     * @throws IllegalArgumentException if {@code value} is invalid
     */
    public static Region of(String value) {
        return new Region(value);
    }

    /**
     * Returns the normalized ISO 3166-1 alpha-2 region code.
     *
     * @return the normalized region code
     */
    @Override
    public String toString() {
        return value;
    }
}