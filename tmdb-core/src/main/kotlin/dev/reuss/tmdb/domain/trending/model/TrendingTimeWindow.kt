package dev.reuss.tmdb.domain.trending.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Time window for TMDB trending requests.
 */
enum class TrendingTimeWindow(
    @all:JsonProperty("value")
    val value: String,
) {
    DAY("day"),
    WEEK("week"),
}
