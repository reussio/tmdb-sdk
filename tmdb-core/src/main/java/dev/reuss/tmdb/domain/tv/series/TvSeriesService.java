package dev.reuss.tmdb.domain.tv.series;

import dev.reuss.tmdb.common.external.ExternalIds;
import dev.reuss.tmdb.common.image.TvShowImages;
import dev.reuss.tmdb.domain.tv.series.model.*;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesDateListQuery;
import dev.reuss.tmdb.domain.tv.series.query.TvSeriesListQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.query.ChangesQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.TvShowId;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for TMDB TV series list endpoints.
 */
public interface TvSeriesService {

    TvSeriesListResponse airingToday();

    TvSeriesListResponse airingToday(Language language);

    TvSeriesListResponse airingToday(TvSeriesDateListQuery query);

    TvSeriesListResponse onTheAir();

    TvSeriesListResponse onTheAir(Language language);

    TvSeriesListResponse onTheAir(TvSeriesDateListQuery query);

    TvSeriesListResponse popular();

    TvSeriesListResponse popular(Language language);

    TvSeriesListResponse popular(TvSeriesListQuery query);

    /**
     * Loads top rated TV shows.
     *
     * @return top rated TV series
     */
    TvSeriesListResponse topRated();

    /**
     * Loads top rated TV shows using a specific language.
     *
     * @param language response language
     * @return localized top rated TV series
     */
    TvSeriesListResponse topRated(Language language);

    /**
     * Loads top rated TV shows using query parameters.
     *
     * @param query list query
     * @return top rated TV series
     */
    TvSeriesListResponse topRated(TvSeriesListQuery query);

    /**
     * Loads TV series details.
     *
     * @param seriesId the TV series id
     * @return TV series details
     */
    TvSeriesDetails details(TvShowId seriesId);

    /**
     * Loads TV series details using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized TV series details
     */
    TvSeriesDetails details(TvShowId seriesId, Language language);

    /**
     * Loads TV series details with appended responses.
     *
     * @param seriesId         the TV series id
     * @param appendToResponse appended response sections
     * @return TV series details with appended responses
     */
    TvSeriesDetails details(TvShowId seriesId, AppendToResponse<TvSeriesAppend> appendToResponse);

    /**
     * Loads TV series details using a specific language and appended responses.
     *
     * @param seriesId         the TV series id
     * @param language         response language
     * @param appendToResponse appended response sections
     * @return localized TV series details with appended responses
     */
    TvSeriesDetails details(
            TvShowId seriesId,
            Language language,
            AppendToResponse<TvSeriesAppend> appendToResponse
    );

    /**
     * Loads aggregate credits for a TV series.
     *
     * @param seriesId the TV series id
     * @return aggregate TV series credits
     */
    TvSeriesAggregateCredits aggregateCredits(TvShowId seriesId);

    /**
     * Loads aggregate credits for a TV series using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized aggregate TV series credits
     */
    TvSeriesAggregateCredits aggregateCredits(TvShowId seriesId, Language language);

    /**
     * Loads alternative titles for a TV series.
     *
     * @param seriesId the TV series id
     * @return alternative TV series titles
     */
    TvSeriesAlternativeTitles alternativeTitles(TvShowId seriesId);

    /**
     * Loads recent changes for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series changes
     */
    TvSeriesChanges changes(TvShowId seriesId);

    /**
     * Loads recent changes for a TV series using query parameters.
     *
     * @param seriesId the TV series id
     * @param query    changes query
     * @return TV series changes
     */
    TvSeriesChanges changes(TvShowId seriesId, ChangesQuery query);

    /**
     * Loads content ratings for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series content ratings
     */
    TvSeriesContentRatings contentRatings(TvShowId seriesId);

    /**
     * Loads latest season credits for a TV series.
     *
     * @param seriesId the TV series id
     * @return latest season TV series credits
     */
    TvSeriesCredits credits(TvShowId seriesId);

    /**
     * Loads latest season credits for a TV series using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized latest season TV series credits
     */
    TvSeriesCredits credits(TvShowId seriesId, Language language);

    /**
     * Loads episode groups for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series episode groups
     */
    TvSeriesEpisodeGroups episodeGroups(TvShowId seriesId);

    /**
     * Loads external IDs for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series external IDs
     */
    ExternalIds externalIds(TvShowId seriesId);

    /**
     * Loads keywords for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series keywords
     */
    TvSeriesKeywords keywords(TvShowId seriesId);

    /**
     * Loads the latest TV series.
     *
     * @return latest TV series details
     */
    TvSeriesDetails latest();

    /**
     * Loads recommended TV series for a TV series.
     *
     * @param seriesId the TV series id
     * @return recommended TV series
     */
    TvSeriesRecommendations recommendations(TvShowId seriesId);

    /**
     * Loads recommended TV series for a TV series using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized recommended TV series
     */
    TvSeriesRecommendations recommendations(TvShowId seriesId, Language language);

    /**
     * Loads recommended TV series for a TV series using query parameters.
     *
     * @param seriesId the TV series id
     * @param query    list query
     * @return recommended TV series
     */
    TvSeriesRecommendations recommendations(TvShowId seriesId, TvSeriesListQuery query);

    /**
     * Loads reviews for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series reviews
     */
    TvSeriesReviews reviews(TvShowId seriesId);

    /**
     * Loads reviews for a TV series using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized TV series reviews
     */
    TvSeriesReviews reviews(TvShowId seriesId, Language language);

    /**
     * Loads reviews for a TV series using query parameters.
     *
     * @param seriesId the TV series id
     * @param query    list query
     * @return TV series reviews
     */
    TvSeriesReviews reviews(TvShowId seriesId, TvSeriesListQuery query);

    /**
     * Loads TV series episodes that have screened theatrically.
     *
     * @param seriesId the TV series id
     * @return theatrically screened TV episodes
     */
    TvSeriesScreenedTheatrically screenedTheatrically(TvShowId seriesId);

    /**
     * Loads similar TV series for a TV series.
     *
     * @param seriesId the TV series id
     * @return similar TV series
     */
    TvSeriesSimilar similar(TvShowId seriesId);

    /**
     * Loads similar TV series for a TV series using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized similar TV series
     */
    TvSeriesSimilar similar(TvShowId seriesId, Language language);

    /**
     * Loads similar TV series for a TV series using query parameters.
     *
     * @param seriesId the TV series id
     * @param query    list query
     * @return similar TV series
     */
    TvSeriesSimilar similar(TvShowId seriesId, TvSeriesListQuery query);

    /**
     * Loads translations for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series translations
     */
    TvSeriesTranslations translations(TvShowId seriesId);

    /**
     * Loads videos for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series videos
     */
    TvSeriesVideos videos(TvShowId seriesId);

    /**
     * Loads videos for a TV series using a specific language.
     *
     * @param seriesId the TV series id
     * @param language response language
     * @return localized TV series videos
     */
    TvSeriesVideos videos(TvShowId seriesId, Language language);

    /**
     * Loads videos for a TV series using query parameters.
     *
     * @param seriesId the TV series id
     * @param query    videos query
     * @return TV series videos
     */
    TvSeriesVideos videos(TvShowId seriesId, TvSeriesVideosQuery query);

    /**
     * Loads watch provider availabilities for a TV series.
     *
     * @param seriesId the TV series id
     * @return TV series watch providers
     */
    TvSeriesWatchProviders watchProviders(TvShowId seriesId);

    TvShowImages images(TvShowId tvShowId);

    TvShowImages images(TvShowId tvShowId, ImageQuery query);

}