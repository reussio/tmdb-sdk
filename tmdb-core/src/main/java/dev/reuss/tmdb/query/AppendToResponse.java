package dev.reuss.tmdb.query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents TMDB append_to_response query values.
 *
 * @param <T> appendable response type
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
