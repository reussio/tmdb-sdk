package dev.reuss.tmdb.domain.collection;


import dev.reuss.tmdb.value.id.CollectionId;

final class CollectionPaths {

    private static final String COLLECTION = "/collection";

    private CollectionPaths() {
    }

    static String details(CollectionId collectionId) {
        return collection(collectionId);
    }

    static String images(CollectionId collectionId) {
        return collection(collectionId) + "/images";
    }

    static String translations(CollectionId collectionId) {
        return collection(collectionId) + "/translations";
    }

    private static String collection(CollectionId collectionId) {
        return COLLECTION + "/" + collectionId.asString();
    }

}
