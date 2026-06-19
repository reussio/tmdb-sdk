package dev.reuss.tmdb.domain.credits;

import dev.reuss.tmdb.domain.credits.model.CreditDetails;
import dev.reuss.tmdb.value.id.CreditId;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for loading TMDB credit metadata.
 */
public interface CreditService {

    /**
     * Loads credit details by credit id.
     *
     * @param creditId the credit id
     * @return credit details
     */
    CreditDetails details(CreditId creditId);

    /**
     * Loads credit details by credit id using a specific language.
     *
     * @param creditId the credit id
     * @param language the response language
     * @return credit details
     */
    CreditDetails details(CreditId creditId, Language language);
}
