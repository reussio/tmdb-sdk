package dev.reuss.tmdb.domain.tv.season;

import dev.reuss.tmdb.domain.tv.season.model.TvSeasonDetails;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.id.TvSeasonNumber;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultTvSeasonServiceTest {

    @Test
    void detailsAllowsSeasonZeroForSpecialsAndPassesLanguageAppend() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvSeasonService(http).details(
                TvShowId.of(1399),
                TvSeasonNumber.of(0),
                Language.of("de-DE"),
                AppendToResponse.of(TvSeasonAppend.CREDITS, TvSeasonAppend.WATCH_PROVIDERS)
        );

        assertLastRequest(
                http,
                "/tv/1399/season/0",
                Map.of("language", "de-DE", "append_to_response", "credits,watch/providers"),
                TvSeasonDetails.class
        );
    }

    @Test
    void rejectsNullRequiredInputs() {
        DefaultTvSeasonService service = new DefaultTvSeasonService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.details(null, TvSeasonNumber.of(1)));
        assertThrows(NullPointerException.class, () -> service.details(TvShowId.of(1399), null));
    }
}
