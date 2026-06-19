package dev.reuss.tmdb.common.translation;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.reuss.tmdb.domain.movie.model.MovieTranslationData;
import dev.reuss.tmdb.domain.movie.model.MovieTranslations;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesTranslationData;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesTranslations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslationDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void mapsSharedTranslationWrapperWithMovieSpecificData() throws Exception {
        MovieTranslations translations = objectMapper.readValue("""
                {
                  "id": 550,
                  "translations": [
                    {
                      "iso_3166_1": "US",
                      "iso_639_1": "en",
                      "name": "English",
                      "english_name": "English",
                      "data": {
                        "homepage": "https://example.com",
                        "overview": "Movie overview",
                        "runtime": 139,
                        "tagline": "Movie tagline",
                        "title": "Fight Club"
                      }
                    }
                  ]
                }
                """, MovieTranslations.class);

        Translation<MovieTranslationData> translation = translations.translations().getFirst();

        assertEquals("US", translation.iso31661());
        assertEquals("en", translation.iso6391());
        assertEquals("Fight Club", translation.data().title());
    }

    @Test
    void mapsSharedTranslationWrapperWithTvSeriesSpecificData() throws Exception {
        TvSeriesTranslations translations = objectMapper.readValue("""
                {
                  "id": 1399,
                  "translations": [
                    {
                      "iso_3166_1": "DE",
                      "iso_639_1": "de",
                      "name": "Deutsch",
                      "english_name": "German",
                      "data": {
                        "name": "Game of Thrones",
                        "overview": "Serienuebersicht",
                        "homepage": "https://example.com/tv",
                        "tagline": "Serientagline"
                      }
                    }
                  ]
                }
                """, TvSeriesTranslations.class);

        Translation<TvSeriesTranslationData> translation = translations.translations().getFirst();

        assertEquals("DE", translation.iso31661());
        assertEquals("de", translation.iso6391());
        assertEquals("Game of Thrones", translation.data().name());
    }
}
