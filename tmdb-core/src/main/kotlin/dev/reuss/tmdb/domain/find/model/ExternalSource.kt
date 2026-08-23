package dev.reuss.tmdb.domain.find.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * External ID sources supported by TMDB find.
 *
 * @property value TMDB query parameter value
 */
enum class ExternalSource(
    @all:JsonProperty("value")
    val value: String,
) {
    IMDB("imdb_id"),
    FACEBOOK("facebook_id"),
    INSTAGRAM("instagram_id"),
    TVDB("tvdb_id"),
    TIKTOK("tiktok_id"),
    TWITTER("twitter_id"),
    WIKIDATA("wikidata_id"),
    YOUTUBE("youtube_id"),
}
