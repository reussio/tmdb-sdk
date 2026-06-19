package dev.reuss.tmdb.domain.collection;

import dev.reuss.tmdb.common.image.CollectionImages;
import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.collection.model.CollectionDetails;
import dev.reuss.tmdb.domain.collection.model.CollectionTranslations;
import dev.reuss.tmdb.domain.collection.query.CollectionDetailsQuery;
import dev.reuss.tmdb.query.ImageQuery;
import dev.reuss.tmdb.value.id.CollectionId;
import dev.reuss.tmdb.value.language.Language;

import java.util.Objects;

/**
 * Default collection service implementation.
 */
public final class DefaultCollectionService implements CollectionService {

    private final TmdbHttpClient httpClient;

    public DefaultCollectionService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "HTTP client must not be null");
    }

    @Override
    public CollectionDetails details(CollectionId collectionId) {
        return details(collectionId, CollectionDetailsQuery.empty());
    }

    @Override
    public CollectionDetails details(CollectionId collectionId, Language language) {
        return details(collectionId, CollectionDetailsQuery.of(language));
    }

    @Override
    public CollectionDetails details(CollectionId collectionId, CollectionDetailsQuery query) {
        Objects.requireNonNull(collectionId, "Collection id must not be null");
        Objects.requireNonNull(query, "Collection details query must not be null");

        return httpClient.get(
                TmdbRequest.get(CollectionPaths.details(collectionId), query.toQueryParams()),
                CollectionDetails.class
        );
    }

    @Override
    public CollectionImages images(CollectionId collectionId) {
        return images(collectionId, ImageQuery.none());
    }

    @Override
    public CollectionImages images(CollectionId collectionId, ImageQuery query) {
        Objects.requireNonNull(collectionId, "Collection id must not be null");
        Objects.requireNonNull(query, "Image query must not be null");

        return httpClient.get(
                TmdbRequest.get(CollectionPaths.images(collectionId), query.toQueryParams()),
                CollectionImages.class
        );
    }

    @Override
    public CollectionTranslations translations(CollectionId collectionId) {
        Objects.requireNonNull(collectionId, "Collection id must not be null");

        return httpClient.get(
                TmdbRequest.get(CollectionPaths.translations(collectionId)),
                CollectionTranslations.class
        );
    }
}
