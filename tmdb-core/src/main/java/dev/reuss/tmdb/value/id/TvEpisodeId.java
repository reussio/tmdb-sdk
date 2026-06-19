package dev.reuss.tmdb.value.id;

/**
 * TMDB TV episode id.
 *
 * @param value TMDB TV episode id
 */
public record TvEpisodeId(int value) implements NumericTmdbResourceId {

    public TvEpisodeId {
        if (value <= 0) {
            throw new IllegalArgumentException("TV episode id must be greater than 0");
        }
    }

    public static TvEpisodeId of(int value) {
        return new TvEpisodeId(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}