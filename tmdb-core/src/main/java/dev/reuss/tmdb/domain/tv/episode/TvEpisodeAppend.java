package dev.reuss.tmdb.domain.tv.episode;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvEpisodeImages;
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeChanges;
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeCredits;
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeTranslations;
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeVideos;
import dev.reuss.tmdb.query.AppendableResponse;

/**
 * TV episode responses that can be requested through TMDB's {@code append_to_response} parameter.
 */
public enum TvEpisodeAppend implements AppendableResponse {

    CHANGES("changes", TvEpisodeChanges.class),
    CREDITS("credits", TvEpisodeCredits.class),
    EXTERNAL_IDS("external_ids", ExternalIds.class),
    IMAGES("images", TvEpisodeImages.class),
    TRANSLATIONS("translations", TvEpisodeTranslations.class),
    VIDEOS("videos", TvEpisodeVideos.class);

    private final String value;
    private final Class<?> responseType;

    TvEpisodeAppend(String value, Class<?> responseType) {
        this.value = value;
        this.responseType = responseType;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public Class<?> responseType() {
        return responseType;
    }
}
