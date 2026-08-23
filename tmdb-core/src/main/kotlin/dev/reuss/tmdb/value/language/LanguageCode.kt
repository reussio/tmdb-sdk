package dev.reuss.tmdb.value.language

import dev.reuss.tmdb.common.TmdbModel
import java.util.Locale

/**
 * Validated ISO 639-1 language code used by TMDB.
 *
 * TMDB uses ISO 639-1 language codes for localization,
 * for example `de`, `en`, `pt`, `fr` or `ja`.
 *
 * Language codes are usually combined with an ISO 3166-1 alpha-2
 * region code when sent to TMDB, for example `de-DE`,
 * `en-US` or `pt-BR`.
 *
 * @property value Normalized lowercase two-letter code.
 *
 * @see Language
 * @see Languages
 */
class LanguageCode private constructor(
    val value: String,
) : TmdbModel {
    override fun toString(): String = value

    override fun equals(other: Any?): Boolean =
        this === other ||
            (other is LanguageCode && value == other.value)

    override fun hashCode(): Int = value.hashCode()

    companion object {
        private val ISO_LANGUAGES: Set<String> = Locale.getISOLanguages().toSet()

        /**
         * Validates and normalizes an ISO 639-1 language code.
         *
         * The value is normalized to lowercase but is not trimmed.
         *
         * @throws IllegalArgumentException if [value] is blank,
         * not a two-letter code or not a known ISO 639-1 language code
         */
        @JvmStatic
        fun of(value: String): LanguageCode {
            require(value.isNotBlank()) {
                "Language code must not be blank"
            }

            val normalized = value.lowercase(Locale.ROOT)

            require(normalized.matches(Regex("^[a-z]{2}$"))) {
                "Language code must be a two-letter ISO 639-1 code"
            }

            require(normalized in ISO_LANGUAGES) {
                "Unknown ISO 639-1 language code: $normalized"
            }

            return LanguageCode(normalized)
        }
    }
}
