package dev.reuss.tmdb.domain.configuration;

import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage;
import dev.reuss.tmdb.domain.configuration.model.Country;
import dev.reuss.tmdb.domain.configuration.model.JobDepartment;
import dev.reuss.tmdb.domain.configuration.model.Timezone;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultConfigurationServiceTest {

    @Test
    void countriesPassesPathAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient()
                .respondWith(new Country[0]);

        List<Country> countries = new DefaultConfigurationService(http).countries();

        assertLastRequest(
                http,
                "/configuration/countries",
                Map.of(),
                Country[].class
        );
        assertEquals(0, countries.size());
    }

    @Test
    void countriesPassesPathLanguageAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient()
                .respondWith(new Country[]{
                        new Country("DE", "Germany", "Deutschland"),
                        new Country("US", "United States of America", "United States")
                });

        List<Country> countries = new DefaultConfigurationService(http).countries(Language.of("de-DE"));

        assertLastRequest(
                http,
                "/configuration/countries",
                Map.of("language", "de-DE"),
                Country[].class
        );
        assertEquals(2, countries.size());
        assertEquals("DE", countries.get(0).iso31661());
    }

    @Test
    void jobsPassesPathAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient()
                .respondWith(new JobDepartment[]{
                        new JobDepartment("Production", List.of("Casting", "Producer"))
                });

        List<JobDepartment> jobs = new DefaultConfigurationService(http).jobs();

        assertLastRequest(
                http,
                "/configuration/jobs",
                Map.of(),
                JobDepartment[].class
        );
        assertEquals(1, jobs.size());
        assertEquals("Production", jobs.get(0).department());
        assertEquals(List.of("Casting", "Producer"), jobs.get(0).jobs());
    }

    @Test
    void languagesPassesPathAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient()
                .respondWith(new ConfigurationLanguage[]{
                        new ConfigurationLanguage("de", "German", "Deutsch")
                });

        List<ConfigurationLanguage> languages = new DefaultConfigurationService(http).languages();

        assertLastRequest(
                http,
                "/configuration/languages",
                Map.of(),
                ConfigurationLanguage[].class
        );
        assertEquals(1, languages.size());
        assertEquals("de", languages.get(0).iso6391());
        assertEquals("Deutsch", languages.get(0).name());
    }

    @Test
    void primaryTranslationsPassesPathAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient()
                .respondWith(new String[]{"de-DE", "en-US"});

        List<String> primaryTranslations = new DefaultConfigurationService(http).primaryTranslations();

        assertLastRequest(
                http,
                "/configuration/primary_translations",
                Map.of(),
                String[].class
        );
        assertEquals(List.of("de-DE", "en-US"), primaryTranslations);
    }

    @Test
    void timezonesPassesPathAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient()
                .respondWith(new Timezone[]{
                        new Timezone("DE", List.of("Europe/Berlin", "Europe/Zurich"))
                });

        List<Timezone> timezones = new DefaultConfigurationService(http).timezones();

        assertLastRequest(
                http,
                "/configuration/timezones",
                Map.of(),
                Timezone[].class
        );
        assertEquals(1, timezones.size());
        assertEquals("DE", timezones.get(0).iso31661());
        assertEquals(List.of("Europe/Berlin", "Europe/Zurich"), timezones.get(0).zones());
    }

    @Test
    void rejectsNullRequiredInputs() {
        DefaultConfigurationService service = new DefaultConfigurationService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.countries(null));
    }
}
