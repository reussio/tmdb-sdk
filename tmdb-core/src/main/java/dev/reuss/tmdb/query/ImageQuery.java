package dev.reuss.tmdb.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Query parameters for TMDB image requests.
 *
 * @param language             optional language filter
 * @param includeImageLanguage optional comma-separated image language filter
 */
public record ImageQuery(
        Language language,
        String includeImageLanguage
) implements TmdbQuery {

    public static ImageQuery none() {
        return new ImageQuery(null, null);
    }

    public static ImageQuery language(Language language) {
        return new ImageQuery(Objects.requireNonNull(language, "Language must not be null"), null);
    }

    public static ImageQuery includeImageLanguage(String includeImageLanguage) {
        return new ImageQuery(null, includeImageLanguage);
    }

    public ImageQuery {
        if (includeImageLanguage != null && includeImageLanguage.isBlank()) {
            throw new IllegalArgumentException("Include image language must not be blank");
        }
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language)
                .add("include_image_language", includeImageLanguage);
    }
}