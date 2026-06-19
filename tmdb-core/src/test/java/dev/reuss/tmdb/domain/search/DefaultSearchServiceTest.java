package dev.reuss.tmdb.domain.search;

import dev.reuss.tmdb.domain.search.model.movie.SearchMovieResponse;
import dev.reuss.tmdb.domain.search.model.tv.SearchTvShowResponse;
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery;
import dev.reuss.tmdb.domain.search.query.SearchTvQuery;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultSearchServiceTest {

    @Test
    void moviesPassesQueryAndOptionalParameters() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultSearchService(http).movies(
                SearchMovieQuery.of("Fight Club")
                        .language(Language.of("de-DE"))
                        .page(2)
                        .includeAdult(false)
                        .region(Region.of("DE"))
                        .year("1999")
                        .primaryReleaseYear("1999")
        );

        assertLastRequest(
                http,
                "/search/movie",
                Map.of(
                        "query", "Fight Club",
                        "language", "de-DE",
                        "page", "2",
                        "include_adult", "false",
                        "region", "DE",
                        "year", "1999",
                        "primary_release_year", "1999"
                ),
                SearchMovieResponse.class
        );
    }

    @Test
    void tvPassesValidatedYearParameters() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultSearchService(http).tv(
                SearchTvQuery.of("Dark")
                        .language(Language.of("de-DE"))
                        .page(3)
                        .includeAdult(false)
                        .firstAirDateYear(2017)
                        .year(2017)
        );

        assertLastRequest(
                http,
                "/search/tv",
                Map.of(
                        "query", "Dark",
                        "language", "de-DE",
                        "page", "3",
                        "include_adult", "false",
                        "first_air_date_year", "2017",
                        "year", "2017"
                ),
                SearchTvShowResponse.class
        );
    }

    @Test
    void rejectsNullAndBlankSearchInputs() {
        DefaultSearchService service = new DefaultSearchService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.movies((SearchMovieQuery) null));
        assertThrows(IllegalArgumentException.class, () -> service.movies(" "));
        assertThrows(IllegalArgumentException.class, () -> SearchTvQuery.of(""));
    }
}
