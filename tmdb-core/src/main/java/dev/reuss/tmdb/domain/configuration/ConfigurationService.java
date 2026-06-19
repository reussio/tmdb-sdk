package dev.reuss.tmdb.domain.configuration;

import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration;
import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage;
import dev.reuss.tmdb.domain.configuration.model.Country;
import dev.reuss.tmdb.domain.configuration.model.JobDepartment;
import dev.reuss.tmdb.domain.configuration.model.Timezone;
import dev.reuss.tmdb.value.language.Language;

import java.util.List;

/**
 * Service for loading TMDB API configuration metadata.
 *
 * <p>The configuration contains image base URLs and supported image sizes
 * required to build complete TMDB image URLs.</p>
 *
 * @see <a href="https://developer.themoviedb.org/reference/configuration-details">TMDB Configuration</a>
 */
public interface ConfigurationService {

    /**
     * Loads the TMDB API configuration.
     *
     * @return the TMDB API configuration
     */
    ApiConfiguration apiConfiguration();

    /**
     * Loads countries used throughout TMDB.
     *
     * @return TMDB countries
     */
    List<Country> countries();

    /**
     * Loads countries used throughout TMDB using a specific language.
     *
     * @param language response language
     * @return localized TMDB countries
     */
    List<Country> countries(Language language);

    /**
     * Loads jobs and departments used throughout TMDB.
     *
     * @return TMDB jobs grouped by department
     */
    List<JobDepartment> jobs();

    /**
     * Loads languages used throughout TMDB.
     *
     * @return TMDB languages
     */
    List<ConfigurationLanguage> languages();

    /**
     * Loads officially supported primary translations on TMDB.
     *
     * @return TMDB primary translation IETF tags
     */
    List<String> primaryTranslations();

    /**
     * Loads timezones used throughout TMDB.
     *
     * @return TMDB timezones grouped by country
     */
    List<Timezone> timezones();
}
