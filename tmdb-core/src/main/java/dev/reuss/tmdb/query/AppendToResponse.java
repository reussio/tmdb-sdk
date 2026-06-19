package dev.reuss.tmdb.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Models TMDB's {@code append_to_response} query parameter.
 *
 * <p>Use this value with endpoints that support appended responses. Values are
 * serialized as a comma-separated list, duplicate append values are removed
 * while preserving their first occurrence, and at most 20 unique values are
 * allowed.</p>
 *
 * <pre>{@code
 * AppendToResponse<MovieAppend> append =
 *         AppendToResponse.of(MovieAppend.CREDITS, MovieAppend.VIDEOS);
 * }</pre>
 *
 * @param <T> appendable response type
 * @param values appendable responses to request
 */
public record AppendToResponse<T extends AppendableResponse>(
        List<T> values
) implements Serializable {

    private static final int MAX_VALUES = 20;

    public AppendToResponse {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Append to response values must not be empty");
        }

        LinkedHashMap<String, T> uniqueValues = new LinkedHashMap<>();

        for (T value : values) {
            if (value == null) {
                throw new IllegalArgumentException("Append to response values must not contain null");
            }

            uniqueValues.putIfAbsent(value.value(), value);
        }

        if (uniqueValues.size() > MAX_VALUES) {
            throw new IllegalArgumentException("Append to response supports at most 20 values");
        }

        values = List.copyOf(uniqueValues.values());
    }

    /**
     * Creates an append-to-response value from one or more appendable responses.
     *
     * @param values appendable responses to request
     * @return append-to-response query value
     * @param <T> appendable response type
     * @throws IllegalArgumentException if {@code values} is {@code null}, empty,
     *                                  contains {@code null}, or contains more
     *                                  than 20 unique append values
     */
    @SafeVarargs
    public static <T extends AppendableResponse> AppendToResponse<T> of(T... values) {
        if (values == null) {
            throw new IllegalArgumentException("Append to response values must not be null");
        }

        return new AppendToResponse<>(Arrays.asList(values));
    }

    @Override
    public String toString() {
        return values.stream()
                .map(AppendableResponse::value)
                .collect(Collectors.joining(","));
    }
}
