package dev.reuss.tmdb.domain.people

import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.PersonImages
import dev.reuss.tmdb.domain.people.model.PersonChanges
import dev.reuss.tmdb.domain.people.model.PersonCombinedCredits
import dev.reuss.tmdb.domain.people.model.PersonDetails
import dev.reuss.tmdb.domain.people.model.PersonMovieCredits
import dev.reuss.tmdb.domain.people.model.PersonTranslations
import dev.reuss.tmdb.domain.people.model.PersonTvCredits
import dev.reuss.tmdb.domain.people.model.PopularPeopleResponse
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery
import dev.reuss.tmdb.query.AppendToResponse
import dev.reuss.tmdb.query.ChangesQuery
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.PersonId
import dev.reuss.tmdb.value.language.Languages
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class DefaultPersonServiceTest {
    private val personId = PersonId.of(287)

    @Test
    fun details_shouldSupportLanguageAndAppendOverloads() {
        val append = AppendToResponse.of(PersonAppend.COMBINED_CREDITS, PersonAppend.IMAGES)

        assertRequest<PersonDetails>("/person/287") {
            DefaultPersonService(it).details(personId)
        }
        assertRequest<PersonDetails>("/person/287", mapOf("language" to "de-DE")) {
            DefaultPersonService(it).details(personId, Languages.DE_DE)
        }
        assertRequest<PersonDetails>(
            "/person/287",
            mapOf("append_to_response" to "combined_credits,images"),
        ) {
            DefaultPersonService(it).details(personId, append)
        }
        assertRequest<PersonDetails>(
            "/person/287",
            mapOf("language" to "de-DE", "append_to_response" to "combined_credits,images"),
        ) {
            DefaultPersonService(it).details(personId, Languages.DE_DE, append)
        }
    }

    @Test
    fun changes_shouldSupportDefaultAndQueryOverloads() {
        assertRequest<PersonChanges>("/person/287/changes") {
            DefaultPersonService(it).changes(personId)
        }
        assertRequest<PersonChanges>(
            "/person/287/changes",
            mapOf("end_date" to "2024-01-14", "start_date" to "2024-01-01"),
        ) {
            DefaultPersonService(it).changes(
                personId,
                ChangesQuery
                    .create()
                    .startDate(LocalDate.of(2024, 1, 1))
                    .endDate(LocalDate.of(2024, 1, 14)),
            )
        }
    }

    @Test
    fun combinedCredits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<PersonCombinedCredits>("/person/287/combined_credits") {
            DefaultPersonService(it).combinedCredits(personId)
        }
        assertRequest<PersonCombinedCredits>(
            "/person/287/combined_credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultPersonService(it).combinedCredits(personId, Languages.DE_DE)
        }
    }

    @Test
    fun movieCredits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<PersonMovieCredits>("/person/287/movie_credits") {
            DefaultPersonService(it).movieCredits(personId)
        }
        assertRequest<PersonMovieCredits>(
            "/person/287/movie_credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultPersonService(it).movieCredits(personId, Languages.DE_DE)
        }
    }

    @Test
    fun tvCredits_shouldSupportDefaultAndLanguageOverloads() {
        assertRequest<PersonTvCredits>("/person/287/tv_credits") {
            DefaultPersonService(it).tvCredits(personId)
        }
        assertRequest<PersonTvCredits>(
            "/person/287/tv_credits",
            mapOf("language" to "de-DE"),
        ) {
            DefaultPersonService(it).tvCredits(personId, Languages.DE_DE)
        }
    }

    @Test
    fun popular_shouldSupportAllOverloads() {
        assertRequest<PopularPeopleResponse>("/person/popular") {
            DefaultPersonService(it).popular()
        }
        assertRequest<PopularPeopleResponse>("/person/popular", mapOf("language" to "de-DE")) {
            DefaultPersonService(it).popular(Languages.DE_DE)
        }
        assertRequest<PopularPeopleResponse>("/person/popular", mapOf("page" to "2")) {
            DefaultPersonService(it).popular(2)
        }
        assertRequest<PopularPeopleResponse>(
            "/person/popular",
            mapOf("language" to "de-DE", "page" to "2"),
        ) {
            DefaultPersonService(it).popular(
                PopularPeopleQuery.create().language(Languages.DE_DE).page(2),
            )
        }
    }

    @Test
    fun popular_shouldRejectInvalidPageBeforeHttpCall() {
        val http = RecordingTmdbHttpClient()

        assertThrows<IllegalArgumentException> {
            DefaultPersonService(http).popular(0)
        }

        assertEquals(0, http.calls())
    }

    @Test
    fun remainingMethods_shouldUseExpectedPathsAndResponseTypes() {
        assertRequest<ExternalIds>("/person/287/external_ids") {
            DefaultPersonService(it).externalIds(personId)
        }
        assertRequest<PersonDetails>("/person/latest") {
            DefaultPersonService(it).latest()
        }
        assertRequest<PersonTranslations>("/person/287/translations") {
            DefaultPersonService(it).translations(personId)
        }
        assertRequest<PersonImages>("/person/287/images") {
            DefaultPersonService(it).images(personId)
        }
    }
}
