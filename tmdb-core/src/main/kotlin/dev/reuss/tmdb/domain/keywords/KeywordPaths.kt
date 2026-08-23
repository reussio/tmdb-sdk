package dev.reuss.tmdb.domain.keywords

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.KeywordId

internal object KeywordPaths {
    fun details(keywordId: KeywordId): String = tmdbPath("keyword", keywordId)
}
