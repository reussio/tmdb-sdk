package dev.reuss.tmdb.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Query parameters for TMDB image requests.
 *
 * <p>Both filters are optional. A blank {@code includeImageLanguage} value is
 * rejected. Values are serialized as {@code language} and
 * {@code include_image_language} query parameters.</p>
 *
 * @param language             optional language filter
 * @param includeImageLanguage optional comma-separated image language filter
 */
public record ImageQuery(
        Language language,
        String includeImageLanguage
) implements TmdbQuery {

    /**
     * Creates an image query without filters.
     *
     * @return empty image query
     */
    public static ImageQuery none() {
        return new ImageQuery(null, null);
    }

    /**
     * Creates an image query for a single response language.
     *
     * @param language response language
     * @return image query
     * @throws NullPointerException if {@code language} is {@code null}
     */
    public static ImageQuery language(Language language) {
        return new ImageQuery(Objects.requireNonNull(language, "Language must not be null"), null);
    }

    /**
     * Creates an image query using TMDB's image-language filter.
     *
     * @param includeImageLanguage comma-separated image language filter
     * @return image query
     * @throws IllegalArgumentException if {@code includeImageLanguage} is blank
     */
    public static ImageQuery includeImageLanguage(String includeImageLanguage) {
        return new ImageQuery(null, includeImageLanguage);
    }

    public ImageQuery {
        if (includeImageLanguage != null && includeImageLanguage.isBlank()) {
            throw new IllegalArgumentException("Include image language must not be blank");
        }
    }

    /**
     * Converts this query to TMDB query parameters.
     *
     * @return query parameters
     */
    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language)
                .add("include_image_language", includeImageLanguage);
    }
}
