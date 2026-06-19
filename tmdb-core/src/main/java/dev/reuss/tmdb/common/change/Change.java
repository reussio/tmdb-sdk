package dev.reuss.tmdb.common.change;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Change group for a TMDB resource field.
 *
 * @param key   changed field key
 * @param items change items
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Change(
        String key,
        List<ChangeItem> items
) implements TmdbModel {

    public Change {
        items = TmdbCollections.list(items);
    }
}
