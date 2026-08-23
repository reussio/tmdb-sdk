package dev.reuss.tmdb.query

import dev.reuss.tmdb.core.http.QueryParams
import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Query parameters for TMDB change endpoints.
 *
 * The date bounds are inclusive and optional. When both are set, the start
 * cannot follow the end and the elapsed range cannot exceed 14 days. Page
 * numbers are one-based.
 */
class ChangesQuery private constructor() : PagedQuery<ChangesQuery> {
    private var endDate: LocalDate? = null
    private var page: Int? = null
    private var startDate: LocalDate? = null

    /**
     * Sets or clears the inclusive end date.
     *
     * @throws IllegalArgumentException if the completed date range is reversed
     * or exceeds 14 days
     */
    fun endDate(endDate: LocalDate?): ChangesQuery =
        apply {
            this.endDate = endDate
            validateDateRange()
        }

    /** Sets or clears the one-based result page. */
    override fun page(page: Int?): ChangesQuery =
        apply {
            QueryValidation.validatePage(page)
            this.page = page
        }

    /**
     * Sets or clears the inclusive start date.
     *
     * @throws IllegalArgumentException if the completed date range is reversed
     * or exceeds 14 days
     */
    fun startDate(startDate: LocalDate?): ChangesQuery =
        apply {
            this.startDate = startDate
            validateDateRange()
        }

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

        /** Creates an empty changes query. */
        @JvmStatic
        fun create(): ChangesQuery = ChangesQuery()
    }
}
