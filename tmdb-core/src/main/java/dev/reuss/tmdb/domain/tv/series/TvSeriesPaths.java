package dev.reuss.tmdb.domain.tv.series;

import dev.reuss.tmdb.value.id.TvShowId;

final class TvSeriesPaths {

    private static final String TV = "/tv";

    private TvSeriesPaths() {
    }

    static String details(TvShowId tvShowId) {
        return tv(tvShowId);
    }

    static String aggregateCredits(TvShowId tvShowId) {
        return tv(tvShowId) + "/aggregate_credits";
    }

    static String alternativeTitles(TvShowId tvShowId) {
        return tv(tvShowId) + "/alternative_titles";
    }

    static String changes(TvShowId tvShowId) {
        return tv(tvShowId) + "/changes";
    }

    static String contentRatings(TvShowId tvShowId) {
        return tv(tvShowId) + "/content_ratings";
    }

    static String credits(TvShowId tvShowId) {
        return tv(tvShowId) + "/credits";
    }

    static String episodeGroups(TvShowId tvShowId) {
        return tv(tvShowId) + "/episode_groups";
    }

    static String externalIds(TvShowId tvShowId) {
        return tv(tvShowId) + "/external_ids";
    }

    static String images(TvShowId tvShowId) {
        return tv(tvShowId) + "/images";
    }

    static String keywords(TvShowId tvShowId) {
        return tv(tvShowId) + "/keywords";
    }

    static String recommendations(TvShowId tvShowId) {
        return tv(tvShowId) + "/recommendations";
    }

    static String reviews(TvShowId tvShowId) {
        return tv(tvShowId) + "/reviews";
    }

    static String screenedTheatrically(TvShowId tvShowId) {
        return tv(tvShowId) + "/screened_theatrically";
    }

    static String similar(TvShowId tvShowId) {
        return tv(tvShowId) + "/similar";
    }

    static String translations(TvShowId tvShowId) {
        return tv(tvShowId) + "/translations";
    }

    static String videos(TvShowId tvShowId) {
        return tv(tvShowId) + "/videos";
    }

    static String watchProviders(TvShowId tvShowId) {
        return tv(tvShowId) + "/watch/providers";
    }

    static String airingToday() {
        return TV + "/airing_today";
    }

    static String latest() {
        return TV + "/latest";
    }

    static String onTheAir() {
        return TV + "/on_the_air";
    }

    static String popular() {
        return TV + "/popular";
    }

    static String topRated() {
        return TV + "/top_rated";
    }

    private static String tv(TvShowId tvShowId) {
        return TV + "/" + tvShowId.asString();
    }
}