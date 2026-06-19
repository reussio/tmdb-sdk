package dev.reuss.tmdb.query;

import dev.reuss.tmdb.domain.movie.MovieAppend;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppendToResponseTest {

    @Test
    void serializesValuesInStableOrder() {
        AppendToResponse<MovieAppend> append = AppendToResponse.of(
                MovieAppend.CREDITS,
                MovieAppend.WATCH_PROVIDERS,
                MovieAppend.VIDEOS
        );

        assertEquals("credits,watch/providers,videos", append.toString());
    }

    @Test
    void removesDuplicateValues() {
        AppendToResponse<MovieAppend> append = AppendToResponse.of(
                MovieAppend.CREDITS,
                MovieAppend.VIDEOS,
                MovieAppend.CREDITS
        );

        assertEquals("credits,videos", append.toString());
        assertEquals(2, append.values().size());
    }

    @Test
    void rejectsMissingInvalidOrTooManyValues() {
        assertThrows(IllegalArgumentException.class, () -> AppendToResponse.of((MovieAppend[]) null));
        assertThrows(IllegalArgumentException.class, AppendToResponse::of);
        assertThrows(IllegalArgumentException.class, () -> AppendToResponse.of(MovieAppend.CREDITS, null));

        assertThrows(IllegalArgumentException.class, () -> AppendToResponse.of(TestAppend.values()));
    }

    private enum TestAppend implements AppendableResponse {
        V01, V02, V03, V04, V05, V06, V07, V08, V09, V10, V11,
        V12, V13, V14, V15, V16, V17, V18, V19, V20, V21;

        @Override
        public String value() {
            return name().toLowerCase();
        }

        @Override
        public Class<?> responseType() {
            return Object.class;
        }
    }
}
