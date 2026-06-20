package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.quarkus.runtime.TmdbConfig;
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer;
import io.quarkus.test.QuarkusExtensionTest;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbConfigValidationTest {

    @RegisterExtension
    static final QuarkusExtensionTest app = new QuarkusExtensionTest()
            .withApplicationRoot(jar -> jar
                    .addClasses(TmdbProducer.class, TmdbConfig.class)
                    .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                    .addAsResource(new StringAsset("""
                            tmdb.default-language=de-DE
                            """), "application.properties"))
            .assertException(throwable -> assertTrue(
                    containsMessage(throwable, "tmdb.access-token"),
                    "Expected missing access token message but got: " + throwable
            ));

    @Test
    void shouldFailWhenAccessTokenIsMissing() {
    }

    private static boolean containsMessage(Throwable throwable, String expected) {
        Throwable current = throwable;

        while (current != null) {
            if (current.getMessage() != null && current.getMessage().contains(expected)) {
                return true;
            }
            current = current.getCause();
        }

        return false;
    }
}
