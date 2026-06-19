package dev.reuss.tmdb.query;

/**
 * Validation helpers for TMDB query objects.
 */
public final class QueryValidation {

    private QueryValidation() {
    }

    /**
     * Requires a non-blank string value and returns it trimmed.
     *
     * @param value     value to validate
     * @param fieldName field name used in the exception message
     * @return trimmed value
     */
    public static String requireNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }

        return value.trim();
    }

    /**
     * Validates a TMDB page parameter.
     *
     * @param page page number, starting at 1
     */
    public static void validatePage(Integer page) {
        if (page != null && page <= 0) {
            throw new IllegalArgumentException("Page must be greater than 0");
        }
    }

    /**
     * Validates a year parameter.
     *
     * @param year      year value
     * @param fieldName field name used in the exception message
     */
    public static void validateYear(Integer year, String fieldName) {
        if (year != null && (year < 1000 || year > 9999)) {
            throw new IllegalArgumentException(fieldName + " must be between 1000 and 9999");
        }
    }

    /**
     * Validates a year parameter represented as a string.
     *
     * @param year      year value
     * @param fieldName field name used in the exception message
     */
    public static void validateYear(String year, String fieldName) {
        if (year == null || year.isBlank()) {
            return;
        }

        try {
            validateYear(Integer.parseInt(year), fieldName);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(fieldName + " must be a four-digit year", exception);
        }
    }
}
