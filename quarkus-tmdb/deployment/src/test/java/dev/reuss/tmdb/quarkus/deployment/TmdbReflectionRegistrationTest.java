package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.common.TmdbModel;
import dev.reuss.tmdb.core.exception.TmdbErrorResponse;
import dev.reuss.tmdb.domain.configuration.model.Country;
import dev.reuss.tmdb.domain.movie.model.MovieDetails;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbReflectionRegistrationTest {

    @Test
    void shouldCollectTmdbModelsForReflection() {
        Index index = index(
                TmdbModel.class,
                Country.class,
                MovieDetails.class,
                TmdbErrorResponse.class
        );

        Set<String> classNames = TmdbNativeImageProcessor.reflectionClassNames(index);

        assertTrue(classNames.contains(Country.class.getName()));
        assertTrue(classNames.contains(MovieDetails.class.getName()));
        assertTrue(classNames.contains(TmdbErrorResponse.class.getName()));
    }

    private static Index index(Class<?>... classes) {
        Indexer indexer = new Indexer();

        for (Class<?> type : classes) {
            try (var input = type.getResourceAsStream(type.getSimpleName() + ".class")) {
                if (input == null) {
                    throw new IllegalStateException("Missing class resource for " + type.getName());
                }
                indexer.index(input);
            } catch (IOException exception) {
                throw new UncheckedIOException(exception);
            }
        }

        return indexer.complete();
    }
}
