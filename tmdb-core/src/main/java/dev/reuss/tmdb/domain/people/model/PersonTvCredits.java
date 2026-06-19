package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * TV credits for a TMDB person.
 *
 * @param cast TV cast credits
 * @param crew TV crew credits
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonTvCredits(
        List<PersonTvCastCredit> cast,
        List<PersonTvCrewCredit> crew
) implements CreditsResponse<PersonTvCastCredit, PersonTvCrewCredit>, TmdbModel {

    public PersonTvCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}