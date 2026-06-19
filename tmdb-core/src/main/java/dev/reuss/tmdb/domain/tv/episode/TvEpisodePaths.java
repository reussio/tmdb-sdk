package dev.reuss.tmdb.domain.tv.episode;

import dev.reuss.tmdb.value.id.TvEpisodeId;
import dev.reuss.tmdb.value.id.TvShowId;

final class TvEpisodePaths {

    private static final String TV = "/tv";

    private TvEpisodePaths() {
    }

    static String details(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber);
    }

    static String changes(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber) + "/changes";
    }

    static String changes(TvEpisodeId episodeId) {
        return TV + "/episode/" + episodeId.asString() + "/changes";
    }

    static String credits(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber) + "/credits";
    }

    static String externalIds(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber) + "/external_ids";
    }

    static String images(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber) + "/images";
    }

    static String translations(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber) + "/translations";
    }

    static String videos(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return episode(tvShowId, seasonNumber, episodeNumber) + "/videos";
    }

    private static String episode(TvShowId tvShowId, int seasonNumber, int episodeNumber) {
        return TV + "/" + tvShowId.asString()
                + "/season/" + seasonNumber
                + "/episode/" + episodeNumber;
    }
}
