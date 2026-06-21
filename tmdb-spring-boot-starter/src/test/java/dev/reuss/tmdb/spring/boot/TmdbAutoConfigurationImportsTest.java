package dev.reuss.tmdb.spring.boot;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class TmdbAutoConfigurationImportsTest {

    private static final String IMPORTS_FILE =
            "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports";

    @Test
    void autoConfigurationImportsFileContainsTmdbAutoConfigurations() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (var inputStream = classLoader.getResourceAsStream(IMPORTS_FILE)) {
            assertThat(inputStream)
                    .as("AutoConfiguration imports file")
                    .isNotNull();

            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            assertThat(content)
                    .contains(TmdbMetricsAutoConfiguration.class.getName())
                    .contains(TmdbClientAutoConfiguration.class.getName())
                    .contains(TmdbServiceAutoConfiguration.class.getName())
                    .contains(TmdbHealthAutoConfiguration.class.getName());
        }
    }
}
