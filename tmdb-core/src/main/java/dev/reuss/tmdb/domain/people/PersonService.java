package dev.reuss.tmdb.domain.people;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.PersonImages;
import dev.reuss.tmdb.domain.people.model.*;
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.value.id.PersonId;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for loading TMDB person metadata.
 */
public interface PersonService {

    /**
     * Loads top level person details.
     *
     * @param personId the person id
     * @return person details
     */
    PersonDetails details(PersonId personId);

    /**
     * Loads top level person details using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized person details
     */
    PersonDetails details(PersonId personId, Language language);

    /**
     * Loads top level person details with appended responses.
     *
     * @param personId         the person id
     * @param appendToResponse appended response sections
     * @return person details with appended responses
     */
    PersonDetails details(PersonId personId, AppendToResponse<PersonAppend> appendToResponse);

    /**
     * Loads top level person details using a specific language and appended responses.
     *
     * @param personId         the person id
     * @param language         response language
     * @param appendToResponse appended response sections
     * @return localized person details with appended responses
     */
    PersonDetails details(PersonId personId, Language language, AppendToResponse<PersonAppend> appendToResponse);

    /**
     * Loads recent changes for a person.
     *
     * @param personId the person id
     * @return person changes
     */
    PersonChanges changes(PersonId personId);

    /**
     * Loads recent changes for a person using query parameters.
     *
     * @param personId the person id
     * @param query    changes query
     * @return person changes
     */
    PersonChanges changes(PersonId personId, ChangesQuery query);

    /**
     * Loads combined movie and TV credits for a person.
     *
     * @param personId the person id
     * @return combined person credits
     */
    PersonCombinedCredits combinedCredits(PersonId personId);

    /**
     * Loads combined movie and TV credits for a person using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized combined person credits
     */
    PersonCombinedCredits combinedCredits(PersonId personId, Language language);

    /**
     * Loads external IDs for a person.
     *
     * @param personId the person id
     * @return external person IDs
     */
    ExternalIds externalIds(PersonId personId);

    /**
     * Loads the newest created TMDB person.
     *
     * <p>This is a live response and can change continuously.</p>
     *
     * @return latest created person
     */
    PersonDetails latest();

    /**
     * Loads movie credits for a person.
     *
     * @param personId the person id
     * @return movie credits
     */
    PersonMovieCredits movieCredits(PersonId personId);

    /**
     * Loads movie credits for a person using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized movie credits
     */
    PersonMovieCredits movieCredits(PersonId personId, Language language);

    /**
     * Loads TV credits for a person.
     *
     * @param personId the person id
     * @return TV credits
     */
    PersonTvCredits tvCredits(PersonId personId);

    /**
     * Loads TV credits for a person using a specific language.
     *
     * @param personId the person id
     * @param language response language
     * @return localized TV credits
     */
    PersonTvCredits tvCredits(PersonId personId, Language language);

    /**
     * Loads translations for a person.
     *
     * @param personId the person id
     * @return person translations
     */
    PersonTranslations translations(PersonId personId);

    /**
     * Loads popular people.
     *
     * @return popular people
     */
    PopularPeopleResponse popular();

    /**
     * Loads popular people using a specific language.
     *
     * @param language response language
     * @return localized popular people
     */
    PopularPeopleResponse popular(Language language);

    /**
     * Loads popular people using a specific page.
     *
     * @param page page number
     * @return popular people page
     */
    PopularPeopleResponse popular(int page);

    /**
     * Loads popular people using query parameters.
     *
     * @param query popular people query
     * @return popular people
     */
    PopularPeopleResponse popular(PopularPeopleQuery query);

    PersonImages images(PersonId personId);

}