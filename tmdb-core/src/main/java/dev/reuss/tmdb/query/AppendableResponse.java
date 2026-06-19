package dev.reuss.tmdb.query;

import java.io.Serializable;

/**
 * Common contract for append_to_response values.
 */
public interface AppendableResponse extends Serializable {

    /**
     * TMDB append_to_response query value.
     *
     * @return append value
     */
    String value();

    /**
     * Response model type for this appended response.
     *
     * @return response type
     */
    Class<?> responseType();
}
