package dev.reuss.tmdb.domain.people

import dev.reuss.tmdb.core.path.tmdbPath
import dev.reuss.tmdb.value.id.PersonId

internal object PeoplePaths {
    fun details(personId: PersonId): String = tmdbPath("person", personId)

    fun changes(personId: PersonId): String = tmdbPath("person", personId, "changes")

    fun combinedCredits(personId: PersonId): String = tmdbPath("person", personId, "combined_credits")

    fun externalIds(personId: PersonId): String = tmdbPath("person", personId, "external_ids")

    fun images(personId: PersonId): String = tmdbPath("person", personId, "images")

    fun movieCredits(personId: PersonId): String = tmdbPath("person", personId, "movie_credits")

    fun tvCredits(personId: PersonId): String = tmdbPath("person", personId, "tv_credits")

    fun translations(personId: PersonId): String = tmdbPath("person", personId, "translations")

    fun latest(): String = tmdbPath("person", "latest")

    fun popular(): String = tmdbPath("person", "popular")
}
