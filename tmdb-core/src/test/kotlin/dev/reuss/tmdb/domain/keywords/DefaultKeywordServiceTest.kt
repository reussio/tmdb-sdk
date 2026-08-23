package dev.reuss.tmdb.domain.keywords

import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.testsupport.assertRequest
import dev.reuss.tmdb.value.id.KeywordId
import org.junit.jupiter.api.Test

class DefaultKeywordServiceTest {
    @Test
    fun details_shouldUseKeywordPathAndResponseType() {
        assertRequest<Keyword>("/keyword/9715") {
            DefaultKeywordService(it).details(KeywordId.of(9715))
        }
    }
}
