package dev.reuss.tmdb.common.title;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.reuss.tmdb.domain.movie.model.MovieAlternativeTitles;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesAlternativeTitles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlternativeTitleDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void preservesEndpointSpecificMovieTitlesRoot() throws Exception {
        MovieAlternativeTitles titles = objectMapper.readValue("""
                {
                  "id": 550,
                  "titles": [
                    {
                      "iso_3166_1": "US",
                      "title": "Fight Club",
                      "type": "Original Title"
                    }
                  ]
                }
                """, MovieAlternativeTitles.class);

        assertEquals(550, titles.id());
        assertEquals("Fight Club", titles.titles().getFirst().title());
    }

    @Test
    void preservesEndpointSpecificTvSeriesResultsRoot() throws Exception {
        TvSeriesAlternativeTitles titles = objectMapper.readValue("""
                {
                  "id": 1399,
                  "results": [
                    {
                      "iso_3166_1": "DE",
                      "title": "Game of Thrones",
                      "type": "German"
                    }
                  ]
                }
                """, TvSeriesAlternativeTitles.class);

        assertEquals(1399, titles.id());
        assertEquals("Game of Thrones", titles.results().getFirst().title());
    }
}
