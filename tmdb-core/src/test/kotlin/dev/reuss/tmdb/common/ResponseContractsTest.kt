package dev.reuss.tmdb.common

import dev.reuss.tmdb.common.change.Change
import dev.reuss.tmdb.common.change.ChangesResponse
import dev.reuss.tmdb.common.credit.CreditsResponse
import dev.reuss.tmdb.common.external.ExternalIds
import dev.reuss.tmdb.common.image.CollectionImages
import dev.reuss.tmdb.common.image.LogoImage
import dev.reuss.tmdb.common.image.LogoImagesResponse
import dev.reuss.tmdb.common.image.PosterBackdropLogoImagesResponse
import dev.reuss.tmdb.common.image.TmdbImage
import dev.reuss.tmdb.common.keyword.Keyword
import dev.reuss.tmdb.common.keyword.KeywordsResponse
import dev.reuss.tmdb.common.name.AlternativeNamesResponse
import dev.reuss.tmdb.common.page.PagedResponse
import dev.reuss.tmdb.common.title.AlternativeTitle
import dev.reuss.tmdb.common.title.AlternativeTitlesResponse
import dev.reuss.tmdb.common.translation.Translation
import dev.reuss.tmdb.common.translation.TranslationsResponse
import dev.reuss.tmdb.common.video.VideosResponse
import dev.reuss.tmdb.common.watchprovider.WatchProvidersResponse
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.Locale

class ResponseContractsTest {
    @Test
    fun pagedResponse_shouldExposeNavigationAndResultState() {
        val firstPage = page(page = 1, totalPages = 2, results = listOf("one", "two"))

        assertTrue(firstPage.isFirstPage())
        assertFalse(firstPage.isLastPage())
        assertTrue(firstPage.hasNextPage())
        assertFalse(firstPage.hasPreviousPage())
        assertTrue(firstPage.hasResults())
        assertEquals(2, firstPage.resultCount())
        assertEquals(2, firstPage.nextPage())
        assertEquals(2, firstPage.nextPageNumber().orElseThrow())
        assertTrue(firstPage.previousPageNumber().isEmpty)
        assertThrows<IllegalStateException> { firstPage.previousPage() }

        val lastPage = page(page = 2, totalPages = 2, results = emptyList())

        assertTrue(lastPage.isLastPage())
        assertTrue(lastPage.isEmpty())
        assertEquals(1, lastPage.previousPage())
        assertTrue(lastPage.nextPageNumber().isEmpty)
        assertThrows<IllegalStateException> { lastPage.nextPage() }
    }

    @Test
    fun collectionResponseContracts_shouldExposeCountsAndPresence() {
        val changes =
            object : ChangesResponse {
                override val changes = listOf(Change("title"))
            }
        val credits =
            object : CreditsResponse<String, String> {
                override val cast = listOf("cast")
                override val crew = listOf("crew", "crew-2")
            }
        val keywords =
            object : KeywordsResponse {
                override val keywords = listOf(Keyword(1, "space"))
            }
        val names =
            object : AlternativeNamesResponse<String> {
                override val results = listOf("name")
            }
        val titles =
            object : AlternativeTitlesResponse {
                override val alternativeTitles = listOf(AlternativeTitle("DE", "Titel", null))
            }
        val translations =
            object : TranslationsResponse<String> {
                override val translations = listOf(Translation("DE", "de", "Deutsch", "German", "data"))
            }
        val videos =
            object : VideosResponse<String> {
                override val results = listOf("video")
            }

        assertTrue(changes.hasChanges())
        assertEquals(1, changes.changeCount())
        assertTrue(credits.hasCredits())
        assertTrue(credits.hasCast())
        assertTrue(credits.hasCrew())
        assertEquals(3, credits.creditCount())
        assertTrue(keywords.hasKeywords())
        assertEquals(1, keywords.keywordCount())
        assertTrue(names.hasAlternativeNames())
        assertEquals(1, names.alternativeNameCount())
        assertTrue(titles.hasAlternativeTitles())
        assertEquals(1, titles.alternativeTitleCount())
        assertTrue(translations.hasTranslations())
        assertEquals(1, translations.translationCount())
        assertTrue(videos.hasVideos())
        assertEquals(1, videos.videoCount())
    }

    @Test
    fun imageResponseContracts_shouldAggregateImageCounts() {
        val image = image()
        val collection = CollectionImages(1, listOf(image), listOf(image, image))
        val logos =
            object : LogoImagesResponse {
                override val logos = listOf(logo())
            }
        val combined =
            object : PosterBackdropLogoImagesResponse {
                override val backdrops = listOf(image)
                override val logos = listOf(image)
                override val posters = listOf(image, image)
            }

        assertTrue(collection.hasImages())
        assertTrue(collection.hasBackdrops())
        assertTrue(collection.hasPosters())
        assertEquals(3, collection.imageCount())
        assertTrue(logos.hasLogos())
        assertEquals(1, logos.logoCount())
        assertTrue(combined.hasImages())
        assertEquals(4, combined.imageCount())
    }

    @Test
    fun externalIds_shouldDistinguishSocialAndDatabaseIdentifiers() {
        val socialIds = externalIds(instagramId = "tmdb")
        val databaseIds = externalIds(imdbId = "tt0137523")
        val emptyIds = externalIds()

        assertTrue(socialIds.hasSocialIds())
        assertFalse(socialIds.hasDatabaseIds())
        assertTrue(databaseIds.hasDatabaseIds())
        assertFalse(databaseIds.hasSocialIds())
        assertFalse(emptyIds.hasSocialIds())
        assertFalse(emptyIds.hasDatabaseIds())
    }

    @Test
    fun watchProvidersResponse_shouldUseLocaleIndependentRegionLookup() {
        val originalLocale = Locale.getDefault()
        val response =
            object : WatchProvidersResponse<String> {
                override val results = mapOf("IN" to "provider")
            }

        try {
            Locale.setDefault(Locale.forLanguageTag("tr-TR"))

            assertTrue(response.hasRegion("in"))
            assertEquals("provider", response.region("in").orElseThrow())
            assertEquals("provider", response.region(Regions.IN).orElseThrow())
            assertFalse(response.hasRegion(null))
            assertTrue(response.region(null as String?).isEmpty)
        } finally {
            Locale.setDefault(originalLocale)
        }
    }

    private fun page(
        page: Int,
        totalPages: Int,
        results: List<String>,
    ): PagedResponse<String> =
        object : PagedResponse<String> {
            override val page = page
            override val results = results
            override val totalPages = totalPages
            override val totalResults = results.size
        }

    private fun image(): TmdbImage = TmdbImage(1.0, 1, null, "/image.jpg", 0.0, 0, 1)

    private fun logo(): LogoImage = LogoImage(1.0, "/logo.svg", 1, "logo", ".svg", 0.0, 0, 1)

    private fun externalIds(
        imdbId: String? = null,
        instagramId: String? = null,
    ): ExternalIds =
        ExternalIds(
            id = 1,
            imdbId = imdbId,
            wikidataId = null,
            facebookId = null,
            instagramId = instagramId,
            twitterId = null,
            tvdbId = null,
            tvrageId = null,
            freebaseMid = null,
            freebaseId = null,
            tiktokId = null,
            youtubeId = null,
        )
}
