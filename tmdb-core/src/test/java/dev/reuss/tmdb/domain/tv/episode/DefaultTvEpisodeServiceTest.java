package dev.reuss.tmdb.domain.tv.episode;

import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeDetails;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.id.TvEpisodeNumber;
import dev.reuss.tmdb.value.id.TvSeasonNumber;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultTvEpisodeServiceTest {

    @Test
    void detailsPassesEpisodePathLanguageAppendAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvEpisodeService(http).details(
                TvShowId.of(1399),
                TvSeasonNumber.of(1),
                TvEpisodeNumber.of(2),
                Language.of("de-DE"),
                AppendToResponse.of(TvEpisodeAppend.CREDITS, TvEpisodeAppend.VIDEOS)
        );

        assertLastRequest(
                http,
                "/tv/1399/season/1/episode/2",
                Map.of("language", "de-DE", "append_to_response", "credits,videos"),
                TvEpisodeDetails.class
        );
    }

    @Test
    void rejectsInvalidEpisodeNumberBeforeRequest() {
        assertThrows(IllegalArgumentException.class, () -> TvEpisodeNumber.of(0));
    }
}
