package dev.reuss.tmdb.domain.images.url

import dev.reuss.tmdb.domain.configuration.ConfigurationService
import dev.reuss.tmdb.domain.configuration.model.ApiConfiguration
import dev.reuss.tmdb.domain.configuration.model.ConfigurationLanguage
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.configuration.model.JobDepartment
import dev.reuss.tmdb.domain.configuration.model.Timezone
import dev.reuss.tmdb.value.image.size.BackdropSize
import dev.reuss.tmdb.value.image.size.LogoSize
import dev.reuss.tmdb.value.image.size.PosterSize
import dev.reuss.tmdb.value.image.size.ProfileSize
import dev.reuss.tmdb.value.image.size.StillSize
import dev.reuss.tmdb.value.language.Language
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DefaultImageUrlBuilderTest {
    @Test
    fun imageMethods_shouldBuildSecureUrls_forEveryImageCategory() {
        val configuration = RecordingConfigurationService("https://image.tmdb.org/t/p/")
        val imageUrls = DefaultImageUrlBuilder(configuration)

        assertEquals(
            "https://image.tmdb.org/t/p/w500/poster.jpg",
            imageUrls.poster("poster.jpg", PosterSize.W500).toString(),
        )
        assertEquals(
            "https://image.tmdb.org/t/p/w1280/backdrop.jpg",
            imageUrls.backdrop("/backdrop.jpg", BackdropSize.W1280).toString(),
        )
        assertEquals(
            "https://image.tmdb.org/t/p/original/logo.svg",
            imageUrls.logo("/logo.svg", LogoSize.ORIGINAL).toString(),
        )
        assertEquals(
            "https://image.tmdb.org/t/p/h632/profile.jpg",
            imageUrls.profile("/profile.jpg", ProfileSize.H632).toString(),
        )
        assertEquals(
            "https://image.tmdb.org/t/p/w300/still.jpg",
            imageUrls.still("/still.jpg", StillSize.W300).toString(),
        )
        assertEquals(1, configuration.calls)
    }

    @Test
    fun poster_shouldRejectBlankPath_beforeLoadingConfiguration() {
        val configuration = RecordingConfigurationService("https://image.tmdb.org/t/p/")
        val imageUrls = DefaultImageUrlBuilder(configuration)

        assertThrows<IllegalArgumentException> {
            imageUrls.poster("   ", PosterSize.W500)
        }

        assertEquals(0, configuration.calls)
    }

    @Test
    fun poster_shouldFailClearly_whenSecureBaseUrlIsMissing() {
        val imageUrls = DefaultImageUrlBuilder(RecordingConfigurationService(null))

        val exception =
            assertThrows<IllegalStateException> {
                imageUrls.poster("/poster.jpg", PosterSize.W500)
            }

        assertEquals("TMDB secure image base URL is missing", exception.message)
    }

    private class RecordingConfigurationService(
        private val secureBaseUrl: String?,
    ) : ConfigurationService {
        var calls: Int = 0
            private set

        override fun apiConfiguration(): ApiConfiguration {
            calls++
            return ApiConfiguration(
                ApiConfiguration.Images(
                    baseUrl = null,
                    secureBaseUrl = secureBaseUrl,
                ),
            )
        }

        override fun countries(): List<Country> = emptyList()

        override fun countries(language: Language): List<Country> = emptyList()

        override fun jobs(): List<JobDepartment> = emptyList()

        override fun languages(): List<ConfigurationLanguage> = emptyList()

        override fun primaryTranslations(): List<String> = emptyList()

        override fun timezones(): List<Timezone> = emptyList()
    }
}
