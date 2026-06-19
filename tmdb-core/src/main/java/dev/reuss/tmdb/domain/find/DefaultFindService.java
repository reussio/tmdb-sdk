package dev.reuss.tmdb.domain.find;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.find.model.ExternalSource;
import dev.reuss.tmdb.domain.find.model.FindResults;
import dev.reuss.tmdb.value.id.ExternalId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default {@link FindService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultFindService implements FindService {

    private final TmdbHttpClient httpClient;

    public DefaultFindService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public FindResults byExternalId(ExternalId externalId, ExternalSource externalSource) {
        Objects.requireNonNull(externalId, "External id must not be null");
        Objects.requireNonNull(externalSource, "External source must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        FindPaths.byExternalId(externalId),
                        QueryParams.create()
                                .add("external_source", externalSource.value())
                ),
                FindResults.class
        );
    }

    @Override
    public FindResults byExternalId(
            ExternalId externalId,
            ExternalSource externalSource,
            Language language
    ) {
        Objects.requireNonNull(externalId, "External id must not be null");
        Objects.requireNonNull(externalSource, "External source must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        FindPaths.byExternalId(externalId),
                        QueryParams.create()
                                .add("external_source", externalSource.value())
                                .add("language", language)
                ),
                FindResults.class
        );
    }
}
