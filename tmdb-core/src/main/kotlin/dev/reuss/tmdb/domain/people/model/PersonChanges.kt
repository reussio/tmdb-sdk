package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.change.Change
import dev.reuss.tmdb.common.change.ChangesResponse

/**
 * Recent TMDB changes for a person.
 *
 * @property changes changed person fields
 */
@JvmRecord
data class PersonChanges(
    @all:JsonProperty("changes")
    override val changes: List<Change> = emptyList(),
) : ChangesResponse,
    TmdbModel
