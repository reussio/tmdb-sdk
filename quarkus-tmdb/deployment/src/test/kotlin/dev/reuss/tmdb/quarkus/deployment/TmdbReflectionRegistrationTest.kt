package dev.reuss.tmdb.quarkus.deployment

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.common.TmdbModel
import dev.reuss.tmdb.core.exception.TmdbErrorResponse
import dev.reuss.tmdb.domain.configuration.model.Country
import dev.reuss.tmdb.domain.movie.model.MovieDetails
import org.jboss.jandex.Index
import org.jboss.jandex.Indexer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.UncheckedIOException

class TmdbReflectionRegistrationTest {
    @Test
    fun shouldCollectTmdbModelsForReflection() {
        val index =
            index(
                TmdbModel::class.java,
                Country::class.java,
                MovieDetails::class.java,
                TmdbErrorResponse::class.java,
                TmdbClient::class.java,
            )

        val classNames =
            TmdbNativeImageProcessor.reflectionClassNames(index)

        assertTrue(classNames.contains(Country::class.java.name))
        assertTrue(classNames.contains(MovieDetails::class.java.name))
        assertTrue(classNames.contains(TmdbErrorResponse::class.java.name))
        assertFalse(classNames.contains(TmdbClient::class.java.name))
        assertEquals(classNames.toSortedSet(), classNames)
    }

    private fun index(vararg classes: Class<*>): Index {
        val indexer = Indexer()

        classes.forEach { type ->
            val resourceName = "${type.simpleName}.class"

            try {
                type.getResourceAsStream(resourceName).use { input ->
                    checkNotNull(input) {
                        "Missing class resource for ${type.name}"
                    }

                    indexer.index(input)
                }
            } catch (exception: java.io.IOException) {
                throw UncheckedIOException(exception)
            }
        }

        return indexer.complete()
    }
}
