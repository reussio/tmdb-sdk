package dev.reuss.tmdb.domain.tv.season;

import dev.reuss.tmdb.value.id.TvSeasonId;
import dev.reuss.tmdb.value.id.TvShowId;

final class TvSeasonPaths {

    private static final String TV = "/tv";

    private TvSeasonPaths() {
    }

    static String details(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber);
    }

    static String aggregateCredits(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/aggregate_credits";
    }

    static String changes(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/changes";
    }

    static String changes(TvSeasonId seasonId) {
        return TV + "/season/" + seasonId.asString() + "/changes";
    }

    static String credits(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/credits";
    }

    static String externalIds(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/external_ids";
    }

    static String images(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/images";
    }

    static String translations(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/translations";
    }

    static String videos(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/videos";
    }

    static String watchProviders(TvShowId tvShowId, int seasonNumber) {
        return season(tvShowId, seasonNumber) + "/watch/providers";
    }

    private static String season(TvShowId tvShowId, int seasonNumber) {
        return TV + "/" + tvShowId.asString() + "/season/" + seasonNumber;
    }
}
