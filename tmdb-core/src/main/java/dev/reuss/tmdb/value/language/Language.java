package dev.reuss.tmdb.value.language;

import dev.reuss.tmdb.common.TmdbModel;

import dev.reuss.tmdb.value.region.Region;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents a TMDB language parameter.
 *
 * <p>TMDB language parameters are based on ISO 639-1 language codes
 * and are usually combined with ISO 3166-1 alpha-2 region codes.</p>
 *
 * <p>Examples:</p>
 * <ul>
 *     <li>{@code de}</li>
 *     <li>{@code en}</li>
 *     <li>{@code de-DE}</li>
 *     <li>{@code en-US}</li>
 *     <li>{@code pt-BR}</li>
 * </ul>
 *
 * <p>The language code controls translated metadata where TMDB supports
 * localization. Person names and character names may not always be
 * localized by TMDB.</p>
 *
 * @param code   the ISO 639-1 language code
 * @param region the optional ISO 3166-1 alpha-2 region
 * @see LanguageCode
 * @see Region
 * @see <a href="https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes">ISO 639-1</a>
 * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
 * @see <a href="https://developer.themoviedb.org/docs/languages">TMDB Languages</a>
 */
public record Language(
        LanguageCode code,
        Region region
) implements TmdbModel {

    /**
     * Creates a new language parameter.
     *
     * @throws NullPointerException if {@code code} is {@code null}
     */
    public Language {
        Objects.requireNonNull(code, "Language code must not be null");
    }

    /**
     * Creates a language parameter from a language code or language tag.
     *
     * <p>Accepted formats are ISO 639-1 language codes such as {@code de}
     * or {@code en}, and language-region tags such as {@code de-DE},
     * {@code en-US} or {@code pt-BR}.</p>
     *
     * @param value the language code or language tag
     * @return a new language parameter
     * @throws IllegalArgumentException if {@code value} is {@code null}, blank,
     *                                  empty or does not match a supported format
     */
    public static Language of(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Language must not be blank");
        }

        String normalized = value.trim();

        if (normalized.matches("^[a-zA-Z]{2}$")) {
            return new Language(LanguageCode.of(normalized), null);
        }

        if (normalized.matches("^[a-zA-Z]{2}-[a-zA-Z]{2}$")) {
            String[] parts = normalized.split("-");
            return new Language(
                    LanguageCode.of(parts[0].toLowerCase(Locale.ROOT)),
                    Region.of(parts[1].toUpperCase(Locale.ROOT))
            );
        }

        throw new IllegalArgumentException("Language must match format like de, en, de-DE or en-US");
    }

    /**
     * Creates a language parameter without a region.
     *
     * @param code the ISO 639-1 language code
     * @return a new language parameter
     * @throws NullPointerException if {@code code} is {@code null}
     */
    public static Language of(LanguageCode code) {
        return new Language(code, null);
    }

    /**
     * Creates a language parameter with a region.
     *
     * @param code   the ISO 639-1 language code
     * @param region the ISO 3166-1 alpha-2 region
     * @return a new language parameter
     * @throws NullPointerException if {@code code} is {@code null}
     */
    public static Language of(LanguageCode code, Region region) {
        return new Language(code, region);
    }

    /**
     * Returns the optional region part of this language parameter.
     *
     * @return the region as an {@link Optional}
     */
    public Optional<Region> regionOptional() {
        return Optional.ofNullable(region);
    }

    /**
     * Returns the TMDB language parameter value.
     *
     * <p>If no region is present, only the language code is returned,
     * for example {@code de}. If a region is present, the value is returned
     * as a language-region tag, for example {@code de-DE}.</p>
     *
     * @return the TMDB language parameter value
     */
    public String value() {
        if (region == null) {
            return code.value();
        }

        return code.value() + "-" + region.value();
    }

    /**
     * Returns the TMDB language parameter value.
     *
     * @return the TMDB language parameter value
     */
    @Override
    public String toString() {
        return value();
    }
}
