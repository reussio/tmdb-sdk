package dev.reuss.tmdb.domain.people;

import dev.reuss.tmdb.domain.people.model.PersonDetails;
import dev.reuss.tmdb.domain.people.model.PopularPeopleResponse;
import dev.reuss.tmdb.domain.people.query.PopularPeopleQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.id.PersonId;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultPersonServiceTest {

    @Test
    void detailsPassesPersonPathLanguageAppendAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultPersonService(http).details(
                PersonId.of(287),
                Language.of("de-DE"),
                AppendToResponse.of(PersonAppend.COMBINED_CREDITS, PersonAppend.IMAGES)
        );

        assertLastRequest(
                http,
                "/person/287",
                Map.of("language", "de-DE", "append_to_response", "combined_credits,images"),
                PersonDetails.class
        );
    }

    @Test
    void popularPassesQueryParams() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultPersonService(http).popular(
                PopularPeopleQuery.create().language(Language.of("en-US")).page(2)
        );

        assertLastRequest(
                http,
                "/person/popular",
                Map.of("language", "en-US", "page", "2"),
                PopularPeopleResponse.class
        );
    }

    @Test
    void rejectsNullRequiredInputs() {
        DefaultPersonService service = new DefaultPersonService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.details(null));
        assertThrows(NullPointerException.class, () -> service.popular((PopularPeopleQuery) null));
    }
}
