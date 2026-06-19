package dev.reuss.tmdb.domain.find.model;

/**
 * External ID sources supported by TMDB find.
 */
public enum ExternalSource {
    IMDB("imdb_id"),
    FACEBOOK("facebook_id"),
    INSTAGRAM("instagram_id"),
    TVDB("tvdb_id"),
    TIKTOK("tiktok_id"),
    TWITTER("twitter_id"),
    WIKIDATA("wikidata_id"),
    YOUTUBE("youtube_id");

    private final String value;

    ExternalSource(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}