package dev.reuss.tmdb.domain.configuration

import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.configuration.model.JobDepartment
import dev.reuss.tmdb.domain.configuration.model.Timezone
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient
import dev.reuss.tmdb.testsupport.assertLastRequest
import dev.reuss.tmdb.value.language.Language
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DefaultConfigurationServiceTest {

    @Test
    fun countriesPassesPathAndResponseType() {
        val http = RecordingTmdbHttpClient()
            .respondWith(emptyArray<Country>())

        val countries = DefaultConfigurationService(http).countries()

        assertLastRequest(
            http,
            "/configuration/countries",
            emptyMap(),
            Array<Country>::class.java
        )
        Assertions.assertEquals(0, countries.size)
    }

    @Test
    fun countriesPassesPathLanguageAndResponseType() {
        val http = RecordingTmdbHttpClient()
            .respondWith(
                arrayOf(
                    Country("DE", "Germany", "Deutschland"),
                    Country("US", "United States of America", "United States")
                )
            )

        val countries = DefaultConfigurationService(http)
            .countries(Language.of("de-DE"))

        assertLastRequest(
            http,
            "/configuration/countries",
            mapOf("language" to "de-DE"),
            Array<Country>::class.java
        )
        Assertions.assertEquals(2, countries.size)
        Assertions.assertEquals("DE", countries[0].iso31661)
    }

    @Test
    fun jobsPassesPathAndResponseType() {
        val http = RecordingTmdbHttpClient()
            .respondWith(
                arrayOf(
                    JobDepartment(
                        "Production",
                        listOf("Casting", "Producer")
                    )
                )
            )

        val jobs = DefaultConfigurationService(http).jobs()

        assertLastRequest(
            http,
            "/configuration/jobs",
            emptyMap(),
            Array<JobDepartment>::class.java
        )
        Assertions.assertEquals(1, jobs.size)
        Assertions.assertEquals("Production", jobs[0].department)
        Assertions.assertEquals(listOf("Casting", "Producer"), jobs[0].jobs)
    }

    @Test
    fun languagesPassesPathAndResponseType() {
        val http = RecordingTmdbHttpClient()
            .respondWith(
                arrayOf(
                    ConfigurationLanguage("de", "German", "Deutsch")
                )
            )

        val languages = DefaultConfigurationService(http).languages()

        assertLastRequest(
            http,
            "/configuration/languages",
            emptyMap(),
            Array<ConfigurationLanguage>::class.java
        )
        Assertions.assertEquals(1, languages.size)
        Assertions.assertEquals("de", languages[0].iso6391)
        Assertions.assertEquals("Deutsch", languages[0].name)
    }

    @Test
    fun primaryTranslationsPassesPathAndResponseType() {
        val http = RecordingTmdbHttpClient()
            .respondWith(arrayOf("de-DE", "en-US"))

        val primaryTranslations =
            DefaultConfigurationService(http).primaryTranslations()

        assertLastRequest(
            http,
            "/configuration/primary_translations",
            emptyMap(),
            Array<String>::class.java
        )
        Assertions.assertEquals(
            listOf("de-DE", "en-US"),
            primaryTranslations
        )
    }

    @Test
    fun timezonesPassesPathAndResponseType() {
        val http = RecordingTmdbHttpClient()
            .respondWith(
                arrayOf(
                    Timezone(
                        "DE",
                        listOf("Europe/Berlin", "Europe/Zurich")
                    )
                )
            )

        val timezones = DefaultConfigurationService(http).timezones()

        assertLastRequest(
            http,
            "/configuration/timezones",
            emptyMap(),
            Array<Timezone>::class.java
        )
        Assertions.assertEquals(1, timezones.size)
        Assertions.assertEquals("DE", timezones[0].iso31661)
        Assertions.assertEquals(
            listOf("Europe/Berlin", "Europe/Zurich"),
            timezones[0].zones
        )
    }
}