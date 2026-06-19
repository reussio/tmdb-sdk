package dev.reuss.tmdb.domain.people.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.common.credit.CreditsResponse;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Movie credits for a TMDB person.
 *
 * @param cast movie cast credits
 * @param crew movie crew credits
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonMovieCredits(
        List<PersonMovieCastCredit> cast,
        List<PersonMovieCrewCredit> crew
) implements CreditsResponse<PersonMovieCastCredit, PersonMovieCrewCredit>, TmdbModel {

    public PersonMovieCredits {
        cast = TmdbCollections.list(cast);
        crew = TmdbCollections.list(crew);
    }
}