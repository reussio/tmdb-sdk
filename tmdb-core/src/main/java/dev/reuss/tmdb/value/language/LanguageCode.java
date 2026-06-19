package dev.reuss.tmdb.value.language;

import dev.reuss.tmdb.common.TmdbModel;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents an ISO 639-1 language code.
 *
 * <p>TMDB uses ISO 639-1 language codes for localization,
 * for example {@code de}, {@code en}, {@code pt}, {@code fr}
 * or {@code ja}.</p>
 *
 * <p>Language codes are usually combined with an ISO 3166-1 alpha-2
 * region code when sent to TMDB, for example {@code de-DE},
 * {@code en-US} or {@code pt-BR}.</p>
 *
 * @param value the two-letter ISO 639-1 language code
 * @see Language
 * @see Languages
 * @see <a href="https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes">ISO 639-1</a>
 * @see <a href="https://developer.themoviedb.org/docs/languages">TMDB Languages</a>
 */
public record LanguageCode(String value) implements TmdbModel {

    private static final Set<String> ISO_LANGUAGES = Arrays.stream(Locale.getISOLanguages())
            .collect(Collectors.toUnmodifiableSet());

    /**
     * Creates a new ISO 639-1 language code.
     *
     * <p>The value is normalized to lowercase.</p>
     *
     * @throws IllegalArgumentException if {@code value} is {@code null}, blank,
     *                                  empty, not a two-letter code or not known
     *                                  as an ISO 639-1 language code
     */
    public LanguageCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Language code must not be blank");
        }

        value = value.toLowerCase(Locale.ROOT);

        if (!value.matches("^[a-z]{2}$")) {
            throw new IllegalArgumentException("Language code must be a two-letter ISO 639-1 code");
        }

        if (!ISO_LANGUAGES.contains(value)) {
            throw new IllegalArgumentException("Unknown ISO 639-1 language code: " + value);
        }
    }

    /**
     * Creates a language code from a string value.
     *
     * @param value the ISO 639-1 language code
     * @return a new language code
     * @throws IllegalArgumentException if {@code value} is invalid
     */
    public static LanguageCode of(String value) {
        return new LanguageCode(value);
    }

    /**
     * Returns the normalized ISO 639-1 language code.
     *
     * @return the normalized language code
     */
    @Override
    public String toString() {
        return value;
    }
}