package dev.reuss.tmdb.domain.people.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages

/**
 * Top level TMDB person details.
 *
 * @property adult Whether TMDB marks the resource as adult content.
 * @property alsoKnownAs alternative names
 * @property biography person biography
 * @property birthday birthday
 * @property deathday deathday
 * @property gender TMDB gender code for the person.
 * @property homepage homepage URL
 * @property id TMDB person id
 * @property imdbId IMDb id
 * @property knownForDepartment Department the person is primarily known for.
 * @property name person name
 * @property placeOfBirth place of birth
 * @property popularity Popularity score calculated by TMDB.
 * @property profilePath TMDB image path for the profile image.
 * @property changes Response appended through `append_to_response` when requested.
 * @property combinedCredits Response appended through `append_to_response` when requested.
 * @property externalIds Response appended through `append_to_response` when requested.
 * @property images Response appended through `append_to_response` when requested.
 * @property movieCredits Response appended through `append_to_response` when requested.
 * @property tvCredits Response appended through `append_to_response` when requested.
 * @property translations Response appended through `append_to_response` when requested.
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
    val translations: PersonTranslations? = null,
) : TmdbModel
