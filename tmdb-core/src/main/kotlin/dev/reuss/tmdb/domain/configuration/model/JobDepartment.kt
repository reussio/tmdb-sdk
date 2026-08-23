package dev.reuss.tmdb.domain.configuration.model

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * TMDB jobs grouped by department.
 *
 * @property department department name
 * @property jobs jobs in the department
 */
@JvmRecord
data class JobDepartment(
    @all:JsonProperty("department")
    val department: String?,
    @all:JsonProperty("jobs")
    val jobs: List<String> = emptyList(),
) : TmdbModel
