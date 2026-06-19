package dev.reuss.tmdb.domain.tv.episodegroup;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupDetails;
import dev.reuss.tmdb.value.id.TvEpisodeGroupId;

import java.util.Objects;

public final class DefaultTvEpisodeGroupService implements TvEpisodeGroupService {

    private final TmdbHttpClient httpClient;

    public DefaultTvEpisodeGroupService(TmdbHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient, "TMDB HTTP client must not be null");
    }

    @Override
    public TvEpisodeGroupDetails details(TvEpisodeGroupId episodeGroupId) {
        Objects.requireNonNull(episodeGroupId, "TV episode group id must not be null");

        return httpClient.get(
                TmdbRequest.get(TvEpisodeGroupPaths.details(episodeGroupId)),
                TvEpisodeGroupDetails.class
        );
    }
}
