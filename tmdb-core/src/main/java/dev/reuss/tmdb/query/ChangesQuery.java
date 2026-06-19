package dev.reuss.tmdb.query;

import dev.reuss.tmdb.core.http.QueryParams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Query parameters for TMDB change endpoints.
 */
public final class ChangesQuery implements PagedQuery<ChangesQuery> {

    private LocalDate endDate;
    private Integer page;
    private LocalDate startDate;

    private ChangesQuery() {
    }

    public static ChangesQuery create() {
        return new ChangesQuery();
    }

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

    public ChangesQuery startDate(LocalDate startDate) {
        this.startDate = startDate;
        validateDateRange();
        return this;
    }

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