package dev.reuss.tmdb.common.external

import com.fasterxml.jackson.annotation.JsonProperty
import dev.reuss.tmdb.common.TmdbModel

/**
 * External identifiers associated with a TMDB resource.
 *
 * @property id TMDB resource id
 * @property imdbId IMDb id
 * @property wikidataId Wikidata id
 * @property facebookId Facebook id
 * @property instagramId Instagram id
 * @property twitterId Twitter id
 * @property tvdbId TVDB id
 * @property tvrageId TVRage id
 * @property freebaseMid Freebase machine id
 * @property freebaseId Freebase id
 * @property tiktokId TikTok id
 * @property youtubeId YouTube id
 */
@JvmRecord
data class ExternalIds(
    @all:JsonProperty("id")
    val id: Int,

    @all:JsonProperty("imdb_id")
    val imdbId: String?,

    @all:JsonProperty("wikidata_id")
    val wikidataId: String?,

    @all:JsonProperty("facebook_id")
    val facebookId: String?,

    @all:JsonProperty("instagram_id")
    val instagramId: String?,

    @all:JsonProperty("twitter_id")
    val twitterId: String?,

    @all:JsonProperty("tvdb_id")
    val tvdbId: Int?,

    @all:JsonProperty("tvrage_id")
    val tvrageId: Int?,

    @all:JsonProperty("freebase_mid")
    val freebaseMid: String?,

    @all:JsonProperty("freebase_id")
    val freebaseId: String?,

    @all:JsonProperty("tiktok_id")
    val tiktokId: String?,

    @all:JsonProperty("youtube_id")
    val youtubeId: String?
) : TmdbModel {

    fun hasSocialIds(): Boolean =
        facebookId != null ||
                instagramId != null ||
                twitterId != null ||
                tiktokId != null ||
                youtubeId != null

    fun hasDatabaseIds(): Boolean =
        imdbId != null ||
                wikidataId != null ||
                tvdbId != null ||
                tvrageId != null ||
                freebaseMid != null ||
                freebaseId != null
}
