package dev.reuss.tmdb.domain.collection;

import dev.reuss.tmdb.common.image.CollectionImages;
import dev.reuss.tmdb.domain.collection.model.CollectionDetails;
import dev.reuss.tmdb.domain.collection.model.CollectionTranslations;
import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.CollectionId;
import dev.reuss.tmdb.value.language.Language;

/**
 * Service for loading TMDB collection data.
 */
public interface CollectionService {

    /**
     * Loads collection details.
     *
     * @param collectionId collection id
     * @return collection details
     */
    CollectionDetails details(CollectionId collectionId);

    /**
     * Loads collection details using a specific language.
     *
     * @param collectionId collection id
     * @param language     response language
     * @return localized collection details
     */
    CollectionDetails details(CollectionId collectionId, Language language);

    /**
     * Loads collection details using explicit query parameters.
     *
     * @param collectionId collection id
     * @param query        details query
     * @return collection details
     */
    CollectionDetails details(CollectionId collectionId, CollectionDetailsQuery query);

    /**
     * Loads images for a collection.
     *
     * @param collectionId TMDB collection id
     * @return collection images
     */
    CollectionImages images(CollectionId collectionId);

    /**
     * Loads images for a collection using query parameters.
     *
     * @param collectionId TMDB collection id
     * @param query        image query
     * @return collection images
     */
    CollectionImages images(CollectionId collectionId, ImageQuery query);

    /**
     * Loads translations for a collection.
     *
     * @param collectionId the collection id
     * @return collection translations
     */
    CollectionTranslations translations(CollectionId collectionId);
}
