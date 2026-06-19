package dev.reuss.tmdb.domain.people;

import dev.reuss.tmdb.value.id.PersonId;

final class PeoplePaths {

    private static final String PERSON = "/person";

    private PeoplePaths() {
    }

    static String details(PersonId personId) {
        return person(personId);
    }

    static String changes(PersonId personId) {
        return person(personId) + "/changes";
    }

    static String combinedCredits(PersonId personId) {
        return person(personId) + "/combined_credits";
    }

    static String externalIds(PersonId personId) {
        return person(personId) + "/external_ids";
    }

    static String images(PersonId personId) {
        return person(personId) + "/images";
    }

    static String movieCredits(PersonId personId) {
        return person(personId) + "/movie_credits";
    }

    static String tvCredits(PersonId personId) {
        return person(personId) + "/tv_credits";
    }

    static String translations(PersonId personId) {
        return person(personId) + "/translations";
    }

    static String latest() {
        return PERSON + "/latest";
    }

    static String popular() {
        return PERSON + "/popular";
    }

    private static String person(PersonId personId) {
        return PERSON + "/" + personId.asString();
    }
}