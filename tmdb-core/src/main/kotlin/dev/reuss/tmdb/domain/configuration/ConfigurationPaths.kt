package dev.reuss.tmdb.domain.configuration

import dev.reuss.tmdb.core.path.tmdbPath

internal object ConfigurationPaths {
    fun details(): String = tmdbPath("configuration")

    fun countries(): String = tmdbPath("configuration", "countries")

    fun jobs(): String = tmdbPath("configuration", "jobs")

    fun languages(): String = tmdbPath("configuration", "languages")

    fun primaryTranslations(): String = tmdbPath("configuration", "primary_translations")

    fun timezones(): String = tmdbPath("configuration", "timezones")
}
