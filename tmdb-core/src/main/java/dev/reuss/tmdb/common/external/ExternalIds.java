package dev.reuss.tmdb.common.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

/**
 * External identifiers associated with a TMDB resource.
 *
 * @param id TMDB resource id
 * @param imdbId IMDb id
 * @param wikidataId Wikidata id
 * @param facebookId Facebook id
 * @param instagramId Instagram id
 * @param twitterId Twitter id
 * @param tvdbId TVDB id
 * @param tvrageId TVRage id
 * @param freebaseMid Freebase machine id
 * @param freebaseId Freebase id
 * @param tiktokId TikTok id
 * @param youtubeId YouTube id
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalIds(
        int id,

        @JsonProperty("imdb_id")
        String imdbId,

        @JsonProperty("wikidata_id")
        String wikidataId,

        @JsonProperty("facebook_id")
        String facebookId,

        @JsonProperty("instagram_id")
        String instagramId,

        @JsonProperty("twitter_id")
        String twitterId,

        @JsonProperty("tvdb_id")
        Integer tvdbId,

        @JsonProperty("tvrage_id")
        Integer tvrageId,

        @JsonProperty("freebase_mid")
        String freebaseMid,

        @JsonProperty("freebase_id")
        String freebaseId,

        @JsonProperty("tiktok_id")
        String tiktokId,

        @JsonProperty("youtube_id")
        String youtubeId
) implements TmdbModel {

    /**
     * Returns whether any social media identifier is present.
     *
     * @return {@code true} if at least one social media id is present
     */
    public boolean hasSocialIds() {
        return facebookId != null
                || instagramId != null
                || twitterId != null
                || tiktokId != null
                || youtubeId != null;
    }

    /**
     * Returns whether any external database identifier is present.
     *
     * @return {@code true} if at least one external database id is present
     */
    public boolean hasDatabaseIds() {
        return imdbId != null
                || wikidataId != null
                || tvdbId != null
                || tvrageId != null
                || freebaseMid != null
                || freebaseId != null;
    }

}
