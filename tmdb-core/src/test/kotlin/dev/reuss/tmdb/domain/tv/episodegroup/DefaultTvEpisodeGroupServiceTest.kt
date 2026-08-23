package dev.reuss.tmdb.domain.tv.episodegroup

import dev.reuss.tmdb.domain.tv.episodegroup.model.TvEpisodeGroupDetails
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.TvEpisodeGroupId
import org.junit.jupiter.api.Test

class DefaultTvEpisodeGroupServiceTest {
    @Test
    fun details_shouldUseEpisodeGroupPathAndResponseType() {
        assertRequest<TvEpisodeGroupDetails>("/tv/episode_group/group-1") {
            DefaultTvEpisodeGroupService(it).details(TvEpisodeGroupId.of("group-1"))
        }
    }
}
