package dev.reuss.tmdb.common.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.reuss.tmdb.util.TmdbCollections;

import java.util.List;

/**
 * Images for a TMDB collection.
 *
 * @param id        collection id
 * @param backdrops backdrop images
 * @param posters   poster images
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CollectionImages(
        int id,
        List<TmdbImage> backdrops,
        List<TmdbImage> posters
) {

    public CollectionImages {
        backdrops = TmdbCollections.list(backdrops);
        posters = TmdbCollections.list(posters);
    }

    public boolean isEmpty() {
        return backdrops.isEmpty() && posters.isEmpty();
    }

    public boolean hasImages() {
        return !isEmpty();
    }

    public boolean hasBackdrops() {
        return !backdrops.isEmpty();
    }

    public boolean hasPosters() {
        return !posters.isEmpty();
    }

    public int backdropCount() {
        return backdrops.size();
    }

    public int posterCount() {
        return posters.size();
    }

    public int imageCount() {
        return backdropCount() + posterCount();
    }
}
