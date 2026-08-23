package dev.reuss.tmdb.query

import dev.reuss.tmdb.core.http.QueryParams
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Query parameters for TMDB change endpoints.
 *
 * The start and end date filters are optional. If both are set, the start
 * date must not be after the end date and the range must not exceed 14 days.
 */
class ChangesQuery private constructor() : PagedQuery<ChangesQuery> {
    private var endDate: LocalDate? = null
    private var page: Int? = null
    private var startDate: LocalDate? = null

    /**
     * Sets the inclusive end date filter.
     */
    fun endDate(endDate: LocalDate?): ChangesQuery =
        apply {
            this.endDate = endDate
            validateDateRange()
        }

    override fun page(page: Int?): ChangesQuery =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

    /**
     * Sets the inclusive start date filter.
     */
    fun startDate(startDate: LocalDate?): ChangesQuery =
        apply {
            this.startDate = startDate
            validateDateRange()
        }

    /**
     * Converts this query to TMDB query parameters.
     */
    override fun toQueryParams(): QueryParams =
        QueryParams
            .create()
            .add("end_date", endDate)
            .add("page", page)
            .add("start_date", startDate)

    private fun validateDateRange() {
        val startDate = startDate ?: return
        val endDate = endDate ?: return

        require(!startDate.isAfter(endDate)) {
            "Start date must not be after end date"
        }

        val days = ChronoUnit.DAYS.between(startDate, endDate)

        require(days <= MAX_DATE_RANGE_DAYS) {
            "Changes date range must not exceed $MAX_DATE_RANGE_DAYS days"
        }
    }

    companion object {
        private const val MAX_DATE_RANGE_DAYS = 14L

        @JvmStatic
        fun create(): ChangesQuery = ChangesQuery()
    }
}
