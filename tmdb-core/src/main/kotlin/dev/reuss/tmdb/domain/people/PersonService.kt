package dev.reuss.tmdb.domain.people

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages
import dev.reuss.tmdb.domain.people.model.PersonChanges
import dev.reuss.tmdb.domain.people.model.PersonCombinedCredits
import dev.reuss.tmdb.domain.people.model.PersonDetails
import dev.reuss.tmdb.domain.people.model.PersonMovieCredits
import dev.reuss.tmdb.domain.people.model.PersonTranslations
import dev.reuss.tmdb.domain.people.model.PersonTvCredits
import dev.reuss.tmdb.domain.people.model.PopularPeopleResponse
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.value.id.PersonId
import dev.reuss.tmdb.value.language.Language

/** Loads people, their credits, and related metadata from TMDB. */
interface PersonService {
    /**
     * Loads top level person details.
     */
    fun details(personId: PersonId): PersonDetails

    /**
     * Loads top level person details using a specific language.
     */
    fun details(
        personId: PersonId,
        language: Language,
    ): PersonDetails

    /** Returns person details with the requested sub-resources appended. */
    fun details(
        personId: PersonId,
        appendToResponse: AppendToResponse<PersonAppend>,
    ): PersonDetails

    /** Returns localized person details with the requested sub-resources appended. */
    fun details(
        personId: PersonId,
        language: Language,
        appendToResponse: AppendToResponse<PersonAppend>,
    ): PersonDetails

    /** Returns all tracked changes from the preceding 24 hours. */
    fun changes(personId: PersonId): PersonChanges

    /**
     * Loads recent changes for a person using query parameters.
     */
    fun changes(
        personId: PersonId,
        query: ChangesQuery,
    ): PersonChanges

    /**
     * Loads combined movie and TV credits for a person.
     */
    fun combinedCredits(personId: PersonId): PersonCombinedCredits

    /**
     * Loads combined movie and TV credits for a person using a specific language.
     */
    fun combinedCredits(
        personId: PersonId,
        language: Language,
    ): PersonCombinedCredits

    /**
     * Loads external IDs for a person.
     */
    fun externalIds(personId: PersonId): ExternalIds

    /** Returns the most recently created person record; this live result can change continuously. */
    fun latest(): PersonDetails

    /**
     * Loads movie credits for a person.
     */
    fun movieCredits(personId: PersonId): PersonMovieCredits

    /**
     * Loads movie credits for a person using a specific language.
     */
    fun movieCredits(
        personId: PersonId,
        language: Language,
    ): PersonMovieCredits

    /**
     * Loads TV credits for a person.
     */
    fun tvCredits(personId: PersonId): PersonTvCredits

    /**
     * Loads TV credits for a person using a specific language.
     */
    fun tvCredits(
        personId: PersonId,
        language: Language,
    ): PersonTvCredits

    /**
     * Loads translations for a person.
     */
    fun translations(personId: PersonId): PersonTranslations

    /**
     * Loads popular people.
     */
    fun popular(): PopularPeopleResponse

    /**
     * Loads popular people using a specific language.
     */
    fun popular(language: Language): PopularPeopleResponse

    /**
     * Loads popular people using a specific page.
     */
    fun popular(page: Int): PopularPeopleResponse

    /**
     * Loads popular people using query parameters.
     */
    fun popular(query: PopularPeopleQuery): PopularPeopleResponse

    /** Returns all profile images recorded for the person. */
    fun images(personId: PersonId): PersonImages
}
