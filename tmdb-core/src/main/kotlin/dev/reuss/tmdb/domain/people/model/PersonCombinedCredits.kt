package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CreditsResponse

/**
 * Combined movie and TV credits for a TMDB person.
 *
 * @property cast cast credits
 * @property crew crew credits
 */
@JvmRecord
data class PersonCombinedCredits(
    @all:JsonProperty("cast")
    override val cast: List<PersonCombinedCastCredit> = emptyList(),

    @all:JsonProperty("crew")
    override val crew: List<PersonCombinedCrewCredit> = emptyList()
) : CreditsResponse<PersonCombinedCastCredit, PersonCombinedCrewCredit>, TmdbModel
