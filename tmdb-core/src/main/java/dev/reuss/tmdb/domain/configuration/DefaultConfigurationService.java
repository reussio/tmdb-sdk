package dev.reuss.tmdb.domain.configuration;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration;
import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage;
import dev.reuss.tmdb.domain.configuration.model.Country;
import dev.reuss.tmdb.domain.configuration.model.JobDepartment;
import dev.reuss.tmdb.domain.configuration.model.Timezone;
import dev.reuss.tmdb.value.language.Language;

import java.util.List;
import java.util.Objects;

/**
 * Default {@link ConfigurationService} implementation backed by the TMDB HTTP client.
 */
public final class DefaultConfigurationService implements ConfigurationService {

    private final TmdbHttpClient httpClient;

    /**
     * Creates a new configuration service.
     *
     * @param httpClient the TMDB HTTP client
     * @throws NullPointerException if {@code httpClient} is {@code null}
     */
    public DefaultConfigurationService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    /**
     * Loads the TMDB API configuration from {@code /configuration}.
     *
     * @return the TMDB API configuration
     */
    @Override
    public ApiConfiguration apiConfiguration() {
        return httpClient.get(TmdbRequest.get(ConfigurationPaths.details()), ApiConfiguration.class);
    }

    /**
     * Loads TMDB countries from {@code /configuration/countries}.
     *
     * @return TMDB countries
     */
    @Override
    public List<Country> countries() {
        Country[] countries = httpClient.get(
                TmdbRequest.get(ConfigurationPaths.countries()),
                Country[].class
        );

        return List.of(countries);
    }

    /**
     * Loads TMDB countries from {@code /configuration/countries} using a specific language.
     *
     * @param language response language
     * @return localized TMDB countries
     */
    @Override
    public List<Country> countries(Language language) {
        Objects.requireNonNull(language, "Language must not be null");

        Country[] countries = httpClient.get(
                TmdbRequest.get(
                        ConfigurationPaths.countries(),
                        QueryParams.create().add("language", language)
                ),
                Country[].class
        );

        return List.of(countries);
    }

    /**
     * Loads TMDB jobs from {@code /configuration/jobs}.
     *
     * @return TMDB jobs grouped by department
     */
    @Override
    public List<JobDepartment> jobs() {
        JobDepartment[] jobs = httpClient.get(
                TmdbRequest.get(ConfigurationPaths.jobs()),
                JobDepartment[].class
        );

        return List.of(jobs);
    }

    /**
     * Loads TMDB languages from {@code /configuration/languages}.
     *
     * @return TMDB languages
     */
    @Override
    public List<ConfigurationLanguage> languages() {
        ConfigurationLanguage[] languages = httpClient.get(
                TmdbRequest.get(ConfigurationPaths.languages()),
                ConfigurationLanguage[].class
        );

        return List.of(languages);
    }

    /**
     * Loads TMDB primary translations from {@code /configuration/primary_translations}.
     *
     * @return TMDB primary translation IETF tags
     */
    @Override
    public List<String> primaryTranslations() {
        String[] primaryTranslations = httpClient.get(
                TmdbRequest.get(ConfigurationPaths.primaryTranslations()),
                String[].class
        );

        return List.of(primaryTranslations);
    }

    /**
     * Loads TMDB timezones from {@code /configuration/timezones}.
     *
     * @return TMDB timezones grouped by country
     */
    @Override
    public List<Timezone> timezones() {
        Timezone[] timezones = httpClient.get(
                TmdbRequest.get(ConfigurationPaths.timezones()),
                Timezone[].class
        );

        return List.of(timezones);
    }
}
