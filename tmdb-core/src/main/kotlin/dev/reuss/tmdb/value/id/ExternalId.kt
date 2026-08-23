package dev.reuss.tmdb.value.id

/**
 * Strongly typed external identifier used to find TMDB objects.
 *
 * External ids are identifiers from third-party systems such as IMDb,
 * TVDB, Wikidata, Facebook, Instagram, TikTok, Twitter or YouTube.
 */
class ExternalId private constructor(
    value: String
) : StringTmdbResourceId(value, "External id") {

    companion object {
        @JvmStatic
        fun of(value: String): ExternalId = ExternalId(value)
    }
}