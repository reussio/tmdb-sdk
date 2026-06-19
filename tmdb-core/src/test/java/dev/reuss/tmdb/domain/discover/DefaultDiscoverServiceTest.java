package dev.reuss.tmdb.domain.discover;

import dev.reuss.tmdb.domain.discover.model.DiscoverMovieResponse;
import dev.reuss.tmdb.domain.discover.model.DiscoverTvShowResponse;
import dev.reuss.tmdb.domain.discover.query.MovieDiscoverQuery;
import dev.reuss.tmdb.domain.discover.query.TvDiscoverQuery;
import dev.reuss.tmdb.testsupport.RecordingTmdbHttpClient;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.region.Region;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.reuss.tmdb.testsupport.ServiceRequestAssertions.assertLastRequest;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultDiscoverServiceTest {

    @Test
    void moviesPassesDiscoverQueryParams() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultDiscoverService(http).movies(
                MovieDiscoverQuery.create()
                        .language(Language.of("de-DE"))
                        .page(2)
                        .includeAdult(false)
                        .includeVideo(false)
                        .region(Region.of("DE"))
                        .year(1999)
                        .primaryReleaseYear(1999)
                        .withGenres("18")
        );

        assertLastRequest(
                http,
                "/discover/movie",
                Map.of(
                        "language", "de-DE",
                        "page", "2",
                        "include_adult", "false",
                        "include_video", "false",
                        "region", "DE",
                        "year", "1999",
                        "primary_release_year", "1999",
                        "with_genres", "18"
                ),
                DiscoverMovieResponse.class
        );
    }

    @Test
    void tvPassesDiscoverQueryParams() {
        RecordingTmdbHttpClient http = new RecordingTmdbHttpClient();

        new DefaultDiscoverService(http).tv(
                TvDiscoverQuery.create()
                        .language(Language.of("en-US"))
                        .page(4)
                        .includeAdult(false)
                        .firstAirDateYear(2017)
                        .watchRegion(Region.of("US"))
                        .withNetworks(213)
        );

        assertLastRequest(
                http,
                "/discover/tv",
                Map.of(
                        "language", "en-US",
                        "page", "4",
                        "include_adult", "false",
                        "first_air_date_year", "2017",
                        "watch_region", "US",
                        "with_networks", "213"
                ),
                DiscoverTvShowResponse.class
        );
    }

    @Test
    void rejectsNullQueries() {
        DefaultDiscoverService service = new DefaultDiscoverService(new RecordingTmdbHttpClient());

        assertThrows(NullPointerException.class, () -> service.movies(null));
        assertThrows(NullPointerException.class, () -> service.tv(null));
    }
}
