package dev.reuss.tmdb.common;

import java.io.Serializable;

/**
 * Marker interface for SDK response and model value types.
 *
 * <p>This marks SDK models as Java-serializable without promising binary
 * serialization compatibility across SDK versions.</p>
 */
public interface TmdbModel extends Serializable {
}
