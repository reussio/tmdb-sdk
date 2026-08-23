package dev.reuss.tmdb.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for TMDB image requests.
 *
 * Both filters are optional. A blank [includeImageLanguage] value is rejected.
 * Values are serialized as `language` and `include_image_language` query parameters.
 *
 * @property language optional language filter
 * @property includeImageLanguage optional comma-separated image language filter
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
        @JvmStatic
        fun none(): ImageQuery = ImageQuery()

        @JvmStatic
        fun language(language: Language): ImageQuery = ImageQuery(language = language)

        @JvmStatic
        fun includeImageLanguage(includeImageLanguage: String): ImageQuery =
            ImageQuery(includeImageLanguage = includeImageLanguage)
    }
}
