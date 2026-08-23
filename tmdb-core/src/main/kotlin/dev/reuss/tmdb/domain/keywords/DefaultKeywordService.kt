package dev.reuss.tmdb.domain.keywords

import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.value.id.KeywordId

/**
 * Default [KeywordService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultKeywordService(
    private val httpClient: TmdbHttpClient,
) : KeywordService {
    override fun details(keywordId: KeywordId): Keyword =
        httpClient.get(
            TmdbRequest.get(KeywordPaths.details(keywordId)),
            Keyword::class.java,
        )
}
