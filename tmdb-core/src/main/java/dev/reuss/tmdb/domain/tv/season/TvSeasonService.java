package dev.reuss.tmdb.domain.tv.season;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvSeasonImages;
import dev.reuss.tmdb.domain.tv.season.model.*;
import dev.reuss.tmdb.domain.tv.season.query.TvSeasonVideosQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.TvSeasonId;
import dev.reuss.tmdb.value.id.TvSeasonNumber;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for TMDB TV season endpoints.
 */
public interface TvSeasonService {

    /**
     * Loads details for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season details
     */
    TvSeasonDetails details(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads details for a TV season using a specific language.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @param language     response language
     * @return localized TV season details
     */
    TvSeasonDetails details(TvShowId seriesId, TvSeasonNumber seasonNumber, Language language);

    /**
     * Loads details for a TV season with appended responses.
     *
     * @param seriesId         the TV series id
     * @param seasonNumber     the season number
     * @param appendToResponse appended responses
     * @return TV season details with appended responses
     */
    TvSeasonDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            AppendToResponse<TvSeasonAppend> appendToResponse
    );

    /**
     * Loads details for a TV season using a specific language and appended responses.
     *
     * @param seriesId         the TV series id
     * @param seasonNumber     the season number
     * @param language         response language
     * @param appendToResponse appended responses
     * @return localized TV season details with appended responses
     */
    TvSeasonDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language,
            AppendToResponse<TvSeasonAppend> appendToResponse
    );

    /**
     * Loads aggregate credits for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season aggregate credits
     */
    TvSeasonAggregateCredits aggregateCredits(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads aggregate credits for a TV season using a specific language.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @param language     response language
     * @return localized TV season aggregate credits
     */
    TvSeasonAggregateCredits aggregateCredits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language
    );

    /**
     * Loads recent changes for a TV season.
     *
     * @param seasonId the TV season id
     * @return TV season changes
     */
    TvSeasonChanges changes(TvSeasonId seasonId);

    /**
     * Loads changes for a TV season using query parameters.
     *
     * @param seasonId the TV season id
     * @param query    changes query
     * @return TV season changes
     */
    TvSeasonChanges changes(TvSeasonId seasonId, ChangesQuery query);

    /**
     * Loads credits for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season credits
     */
    TvSeasonCredits credits(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads credits for a TV season using a specific language.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @param language     response language
     * @return localized TV season credits
     */
    TvSeasonCredits credits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language
    );

    /**
     * Loads external IDs for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season external IDs
     */
    ExternalIds externalIds(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads translations for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season translations
     */
    TvSeasonTranslations translations(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads videos for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season videos
     */
    TvSeasonVideos videos(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads videos for a TV season using a specific language.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @param language     response language
     * @return localized TV season videos
     */
    TvSeasonVideos videos(TvShowId seriesId, TvSeasonNumber seasonNumber, Language language);

    /**
     * Loads videos for a TV season using query parameters.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @param query        videos query
     * @return TV season videos
     */
    TvSeasonVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvSeasonVideosQuery query
    );

    /**
     * Loads watch provider availabilities for a TV season.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @return TV season watch providers
     */
    TvSeasonWatchProviders watchProviders(TvShowId seriesId, TvSeasonNumber seasonNumber);

    /**
     * Loads watch provider availabilities for a TV season using a specific language.
     *
     * @param seriesId     the TV series id
     * @param seasonNumber the season number
     * @param language     response language
     * @return localized TV season watch providers
     */
    TvSeasonWatchProviders watchProviders(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            Language language
    );

    /**
     * Loads images for a TV season.
     *
     * @param tvShowId TMDB TV series id
     * @param seasonNumber season number
     * @return TV season images
     */
    TvSeasonImages images(TvShowId tvShowId, int seasonNumber);

    /**
     * Loads images for a TV season using query parameters.
     *
     * @param tvShowId TMDB TV series id
     * @param seasonNumber season number
     * @param query image query
     * @return TV season images
     */
    TvSeasonImages images(TvShowId tvShowId, int seasonNumber, ImageQuery query);

}
