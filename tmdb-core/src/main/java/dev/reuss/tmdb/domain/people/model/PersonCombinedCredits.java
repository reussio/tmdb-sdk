package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Combined movie and TV credits for a TMDB person.
 *
 * @param cast cast credits
 * @param crew crew credits
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonCombinedCredits(
        List<PersonCombinedCastCredit> cast,
        List<PersonCombinedCrewCredit> crew
) implements CreditsResponse<PersonCombinedCastCredit, PersonCombinedCrewCredit>, TmdbModel {

    public PersonCombinedCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}
