package dev.reuss.tmdb.common.page;

import java.util.List;
import java.util.OptionalInt;

/**
 * Common contract for paginated TMDB responses.
 *
 * @param <T> result item type
 */
public interface PagedResponse<T> {

    int page();

    List<T> results();

    int totalPages();

    int totalResults();

    default boolean hasNextPage() {
        return page() < totalPages();
    }

    default boolean hasPreviousPage() {
        return page() > 1;
    }

    default boolean isFirstPage() {
        return page() <= 1;
    }

    default boolean isLastPage() {
        return page() >= totalPages();
    }

    default boolean isEmpty() {
        return resultCount() == 0;
    }

    default boolean hasResults() {
        return !isEmpty();
    }

    default int resultCount() {
        return results().size();
    }

    default int nextPage() {
        if (!hasNextPage()) {
            throw new IllegalStateException("There is no next page");
        }

        return page() + 1;
    }

    default int previousPage() {
        if (!hasPreviousPage()) {
            throw new IllegalStateException("There is no previous page");
        }

        return page() - 1;
    }

    default OptionalInt nextPageNumber() {
        return hasNextPage()
                ? OptionalInt.of(page() + 1)
                : OptionalInt.empty();
    }

    default OptionalInt previousPageNumber() {
        return hasPreviousPage()
                ? OptionalInt.of(page() - 1)
                : OptionalInt.empty();
    }
}
