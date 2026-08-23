package dev.reuss.tmdb.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for TMDB image requests.
 *
 * `language` filters returned images. `include_image_language` can add a
 * comma-separated set of language values, including `null` for images without
 * a language. A blank include value is rejected.
 *
 * @property language Language used to filter image metadata.
 * @property includeImageLanguage Additional comma-separated image languages.
 */
data class ImageQuery(
    val language: Language? = null,
    val includeImageLanguage: String? = null,
) : TmdbQuery {
    init {
        require(includeImageLanguage == null || includeImageLanguage.isNotBlank()) {
            "Include image language must not be blank"
        }
    }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("language", language)
            .add("include_image_language", includeImageLanguage)

    companion object {
        /** Creates an image query without endpoint-specific filters. */
        @JvmStatic
        fun none(): ImageQuery = ImageQuery()

        /** Creates an image query filtering by [language]. */
        @JvmStatic
        fun language(language: Language): ImageQuery = ImageQuery(language = language)

        /**
         * Creates an image query with additional image languages.
         *
         * @throws IllegalArgumentException if [includeImageLanguage] is blank
         */
        @JvmStatic
        fun includeImageLanguage(includeImageLanguage: String): ImageQuery =
            ImageQuery(includeImageLanguage = includeImageLanguage)
    }
}
