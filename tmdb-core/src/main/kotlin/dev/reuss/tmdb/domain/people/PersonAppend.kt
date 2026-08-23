package dev.reuss.tmdb.domain.people

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages
import dev.reuss.tmdb.domain.people.model.PersonChanges
import dev.reuss.tmdb.domain.people.model.PersonCombinedCredits
import dev.reuss.tmdb.domain.people.model.PersonMovieCredits
import dev.reuss.tmdb.domain.people.model.PersonTranslations
import dev.reuss.tmdb.domain.people.model.PersonTvCredits
import dev.reuss.tmdb.query.AppendableResponse

/**
 * Supported person `append_to_response` values.
 */
enum class PersonAppend(
    override val value: String,
    override val responseType: Class<*>,
) : AppendableResponse {
    CHANGES("changes", PersonChanges::class.java),
    COMBINED_CREDITS("combined_credits", PersonCombinedCredits::class.java),
    EXTERNAL_IDS("external_ids", ExternalIds::class.java),
    IMAGES("images", PersonImages::class.java),
    MOVIE_CREDITS("movie_credits", PersonMovieCredits::class.java),
    TV_CREDITS("tv_credits", PersonTvCredits::class.java),
    TRANSLATIONS("translations", PersonTranslations::class.java),
}
