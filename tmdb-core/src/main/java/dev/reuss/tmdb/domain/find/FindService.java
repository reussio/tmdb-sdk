package dev.reuss.tmdb.domain.find;

import dev.reuss.tmdb.domain.find.model.ExternalSource;
import dev.reuss.tmdb.domain.find.model.FindResults;
import dev.reuss.tmdb.value.id.ExternalId;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for finding TMDB objects by external identifiers.
 */
public interface FindService {

    /**
     * Finds TMDB objects by external id.
     *
     * @param externalId     the external id
     * @param externalSource the external id source
     * @return matching TMDB objects grouped by result type
     */
    FindResults byExternalId(ExternalId externalId, ExternalSource externalSource);

    /**
     * Finds TMDB objects by external id using a specific language.
     *
     * @param externalId     the external id
     * @param externalSource the external id source
     * @param language       the response language
     * @return matching TMDB objects grouped by result type
     */
    FindResults byExternalId(
            ExternalId externalId,
            ExternalSource externalSource,
            Language language
    );
}