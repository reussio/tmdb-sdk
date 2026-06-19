package dev.reuss.tmdb.domain.credits;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.credits.model.CreditDetails;
import dev.reuss.tmdb.value.id.CreditId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default {@link CreditService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultCreditService implements CreditService {

    private final TmdbHttpClient httpClient;

    public DefaultCreditService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public CreditDetails details(CreditId creditId) {
        Objects.requireNonNull(creditId, "Credit id must not be null");

        return httpClient.get(
                TmdbRequest.get(CreditPaths.details(creditId)),
                CreditDetails.class
        );
    }

    @Override
    public CreditDetails details(CreditId creditId, Language language) {
        Objects.requireNonNull(creditId, "Credit id must not be null");
        Objects.requireNonNull(language, "Language must not be null");

        return httpClient.get(
                TmdbRequest.get(
                        CreditPaths.details(creditId),
                        QueryParams.create().add("language", language)
                ),
                CreditDetails.class
        );
    }
}
