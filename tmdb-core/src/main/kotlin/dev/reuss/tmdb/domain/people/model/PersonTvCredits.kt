package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty

import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.credit.CreditsResponse

/**
 * TV credits for a TMDB person.
 *
 * @property cast TV cast credits
 * @property crew TV crew credits
 */
@JvmRecord
data class PersonTvCredits(
    @all:JsonProperty("cast")
    override val cast: List<PersonTvCastCredit> = emptyList(),

    @all:JsonProperty("crew")
    override val crew: List<PersonTvCrewCredit> = emptyList()
) : CreditsResponse<PersonTvCastCredit, PersonTvCrewCredit>, TmdbModel
