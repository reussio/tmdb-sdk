package dev.reuss.tmdb.domain.people

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages
import dev.reuss.tmdb.domain.people.model.*
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.value.id.PersonId
import dev.reuss.tmdb.value.language.Language

/**
 * Service for loading TMDB person metadata.
 */
interface PersonService {

    /**
     * Loads top level person details.
     *
     * @param personId the person id
     * @return person details
     */
    fun details(personId: PersonId): PersonDetails

    /**
     * Loads top level person details using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized person details
     */
    fun details(
        personId: PersonId,
        language: Language
    ): PersonDetails

    /**
     * Loads top level person details with appended responses.
     *
     * @param personId the person id
     * @param appendToResponse appended response sections
     * @return person details with appended responses
     */
    fun details(
        personId: PersonId,
        appendToResponse: AppendToResponse<PersonAppend>
    ): PersonDetails

    /**
     * Loads top level person details using a specific language and appended responses.
     *
     * @param personId the person id
     * @param language response language
     * @param appendToResponse appended response sections
     * @return localized person details with appended responses
     */
    fun details(
        personId: PersonId,
        language: Language,
        appendToResponse: AppendToResponse<PersonAppend>
    ): PersonDetails

    /**
     * Loads recent changes for a person.
     *
     * @param personId the person id
     * @return person changes
     */
    fun changes(personId: PersonId): PersonChanges

    /**
     * Loads recent changes for a person using query parameters.
     *
     * @param personId the person id
     * @param query changes query
     * @return person changes
     */
    fun changes(
        personId: PersonId,
        query: ChangesQuery
    ): PersonChanges

    /**
     * Loads combined movie and TV credits for a person.
     *
     * @param personId the person id
     * @return combined person credits
     */
    fun combinedCredits(personId: PersonId): PersonCombinedCredits

    /**
     * Loads combined movie and TV credits for a person using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized combined person credits
     */
    fun combinedCredits(
        personId: PersonId,
        language: Language
    ): PersonCombinedCredits

    /**
     * Loads external IDs for a person.
     *
     * @param personId the person id
     * @return external person IDs
     */
    fun externalIds(personId: PersonId): ExternalIds

    /**
     * Loads the newest created TMDB person.
     *
     * This is a live response and can change continuously.
     *
     * @return latest created person
     */
    fun latest(): PersonDetails

    /**
     * Loads movie credits for a person.
     *
     * @param personId the person id
     * @return movie credits
     */
    fun movieCredits(personId: PersonId): PersonMovieCredits

    /**
     * Loads movie credits for a person using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized movie credits
     */
    fun movieCredits(
        personId: PersonId,
        language: Language
    ): PersonMovieCredits

    /**
     * Loads TV credits for a person.
     *
     * @param personId the person id
     * @return TV credits
     */
    fun tvCredits(personId: PersonId): PersonTvCredits

    /**
     * Loads TV credits for a person using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized TV credits
     */
    fun tvCredits(
        personId: PersonId,
        language: Language
    ): PersonTvCredits

    /**
     * Loads translations for a person.
     *
     * @param personId the person id
     * @return person translations
     */
    fun translations(personId: PersonId): PersonTranslations

    /**
     * Loads popular people.
     *
     * @return popular people
     */
    fun popular(): PopularPeopleResponse

    /**
     * Loads popular people using a specific language.
     *
     * @param language response language
     * @return localized popular people
     */
    fun popular(language: Language): PopularPeopleResponse

    /**
     * Loads popular people using a specific page.
     *
     * @param page page number
     * @return popular people page
     */
    fun popular(page: Int): PopularPeopleResponse

    /**
     * Loads popular people using query parameters.
     *
     * @param query popular people query
     * @return popular people
     */
    fun popular(query: PopularPeopleQuery): PopularPeopleResponse

    /**
     * Loads images for a person.
     *
     * @param personId the person id
     * @return person images
     */
    fun images(personId: PersonId): PersonImages
}