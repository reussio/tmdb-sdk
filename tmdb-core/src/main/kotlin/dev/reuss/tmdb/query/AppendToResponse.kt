package dev.reuss.tmdb.query

import java.io.Serializable

/**
 * Models TMDB's `append_to_response` query parameter.
 *
 * Use this value with endpoints that support appended responses. Values are
 * serialized as a comma-separated list, duplicate append values are removed
 * while preserving their first occurrence, and at most 20 unique values are
 * allowed.
 *
 * ```kotlin
 * val append = AppendToResponse.of(
 *     MovieAppend.CREDITS,
 *     MovieAppend.VIDEOS
 * )
 * ```
 *
 * @property values appendable responses to request
 */
class AppendToResponse<T : AppendableResponse> private constructor(
    val values: List<T>
) : Serializable {

    override fun toString(): String =
        values.joinToString(",") { it.value }

    companion object {
        private const val MAX_VALUES = 20

        /**
         * Creates an append-to-response value from one or more appendable responses.
         */
        @JvmStatic
        fun <T : AppendableResponse> of(
            vararg values: T
        ): AppendToResponse<T> {
            require(values.isNotEmpty()) {
                "Append to response values must not be empty"
            }

            val uniqueValues = LinkedHashMap<String, T>()

            values.forEach { value ->
                uniqueValues.putIfAbsent(value.value, value)
            }

            require(uniqueValues.size <= MAX_VALUES) {
                "Append to response supports at most $MAX_VALUES values"
            }

            return AppendToResponse(
                java.util.List.copyOf(uniqueValues.values)
            )
        }
    }
}