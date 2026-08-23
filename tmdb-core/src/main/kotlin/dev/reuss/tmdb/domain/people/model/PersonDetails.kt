package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages

/**
 * Top level TMDB person details.
 *
 * @property adult whether the person is marked as adult
 * @property alsoKnownAs alternative names
 * @property biography person biography
 * @property birthday birthday
 * @property deathday deathday
 * @property gender gender value returned by TMDB
 * @property homepage homepage URL
 * @property id TMDB person id
 * @property imdbId IMDb id
 * @property knownForDepartment known department
 * @property name person name
 * @property placeOfBirth place of birth
 * @property popularity person popularity
 * @property profilePath profile image path
 * @property changes appended changes
 * @property combinedCredits appended combined credits
 * @property externalIds appended external ids
 * @property images appended images
 * @property movieCredits appended movie credits
 * @property tvCredits appended TV credits
 * @property translations appended translations
 */
@JvmRecord
data class PersonDetails(
    @all:JsonProperty("adult")
    val adult: Boolean,

    @all:JsonProperty("also_known_as")
    val alsoKnownAs: List<String> = emptyList(),

    @all:JsonProperty("biography")
    val biography: String?,

    @all:JsonProperty("birthday")
    val birthday: String?,

    @all:JsonProperty("deathday")
    val deathday: String?,

    @all:JsonProperty("gender")
    val gender: Int,

    @all:JsonProperty("homepage")
    val homepage: String?,

    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("imdb_id")
    val imdbId: String?,

    @all:JsonProperty("known_for_department")
    val knownForDepartment: String?,

    @all:JsonProperty("name")
    val name: String?,

    @all:JsonProperty("place_of_birth")
    val placeOfBirth: String?,

    @all:JsonProperty("popularity")
    val popularity: Double,

    @all:JsonProperty("profile_path")
    val profilePath: String?,

    @all:JsonProperty("changes")
    val changes: PersonChanges? = null,

    @all:JsonProperty("combined_credits")
    val combinedCredits: PersonCombinedCredits? = null,

    @all:JsonProperty("external_ids")
    val externalIds: ExternalIds? = null,

    @all:JsonProperty("images")
    val images: PersonImages? = null,

    @all:JsonProperty("movie_credits")
    val movieCredits: PersonMovieCredits? = null,

    @all:JsonProperty("tv_credits")
    val tvCredits: PersonTvCredits? = null,

    @all:JsonProperty("translations")
    val translations: PersonTranslations? = null
) : TmdbModel