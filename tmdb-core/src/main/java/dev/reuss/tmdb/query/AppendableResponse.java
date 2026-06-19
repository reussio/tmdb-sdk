package dev.reuss.tmdb.query;

import java.io.Serializable;

/**
 * Common contract for TMDB {@code append_to_response} values.
 *
 * <p>Implementations are intended for endpoint groups that support appended
 * responses and expose both the raw TMDB query value and the expected response
 * model type.</p>
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
