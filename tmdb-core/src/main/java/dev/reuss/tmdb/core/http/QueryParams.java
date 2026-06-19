package dev.reuss.tmdb.core.http;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Mutable builder for TMDB query parameters.
 *
 * <p>This class is used to collect request query parameters before creating
 * a {@link TmdbRequest}. Parameters with {@code null} or blank values are
 * ignored, which makes it convenient to add optional request settings such
 * as language, region or page.</p>
 *
 * <p>The insertion order is preserved while building the parameters. The map
 * returned by {@link #toMap()} is an immutable copy.</p>
 */
public final class QueryParams {

    private final Map<String, String> values = new LinkedHashMap<>();

    private QueryParams() {
    }

    /**
     * Creates an empty query parameter builder.
     *
     * @return a new query parameter builder
     */
    public static QueryParams create() {
        return new QueryParams();
    }

    /**
     * Adds a query parameter if the given value is not {@code null} or blank.
     *
     * @param name  the query parameter name
     * @param value the query parameter value
     * @return this builder
     * @throws IllegalArgumentException if the parameter name is {@code null}, blank or empty
     */
    public QueryParams add(String name, String value) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Query parameter name must not be blank");
        }

        if (value != null && !value.isBlank()) {
            values.put(name, value);
        }

        return this;
    }

    /**
     * Adds a query parameter if the given value is not {@code null}.
     *
     * <p>The value is converted using {@link Object#toString()}.</p>
     *
     * @param name  the query parameter name
     * @param value the query parameter value
     * @return this builder
     * @throws IllegalArgumentException if the parameter name is {@code null}, blank or empty
     */
    public QueryParams add(String name, Object value) {
        if (value == null) {
            return this;
        }

        return add(name, value.toString());
    }

    /**
     * Returns the collected query parameters as an immutable map.
     *
     * @return an immutable copy of the collected query parameters
     */
    public Map<String, String> toMap() {
        return Map.copyOf(values);
    }
}