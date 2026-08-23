package dev.reuss.tmdb.domain.tv.series.query

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.query.TmdbQuery
import dev.reuss.tmdb.value.language.Language

/**
 * Query parameters for TV series videos.
 *
 * Both language and included video languages are optional. Included video
 * languages are serialized as a comma-separated `include_video_language`
 * value.
 */
class TvSeriesVideosQuery private constructor() : TmdbQuery {
    private var language: Language? = null
    private var includeVideoLanguage: List<Language>? = null

    /** Sets the response language; `null` leaves the parameter unspecified. */
    fun language(value: Language?) =
        apply {
            language = value
        }

    /** Adds videos in these languages to the response language filter. */
    fun includeVideoLanguage(value: List<Language>?) =
        apply {
            includeVideoLanguage = value?.toList()
        }

    /** Adds videos in the supplied languages to the response language filter. */
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
        /** Creates an empty query that relies on TMDB defaults. */
        @JvmStatic
        fun create(): TvSeriesVideosQuery = TvSeriesVideosQuery()
    }
}
