package dev.reuss.tmdb.common.change;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.reuss.tmdb.domain.movie.model.MovieChanges;
import dev.reuss.tmdb.domain.people.model.PersonChanges;
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeChanges;
import dev.reuss.tmdb.domain.tv.season.model.TvSeasonChanges;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesChanges;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ChangeDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void mapsMovieChanges() throws Exception {
        MovieChanges changes = objectMapper.readValue(changeJson("title"), MovieChanges.class);

        assertChange(changes.changes().get(0), "title");
        assertTrue(new MovieChanges(null).changes().isEmpty());
    }

    @Test
    void mapsTvSeriesChanges() throws Exception {
        TvSeriesChanges changes = objectMapper.readValue(changeJson("name"), TvSeriesChanges.class);

        assertChange(changes.changes().get(0), "name");
        assertTrue(new TvSeriesChanges(null).changes().isEmpty());
    }

    @Test
    void mapsTvSeasonChanges() throws Exception {
        TvSeasonChanges changes = objectMapper.readValue(changeJson("overview"), TvSeasonChanges.class);

        assertChange(changes.changes().get(0), "overview");
        assertTrue(new TvSeasonChanges(null).changes().isEmpty());
    }

    @Test
    void mapsTvEpisodeChanges() throws Exception {
        TvEpisodeChanges changes = objectMapper.readValue(changeJson("runtime"), TvEpisodeChanges.class);

        assertChange(changes.changes().get(0), "runtime");
        assertTrue(new TvEpisodeChanges(null).changes().isEmpty());
    }

    @Test
    void mapsPersonChangesWithoutOriginalValue() throws Exception {
        PersonChanges changes = objectMapper.readValue("""
                {
                  "changes": [
                    {
                      "key": "biography",
                      "items": [
                        {
                          "id": "change-2",
                          "action": "added",
                          "time": "2024-01-02 12:00:00 UTC",
                          "iso_639_1": "de",
                          "iso_3166_1": "DE",
                          "value": "Neue Biografie"
                        }
                      ]
                    }
                  ]
                }
                """, PersonChanges.class);

        Change change = changes.changes().get(0);
        ChangeItem item = change.items().get(0);

        assertEquals("biography", change.key());
        assertEquals("change-2", item.id());
        assertEquals("added", item.action());
        assertEquals("2024-01-02 12:00:00 UTC", item.time());
        assertEquals("de", item.iso6391());
        assertEquals("DE", item.iso31661());
        assertEquals("Neue Biografie", item.value());
        assertNull(item.originalValue());
        assertTrue(new PersonChanges(null).changes().isEmpty());
    }

    @Test
    void normalizesMissingAndNullItems() throws Exception {
        MovieChanges missingItems = objectMapper.readValue("""
                {
                  "changes": [
                    { "key": "title" }
                  ]
                }
                """, MovieChanges.class);
        MovieChanges nullItems = objectMapper.readValue("""
                {
                  "changes": [
                    { "key": "title", "items": null }
                  ]
                }
                """, MovieChanges.class);

        assertTrue(missingItems.changes().get(0).items().isEmpty());
        assertTrue(nullItems.changes().get(0).items().isEmpty());
    }

    private static String changeJson(String key) {
        return """
                {
                  "changes": [
                    {
                      "key": "%s",
                      "items": [
                        {
                          "id": "change-1",
                          "action": "updated",
                          "time": "2024-01-01 12:00:00 UTC",
                          "iso_639_1": "en",
                          "iso_3166_1": "US",
                          "value": {
                            "text": "New value"
                          },
                          "original_value": {
                            "text": "Old value"
                          }
                        }
                      ]
                    }
                  ]
                }
                """.formatted(key);
    }

    @SuppressWarnings("unchecked")
    private static void assertChange(Change change, String key) {
        ChangeItem item = change.items().get(0);

        assertEquals(key, change.key());
        assertEquals(1, change.items().size());
        assertEquals("change-1", item.id());
        assertEquals("updated", item.action());
        assertEquals("2024-01-01 12:00:00 UTC", item.time());
        assertEquals("en", item.iso6391());
        assertEquals("US", item.iso31661());
        assertEquals("New value", ((Map<String, Object>) item.value()).get("text"));
        assertEquals("Old value", ((Map<String, Object>) item.originalValue()).get("text"));
    }
}
