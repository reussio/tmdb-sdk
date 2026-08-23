package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.domain.movie.MovieService
import dev.reuss.tmdb.quarkus.runtime.TmdbConfig
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer
import io.quarkus.test.QuarkusExtensionTest
import jakarta.enterprise.inject.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.asset.StringAsset
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class TmdbCustomClientOverrideTest {
    @Inject
    lateinit var client: TmdbClient

    @Inject
    lateinit var movieService: MovieService

    @Test
    fun shouldUseCustomClientBean() {
        assertSame(CustomTmdbClientProducer.CLIENT, client)
        assertSame(CustomTmdbClientProducer.CLIENT.movies(), movieService)
    }

    @Singleton
    class CustomTmdbClientProducer {
        @Produces
        @Singleton
        fun tmdbClient(): TmdbClient = CLIENT

        companion object {
            @JvmField
            val CLIENT: TmdbClient =
                TmdbClient
                    .builder()
                    .accessToken("custom-token")
                    .build()
        }
    }

    companion object {
        @JvmField
        @RegisterExtension
        val app =
            QuarkusExtensionTest()
                .withApplicationRoot { jar ->
                    jar
                        .addClasses(
                            TmdbProducer::class.java,
                            TmdbConfig::class.java,
                            CustomTmdbClientProducer::class.java,
                        ).addAsManifestResource(
                            EmptyAsset.INSTANCE,
                            "beans.xml",
                        ).addAsResource(
                            StringAsset(
                                """
                                tmdb.access-token=test-token
                                """.trimIndent(),
                            ),
                            "application.properties",
                        )
                }
    }
}
