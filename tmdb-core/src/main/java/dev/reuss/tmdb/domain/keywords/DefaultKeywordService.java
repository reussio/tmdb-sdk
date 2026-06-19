package dev.reuss.tmdb.domain.keywords;

import dev.reuss.tmdb.common.keyword.Keyword;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.value.id.KeywordId;

import java.util.Objects;

/**
 * Default {@link KeywordService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultKeywordService implements KeywordService {

    private final TmdbHttpClient httpClient;

    public DefaultKeywordService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public Keyword details(KeywordId keywordId) {
        Objects.requireNonNull(keywordId, "Keyword id must not be null");

        return httpClient.get(
                TmdbRequest.get(KeywordPaths.details(keywordId)),
                Keyword.class
        );
    }
}
