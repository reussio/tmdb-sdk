package dev.reuss.tmdb.query;

import dev.reuss.tmdb.core.http.QueryParams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Query parameters for TMDB change endpoints.
 *
 * <p>The start and end date filters are optional. If both are set, the start
 * date must not be after the end date and the range must not exceed 14 days.</p>
 */
public final class ChangesQuery implements PagedQuery<ChangesQuery> {

    private LocalDate endDate;
    private Integer page;
    private LocalDate startDate;

    private ChangesQuery() {
    }

    /**
     * Creates an empty changes query.
     *
     * @return changes query
     */
    public static ChangesQuery create() {
        return new ChangesQuery();
    }

    /**
     * Sets the inclusive end date filter.
     *
     * @param endDate inclusive end date, or {@code null}
     * @return this query
     * @throws IllegalArgumentException if the configured date range is invalid
     */
    public ChangesQuery endDate(LocalDate endDate) {
        this.endDate = endDate;
        validateDateRange();
        return this;
    }

    @Override
    public ChangesQuery page(Integer page) {
        QueryValidation.validatePage(page);
        this.page = page;
        return this;
    }

    /**
     * Sets the inclusive start date filter.
     *
     * @param startDate inclusive start date, or {@code null}
     * @return this query
     * @throws IllegalArgumentException if the configured date range is invalid
     */
    public ChangesQuery startDate(LocalDate startDate) {
        this.startDate = startDate;
        validateDateRange();
        return this;
    }

    /**
     * Converts this query to TMDB query parameters.
     *
     * @return query parameters
     */
    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("end_date", endDate)
                .add("page", page)
                .add("start_date", startDate);
    }

    private void validateDateRange() {
        if (startDate == null || endDate == null) {
            return;
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must not be after end date");
        }

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        if (days > 14) {
            throw new IllegalArgumentException("Changes date range must not exceed 14 days");
        }
    }
}
