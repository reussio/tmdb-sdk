package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.quarkus.runtime.TmdbConfig
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer
import io.quarkus.test.QuarkusExtensionTest
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.asset.StringAsset
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class TmdbBlankAccessTokenValidationTest {
    @Test
    fun shouldFailWhenAccessTokenIsBlank() {
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
                        ).addAsManifestResource(
                            EmptyAsset.INSTANCE,
                            "beans.xml",
                        ).addAsResource(
                            StringAsset(
                                """
                                tmdb.access-token=
                                """.trimIndent(),
                            ),
                            "application.properties",
                        )
                }.assertException { throwable ->
                    assertTrue(
                        containsMessage(throwable, "tmdb.access-token"),
                        "Expected blank access token message but got: $throwable",
                    )
                }

        private fun containsMessage(
            throwable: Throwable,
            expected: String,
        ): Boolean {
            var current: Throwable? = throwable

            while (current != null) {
                if (current.message?.contains(expected) == true) {
                    return true
                }

                current = current.cause
            }

            return false
        }
    }
}
