package dev.reuss.tmdb.domain.tv.episode;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvEpisodeImages;
import dev.reuss.tmdb.domain.tv.episode.model.*;
import dev.reuss.tmdb.domain.tv.episode.query.TvEpisodeVideosQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.TvEpisodeId;
import dev.reuss.tmdb.value.id.TvEpisodeNumber;
import dev.reuss.tmdb.value.id.TvSeasonNumber;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;

public interface TvEpisodeService {

    TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    );

    TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language
    );

    TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            AppendToResponse<TvEpisodeAppend> appendToResponse
    );

    TvEpisodeDetails details(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language,
            AppendToResponse<TvEpisodeAppend> appendToResponse
    );

    /**
     * Loads recent changes for a TV episode.
     *
     * @param episodeId the TV episode id
     * @return TV episode changes
     */
    TvEpisodeChanges changes(TvEpisodeId episodeId);

    /**
     * Loads credits for a TV episode.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @return TV episode credits
     */
    TvEpisodeCredits credits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    );

    /**
     * Loads credits for a TV episode using a specific language.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @param language      response language
     * @return localized TV episode credits
     */
    TvEpisodeCredits credits(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language
    );

    /**
     * Loads external IDs for a TV episode.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @return TV episode external IDs
     */
    ExternalIds externalIds(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    );

    /**
     * Loads translations for a TV episode.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @return TV episode translations
     */
    TvEpisodeTranslations translations(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    );

    /**
     * Loads videos for a TV episode.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @return TV episode videos
     */
    TvEpisodeVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber
    );

    /**
     * Loads videos for a TV episode using a specific language.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @param language      response language
     * @return localized TV episode videos
     */
    TvEpisodeVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            Language language
    );

    /**
     * Loads videos for a TV episode using query parameters.
     *
     * @param seriesId      the TV series id
     * @param seasonNumber  the season number
     * @param episodeNumber the episode number
     * @param query         videos query
     * @return TV episode videos
     */
    TvEpisodeVideos videos(
            TvShowId seriesId,
            TvSeasonNumber seasonNumber,
            TvEpisodeNumber episodeNumber,
            TvEpisodeVideosQuery query
    );

    TvEpisodeImages images(TvShowId tvShowId, int seasonNumber, int episodeNumber);

    TvEpisodeImages images(TvShowId tvShowId, int seasonNumber, int episodeNumber, ImageQuery query);

}
