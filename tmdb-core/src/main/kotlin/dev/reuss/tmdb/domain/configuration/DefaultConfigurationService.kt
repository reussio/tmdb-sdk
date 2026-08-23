package dev.reuss.tmdb.domain.configuration

import dev.reuss.tmdb.core.http.QueryParams
import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest
import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration
import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.configuration.model.JobDepartment
import dev.reuss.tmdb.domain.configuration.model.Timezone
import dev.reuss.tmdb.value.language.Language

/**
 * Default [ConfigurationService] implementation backed by the TMDB HTTP client.
 */
internal class DefaultConfigurationService(
    private val httpClient: TmdbHttpClient,
) : ConfigurationService {
    /**
     * Loads the TMDB API configuration from `/configuration`.
     *
     * @return the TMDB API configuration
     */
    override fun apiConfiguration(): ApiConfiguration =
        httpClient.get(
            TmdbRequest.get(ConfigurationPaths.details()),
            ApiConfiguration::class.java,
        )

    /**
     * Loads TMDB countries from `/configuration/countries`.
     *
     * @return TMDB countries
     */
    override fun countries(): List<Country> {
        val countries =
            httpClient.get(
                TmdbRequest.get(ConfigurationPaths.countries()),
                Array<Country>::class.java,
            )

        return countries.toList()
    }

    /**
     * Loads TMDB countries from `/configuration/countries` using a specific language.
     *
     * @param language response language
     * @return localized TMDB countries
     */
    override fun countries(language: Language): List<Country> {
        val countries =
            httpClient.get(
                TmdbRequest.get(
                    ConfigurationPaths.countries(),
                    QueryParams
                        .create()
                        .add("language", language.value),
                ),
                Array<Country>::class.java,
            )

        return countries.toList()
    }

    /**
     * Loads TMDB jobs from `/configuration/jobs`.
     *
     * @return TMDB jobs grouped by department
     */
    override fun jobs(): List<JobDepartment> {
        val jobs =
            httpClient.get(
                TmdbRequest.get(ConfigurationPaths.jobs()),
                Array<JobDepartment>::class.java,
            )

        return jobs.toList()
    }

    /**
     * Loads TMDB languages from `/configuration/languages`.
     *
     * @return TMDB languages
     */
    override fun languages(): List<ConfigurationLanguage> {
        val languages =
            httpClient.get(
                TmdbRequest.get(ConfigurationPaths.languages()),
                Array<ConfigurationLanguage>::class.java,
            )

        return languages.toList()
    }

    /**
     * Loads TMDB primary translations from `/configuration/primary_translations`.
     *
     * @return TMDB primary translation IETF tags
     */
    override fun primaryTranslations(): List<String> {
        val primaryTranslations =
            httpClient.get(
                TmdbRequest.get(ConfigurationPaths.primaryTranslations()),
                Array<String>::class.java,
            )

        return primaryTranslations.toList()
    }

    /**
     * Loads TMDB timezones from `/configuration/timezones`.
     *
     * @return TMDB timezones grouped by country
     */
    override fun timezones(): List<Timezone> {
        val timezones =
            httpClient.get(
                TmdbRequest.get(ConfigurationPaths.timezones()),
                Array<Timezone>::class.java,
            )

        return timezones.toList()
    }
}
