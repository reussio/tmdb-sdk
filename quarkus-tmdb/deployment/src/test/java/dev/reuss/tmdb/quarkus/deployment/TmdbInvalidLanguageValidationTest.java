package dev.reuss.tmdb.quarkus.deployment;

import dev.reuss.tmdb.quarkus.runtime.TmdbConfig;
import dev.reuss.tmdb.quarkus.runtime.TmdbProducer;
import io.quarkus.test.QuarkusExtensionTest;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TmdbInvalidLanguageValidationTest {

    @RegisterExtension
    static final QuarkusExtensionTest app = new QuarkusExtensionTest()
            .withApplicationRoot(jar -> jar
                    .addClasses(TmdbProducer.class, TmdbConfig.class)
                    .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                    .addAsResource(new StringAsset("""
                            tmdb.access-token=test-token
                            tmdb.default-language=invalid
                            """), "application.properties"))
            .assertException(throwable -> assertTrue(
                    containsMessage(throwable, "Language must match format"),
                    "Expected invalid language message but got: " + throwable
            ));

    @Test
    void shouldFailWhenDefaultLanguageIsInvalid() {
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
