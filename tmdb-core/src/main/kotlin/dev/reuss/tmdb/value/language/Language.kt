package dev.reuss.tmdb.value.language

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.region.Region
import java.util.Locale
import java.util.Optional

/**
 * Language tag accepted by localized TMDB endpoints.
 *
 * TMDB language parameters are based on ISO 639-1 language codes
 * and are usually combined with ISO 3166-1 alpha-2 region codes.
 *
 * Examples:
 * - `de`
 * - `en`
 * - `de-DE`
 * - `en-US`
 * - `pt-BR`
 *
 * The language code controls translated metadata where TMDB supports
 * localization. Person names and character names may not always be
 * localized by TMDB.
 *
 * @property code Normalized lowercase ISO 639-1 language code.
 * @property region Optional uppercase ISO 3166-1 region component.
 *
 * @see LanguageCode
 * @see Region
 */
class Language private constructor(
    val code: LanguageCode,
    val region: Region?,
) : TmdbModel {
    /**
     * TMDB query value in `language` or `language-REGION` form.
     *
     * If no region is present, only the language code is returned,
     * for example `de`. If a region is present, the value is returned
     * as a language-region tag, for example `de-DE`.
     */
    val value: String
        get() =
            if (region == null) {
                code.value
            } else {
                "${code.value}-${region.value}"
            }

    /** Exposes the region component as [Optional] for Java callers. */
    fun regionOptional(): Optional<Region> = Optional.ofNullable(region)

    override fun toString(): String = value

    override fun equals(other: Any?): Boolean =
        this === other ||
            (
                other is Language &&
                    code == other.code &&
                    region == other.region
            )

    override fun hashCode(): Int = 31 * code.hashCode() + (region?.hashCode() ?: 0)

    companion object {
        /**
         * Parses a language code or language-region tag.
         *
         * Accepted formats are ISO 639-1 language codes such as `de`
         * or `en`, and language-region tags such as `de-DE`,
         * `en-US` or `pt-BR`.
         *
         * Input is trimmed, the language component is lowercased, and the region
         * component is uppercased.
         *
         * @throws IllegalArgumentException if [value] is blank, malformed, or
         * contains an unknown ISO language or country code
         */
        @JvmStatic
        fun of(value: String): Language {
            require(value.isNotBlank()) {
                "Language must not be blank"
            }

            val normalized = value.trim()

            if (normalized.matches(Regex("^[a-zA-Z]{2}$"))) {
                return Language(
                    LanguageCode.of(normalized),
                    null,
                )
            }

            if (normalized.matches(Regex("^[a-zA-Z]{2}-[a-zA-Z]{2}$"))) {
                val (code, region) = normalized.split("-")

                return Language(
                    LanguageCode.of(code.lowercase(Locale.ROOT)),
                    Region.of(region.uppercase(Locale.ROOT)),
                )
            }

            throw IllegalArgumentException(
                "Language must match format like de, en, de-DE or en-US",
            )
        }

        /**
         * Creates a language value without a region component.
         */
        @JvmStatic
        fun of(code: LanguageCode): Language = Language(code, null)

        /**
         * Creates a language value with an explicit region component.
         */
        @JvmStatic
        fun of(
            code: LanguageCode,
            region: Region,
        ): Language = Language(code, region)
    }
}
