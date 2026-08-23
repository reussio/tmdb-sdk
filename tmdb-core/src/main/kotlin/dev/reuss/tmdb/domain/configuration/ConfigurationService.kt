package dev.reuss.tmdb.domain.configuration

import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration
import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.configuration.model.JobDepartment
import dev.reuss.tmdb.domain.configuration.model.Timezone
import dev.reuss.tmdb.value.language.Language

/**
 * Loads the reference data used by TMDB clients.
 *
 * In particular, [apiConfiguration] supplies the base URLs and current size tokens needed to turn
 * TMDB image paths into complete URLs. Configuration values can change and should be refreshed
 * periodically if an application caches them.
 *
 * See the [TMDB configuration reference](https://developer.themoviedb.org/reference/configuration-details).
 */
interface ConfigurationService {
    /** Returns API configuration, including image and change-key metadata. */
    fun apiConfiguration(): ApiConfiguration

    /** Returns countries used by TMDB. */
    fun countries(): List<Country>

    /** Returns countries with their names localized in [language]. */
    fun countries(language: Language): List<Country>

    /** Returns jobs grouped by department. */
    fun jobs(): List<JobDepartment>

    /** Returns languages used by TMDB. */
    fun languages(): List<ConfigurationLanguage>

    /**
     * Returns the IETF language tags that TMDB officially supports as primary translations.
     *
     * This is not an exhaustive list of languages that may occur in user-supplied content.
     */
    fun primaryTranslations(): List<String>

    /** Returns time-zone identifiers grouped by ISO 3166-1 country code. */
    fun timezones(): List<Timezone>
}
