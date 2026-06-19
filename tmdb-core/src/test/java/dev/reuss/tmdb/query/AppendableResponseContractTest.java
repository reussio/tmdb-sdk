package dev.reuss.tmdb.query;

import dev.reuss.tmdb.domain.movie.MovieAppend;
import dev.reuss.tmdb.domain.people.PersonAppend;
import dev.reuss.tmdb.domain.tv.episode.TvEpisodeAppend;
import dev.reuss.tmdb.domain.tv.season.TvSeasonAppend;
import dev.reuss.tmdb.domain.tv.series.TvSeriesAppend;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AppendableResponseContractTest {

    @Test
    void movieAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
                MovieAppend.values(),
                List.of(
                        "alternative_titles",
                        "changes",
                        "credits",
                        "external_ids",
                        "images",
                        "keywords",
                        "recommendations",
                        "release_dates",
                        "reviews",
                        "similar",
                        "translations",
                        "videos",
                        "watch/providers"
                )
        );
    }

    @Test
    void personAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
                PersonAppend.values(),
                List.of(
                        "changes",
                        "combined_credits",
                        "external_ids",
                        "images",
                        "movie_credits",
                        "tv_credits",
                        "translations"
                )
        );
    }

    @Test
    void tvSeriesAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
                TvSeriesAppend.values(),
                List.of(
                        "aggregate_credits",
                        "alternative_titles",
                        "changes",
                        "content_ratings",
                        "credits",
                        "episode_groups",
                        "external_ids",
                        "images",
                        "keywords",
                        "recommendations",
                        "reviews",
                        "screened_theatrically",
                        "similar",
                        "translations",
                        "videos",
                        "watch/providers"
                )
        );
    }

    @Test
    void tvSeasonAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
                TvSeasonAppend.values(),
                List.of(
                        "aggregate_credits",
                        "changes",
                        "credits",
                        "external_ids",
                        "images",
                        "translations",
                        "videos",
                        "watch/providers"
                )
        );
    }

    @Test
    void tvEpisodeAppendValuesExposeStableTmdbKeys() {
        assertAppendValues(
                TvEpisodeAppend.values(),
                List.of(
                        "changes",
                        "credits",
                        "external_ids",
                        "images",
                        "translations",
                        "videos"
                )
        );
    }

    @Test
    void unusualWatchProvidersKeyRemainsStable() {
        assertEquals("watch/providers", MovieAppend.WATCH_PROVIDERS.value());
        assertEquals("watch/providers", TvSeriesAppend.WATCH_PROVIDERS.value());
        assertEquals("watch/providers", TvSeasonAppend.WATCH_PROVIDERS.value());
    }

    private static void assertAppendValues(AppendableResponse[] values, List<String> expectedKeys) {
        valuesStream(values).forEach(value -> {
            assertInstanceOf(AppendableResponse.class, value);
            assertNotNull(value.responseType());
        });
        assertEquals(expectedKeys, valuesStream(values).map(AppendableResponse::value).toList());
    }

    private static Stream<AppendableResponse> valuesStream(AppendableResponse[] values) {
        return Arrays.stream(values);
    }
}
