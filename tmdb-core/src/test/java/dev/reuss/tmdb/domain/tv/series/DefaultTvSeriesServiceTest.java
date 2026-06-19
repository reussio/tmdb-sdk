package dev.reuss.tmdb.domain.tv.series;

import dev.reuss.tmdb.domain.tv.series.model.TvSeriesDetails;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesListResponse;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultTvSeriesServiceTest {

    @Test
    void detailsPassesSeriesPathLanguageAppendAndResponseType() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvSeriesService(http).details(
                TvShowId.of(1399),
                Language.of("de-DE"),
                AppendToResponse.of(TvSeriesAppend.CREDITS, TvSeriesAppend.WATCH_PROVIDERS)
        );

        assertLastRequest(
                http,
                "/tv/1399",
                Map.of("language", "de-DE", "append_to_response", "credits,watch/providers"),
                TvSeriesDetails.class
        );
    }

    @Test
    void airingTodayPassesDateListQuery() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvSeriesService(http).airingToday(
                TvSeriesDateListQuery.create()
                        .language(Language.of("de-DE"))
                        .page(2)
                        .timezone("Europe/Berlin")
        );

        assertLastRequest(
                http,
                "/tv/airing_today",
                Map.of("language", "de-DE", "page", "2", "timezone", "Europe/Berlin"),
                TvSeriesListResponse.class
        );
    }

    @Test
    void onTheAirPassesDateListQuery() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvSeriesService(http).onTheAir(
                TvSeriesDateListQuery.create()
                        .language(Language.of("de-DE"))
                        .page(2)
                        .timezone("Europe/Berlin")
        );

        assertLastRequest(
                http,
                "/tv/on_the_air",
                Map.of("language", "de-DE", "page", "2", "timezone", "Europe/Berlin"),
                TvSeriesListResponse.class
        );
    }

    @Test
    void popularPassesListQuery() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvSeriesService(http).popular(
                TvSeriesListQuery.create().language(Language.of("en-US")).page(2)
        );

        assertLastRequest(
                http,
                "/tv/popular",
                Map.of("language", "en-US", "page", "2"),
                TvSeriesListResponse.class
        );
    }

    @Test
    void topRatedPassesListQuery() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultTvSeriesService(http).topRated(
                TvSeriesListQuery.create().language(Language.of("en-US")).page(2)
        );

        assertLastRequest(
                http,
                "/tv/top_rated",
                Map.of("language", "en-US", "page", "2"),
                TvSeriesListResponse.class
        );
    }

    @Test
    void rejectsNullRequiredInputs() {
        DefaultTvSeriesService service = new DefaultTvSeriesService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.details(null));
        assertThrows(NullPointerException.class, () -> service.details(TvShowId.of(1399), (Language) null));
        assertThrows(NullPointerException.class, () -> service.airingToday((Language) null));
        assertThrows(NullPointerException.class, () -> service.airingToday((TvSeriesDateListQuery) null));
        assertThrows(NullPointerException.class, () -> service.onTheAir((Language) null));
        assertThrows(NullPointerException.class, () -> service.onTheAir((TvSeriesDateListQuery) null));
        assertThrows(NullPointerException.class, () -> service.popular((Language) null));
        assertThrows(NullPointerException.class, () -> service.popular((TvSeriesListQuery) null));
        assertThrows(NullPointerException.class, () -> service.topRated((Language) null));
        assertThrows(NullPointerException.class, () -> service.topRated((TvSeriesListQuery) null));
    }
}
