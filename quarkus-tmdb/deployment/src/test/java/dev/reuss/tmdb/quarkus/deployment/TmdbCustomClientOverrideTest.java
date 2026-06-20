package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.domain.movie.MovieService;
import dev.reuss.tmdb.quarkus.runtime.TmdbConfig;
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer;
import io.quarkus.test.QuarkusExtensionTest;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertSame;

class TmdbCustomClientOverrideTest {

    @RegisterExtension
    static final QuarkusExtensionTest app = new QuarkusExtensionTest()
            .withApplicationRoot(jar -> jar
                    .addClasses(TmdbProducer.class, TmdbConfig.class, CustomTmdbClientProducer.class)
                    .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                    .addAsResource(new StringAsset("""
                            tmdb.access-token=test-token
                            """), "application.properties"));

    @Inject
    TmdbClient client;

    @Inject
    MovieService movieService;

    @Test
    void shouldUseCustomClientBean() {
        assertSame(CustomTmdbClientProducer.CLIENT, client);
        assertSame(CustomTmdbClientProducer.CLIENT.movies(), movieService);
    }

    @Singleton
    static class CustomTmdbClientProducer {

        static final TmdbClient CLIENT = TmdbClient.builder()
                .accessToken("custom-token")
                .build();

        @Produces
        @Singleton
        TmdbClient tmdbClient() {
            return CLIENT;
        }
    }
}
