package dev.reuss.tmdb.core.http

import java.util.Collections

/**
 * Insertion-ordered builder for TMDB query parameters.
 *
 * This class is used to collect request query parameters before creating
 * a [TmdbRequest]. Parameters with `null` or blank values are ignored, which
 * makes it convenient to add optional request settings such as language,
 * region or page.
 *
 * Adding the same name again replaces its value without changing its position.
 * [toMap] returns an immutable snapshot, so later additions do not affect an
 * already created map.
 */
class QueryParams private constructor() {
    private val values = linkedMapOf<String, String>()

    /**
     * Adds or replaces a parameter when [value] is neither `null` nor blank.
     *
     * @throws IllegalArgumentException if [name] is blank, even when [value] is absent
     */
    fun add(
        name: String,
        value: String?,
    ): QueryParams =
        apply {
            require(name.isNotBlank()) {
                "Query parameter name must not be blank"
            }

            if (!value.isNullOrBlank()) {
                values[name] = value
            }
        }

    /**
     * Adds or replaces a parameter when [value] is not `null`.
     *
     * The value is converted using [Any.toString].
     */
    fun add(
        name: String,
        value: Any?,
    ): QueryParams {
        if (value == null) {
            return this
        }

        return add(name, value.toString())
    }

    /**
     * Creates an immutable snapshot of the current parameters.
     */
    fun toMap(): Map<String, String> = Collections.unmodifiableMap(LinkedHashMap(values))

    companion object {
        /** Creates an empty parameter builder. */
        @JvmStatic
        fun create(): QueryParams = QueryParams()
    }
}
