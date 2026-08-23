package dev.reuss.tmdb.query

/**
 * Validation helpers for TMDB query objects.
 */
object QueryValidation {
    /**
     * Requires a non-blank string value and returns it trimmed.
     */
    @JvmStatic
    fun requireNotBlank(
        value: String?,
        fieldName: String,
    ): String {
        require(!value.isNullOrBlank()) {
            "$fieldName must not be blank"
        }

        return value.trim()
    }

    /**
     * Validates a TMDB page parameter.
     */
    @JvmStatic
    fun validatePage(page: Int?) {
        require(page == null || page > 0) {
            "Page must be greater than 0"
        }
    }

    /**
     * Validates a year parameter.
     */
    @JvmStatic
    fun validateYear(
        year: Int?,
        fieldName: String,
    ) {
        require(year == null || year in 1000..9999) {
            "$fieldName must be between 1000 and 9999"
        }
    }

    /**
     * Validates a year parameter represented as a string.
     */
    @JvmStatic
    fun validateYear(
        year: String?,
        fieldName: String,
    ) {
        if (year.isNullOrBlank()) {
            return
        }

        val parsedYear =
            year.toIntOrNull()
                ?: throw IllegalArgumentException(
                    "$fieldName must be a four-digit year",
                )

        validateYear(parsedYear, fieldName)
    }
}
