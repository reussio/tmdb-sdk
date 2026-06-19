package dev.reuss.tmdb.util;

import java.util.List;
import java.util.Map;

/**
 * Utility methods for normalizing collection values returned by TMDB.
 */
public final class TmdbCollections {

    private TmdbCollections() {
    }

    public static <T> List<T> list(List<T> values) {
        return values == null ? List.of() : List.copyOf(values);
    }

    public static <K, V> Map<K, V> map(Map<K, V> values) {
        return values == null ? Map.of() : Map.copyOf(values);
    }
}
