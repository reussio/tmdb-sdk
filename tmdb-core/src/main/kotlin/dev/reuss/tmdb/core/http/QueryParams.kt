package dev.reuss.tmdb.core.http

/**
 * Mutable builder for TMDB query parameters.
 *
 * This class is used to collect request query parameters before creating
 * a [TmdbRequest]. Parameters with `null` or blank values are ignored, which
 * makes it convenient to add optional request settings such as language,
 * region or page.
 *
 * The insertion order is preserved while building the parameters. The map
 * returned by [toMap] is an immutable copy.
 */
class QueryParams private constructor() {

    private val values = linkedMapOf<String, String>()

    /**
     * Adds a query parameter if the given value is not `null` or blank.
     */
    fun add(
        name: String,
        value: String?
    ): QueryParams = apply {
        require(name.isNotBlank()) {
            "Query parameter name must not be blank"
        }

        if (!value.isNullOrBlank()) {
            values[name] = value
        }
    }

    /**
     * Adds a query parameter if the given value is not `null`.
     *
     * The value is converted using [Any.toString].
     */
    fun add(
        name: String,
        value: Any?
    ): QueryParams {
        if (value == null) {
            return this
        }

        return add(name, value.toString())
    }

    /**
     * Returns the collected query parameters as an immutable map.
     */
    fun toMap(): Map<String, String> = values.toMap()

    companion object {

        /**
         * Creates an empty query parameter builder.
         */
        @JvmStatic
        fun create(): QueryParams = QueryParams()
    }
}