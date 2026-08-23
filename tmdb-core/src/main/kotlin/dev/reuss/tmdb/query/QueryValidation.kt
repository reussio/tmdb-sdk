package dev.reuss.tmdb.query

/**
 * Shared validation rules applied by public TMDB query builders.
 */
object QueryValidation {
    /**
     * Trims [value] after requiring non-blank text.
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
     * Accepts an absent or positive one-based page number.
     */
    @JvmStatic
    fun validatePage(page: Int?) {
        require(page == null || page > 0) {
            "Page must be greater than 0"
        }
    }

    /**
     * Accepts an absent year or a value from `1000` through `9999`.
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
     * Applies the four-digit year range to a string value.
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
