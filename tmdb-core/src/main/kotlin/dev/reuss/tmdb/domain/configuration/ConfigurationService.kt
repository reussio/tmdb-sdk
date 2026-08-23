package dev.reuss.tmdb.domain.configuration

import dev.reuss.tmdb.domain.configuration.model.*
import dev.reuss.tmdb.value.language.Language

/**
 * Service for loading TMDB API configuration metadata.
 *
 * The configuration contains image base URLs and supported image sizes
 * required to build complete TMDB image URLs.
 *
 * @see <a href="https://developer.themoviedb.org/reference/configuration-details">TMDB Configuration</a>
 */
interface ConfigurationService {

    /**
     * Loads the TMDB API configuration.
     *
     * @return the TMDB API configuration
     */
    fun apiConfiguration(): ApiConfiguration

    /**
     * Loads countries used throughout TMDB.
     *
     * @return TMDB countries
     */
    fun countries(): List<Country>

    /**
     * Loads countries used throughout TMDB using a specific language.
     *
     * @param language response language
     * @return localized TMDB countries
     */
    fun countries(language: Language): List<Country>

    /**
     * Loads jobs and departments used throughout TMDB.
     *
     * @return TMDB jobs grouped by department
     */
    fun jobs(): List<JobDepartment>

    /**
     * Loads languages used throughout TMDB.
     *
     * @return TMDB languages
     */
    fun languages(): List<ConfigurationLanguage>

    /**
     * Loads officially supported primary translations on TMDB.
     *
     * @return TMDB primary translation IETF tags
     */
    fun primaryTranslations(): List<String>

    /**
     * Loads timezones used throughout TMDB.
     *
     * @return TMDB timezones grouped by country
     */
    fun timezones(): List<Timezone>
}