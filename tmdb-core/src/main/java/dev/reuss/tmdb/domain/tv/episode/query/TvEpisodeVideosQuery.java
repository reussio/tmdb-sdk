package dev.reuss.tmdb.domain.tv.episode.query;

import dev.reuss.tmdb.core.http.QueryParams;
import dev.reuss.tmdb.query.TmdbQuery;
import dev.reuss.tmdb.value.language.Language;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Query parameters for TV episode videos.
 *
 * <p>Both language and included video languages are optional. Included video
 * languages are serialized as a comma-separated {@code include_video_language}
 * value.</p>
 */
public final class TvEpisodeVideosQuery implements TmdbQuery {

    private Language language;
    private List<Language> includeVideoLanguage;

    private TvEpisodeVideosQuery() {
    }

    public static TvEpisodeVideosQuery create() {
        return new TvEpisodeVideosQuery();
    }

    public TvEpisodeVideosQuery language(Language language) {
        this.language = language;
        return this;
    }

    public TvEpisodeVideosQuery includeVideoLanguage(List<Language> includeVideoLanguage) {
        this.includeVideoLanguage = includeVideoLanguage == null
                ? null
                : List.copyOf(includeVideoLanguage);
        return this;
    }

    public TvEpisodeVideosQuery includeVideoLanguage(Language... includeVideoLanguage) {
        if (includeVideoLanguage == null) {
            this.includeVideoLanguage = null;
            return this;
        }

        this.includeVideoLanguage = Arrays.asList(includeVideoLanguage);
        return this;
    }

    @Override
    public QueryParams toQueryParams() {
        return QueryParams.create()
                .add("language", language)
                .add("include_video_language", includeVideoLanguageValue());
    }

    private String includeVideoLanguageValue() {
        if (includeVideoLanguage == null || includeVideoLanguage.isEmpty()) {
            return null;
        }

        return includeVideoLanguage.stream()
                .map(Language::toString)
                .collect(Collectors.joining(","));
    }
}
