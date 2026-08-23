package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CreditsResponse

/**
 * Movie credits for a TMDB person.
 *
 * @property cast movie cast credits
 * @property crew movie crew credits
 */
@JvmRecord
data class PersonMovieCredits(
    @all:JsonProperty("cast")
    override val cast: List<PersonMovieCastCredit> = emptyList(),
    @all:JsonProperty("crew")
    override val crew: List<PersonMovieCrewCredit> = emptyList(),
) : CreditsResponse<PersonMovieCastCredit, PersonMovieCrewCredit>,
    TmdbModel
