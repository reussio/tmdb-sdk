package dev.reuss.tmdb.domain.credits.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.value.media.MediaType

/**
 * TMDB credit details.
 *
 * @property creditType credit type, for example `cast` or `crew`
 * @property department credit department
 * @property job credit job
 * @property media related movie or TV media
 * @property mediaType TMDB media type discriminator, such as `movie`, `tv`, or `person`.
 * @property id TMDB credit id
 * @property person credited person
 */
@JvmRecord
data class CreditDetails(
    @all:JsonProperty("credit_type")
    val creditType: String?,
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("job")
    val job: String?,
    @all:JsonProperty("media")
    val media: CreditMedia?,
    @all:JsonProperty("media_type")
    val mediaType: MediaType?,
    @all:JsonProperty("id")
    val id: String?,
    @all:JsonProperty("person")
    val person: CreditPerson?,
) : TmdbModel
