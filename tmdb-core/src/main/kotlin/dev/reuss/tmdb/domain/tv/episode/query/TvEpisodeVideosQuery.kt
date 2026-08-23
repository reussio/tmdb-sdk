package dev.reuss.tmdb.domain.tv.episode.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.TmdbQuery
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for TV episode videos.
 *
 * Both language and included video languages are optional. Included video
 * languages are serialized as a comma-separated `include_video_language`
 * value.
 */
class TvEpisodeVideosQuery private constructor() : TmdbQuery {
    private var language: Language? = null
    private var includeVideoLanguage: List<Language>? = null

    fun language(value: Language?) =
        apply {
            language = value
        }

    fun includeVideoLanguage(value: List<Language>?) =
        apply {
            includeVideoLanguage = value?.toList()
        }

    fun includeVideoLanguage(vararg value: Language) =
        apply {
            includeVideoLanguage = value.toList()
        }

    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("language", language?.value)
            .add("include_video_language", includeVideoLanguageValue())

    private fun includeVideoLanguageValue(): String? =
        includeVideoLanguage
            ?.takeIf { it.isNotEmpty() }
            ?.joinToString(",") { it.value }

    companion object {
        @JvmStatic
        fun create(): TvEpisodeVideosQuery = TvEpisodeVideosQuery()
    }
}
