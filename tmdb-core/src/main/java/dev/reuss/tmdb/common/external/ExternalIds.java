package dev.reuss.tmdb.common.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.reuss.tmdb.common.TmdbModel;

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

    public boolean hasSocialIds() {
        return facebookId != null
                || instagramId != null
                || twitterId != null
                || tiktokId != null
                || youtubeId != null;
    }

    public boolean hasDatabaseIds() {
        return imdbId != null
                || wikidataId != null
                || tvdbId != null
                || tvrageId != null
                || freebaseMid != null
                || freebaseId != null;
    }

}
