package dev.reuss.tmdb.spring.boot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TmdbAutoConfigurationImportsTest {

    @Test
    fun autoConfigurationImportsFileContainsTmdbAutoConfigurations() {
        val classLoader = Thread.currentThread().contextClassLoader

        classLoader.getResourceAsStream(IMPORTS_FILE).use { inputStream ->
            assertThat(inputStream)
                .`as`("AutoConfiguration imports file")
                .isNotNull()

            val content = inputStream
                ?.readAllBytes()
                ?.toString(Charsets.UTF_8)

            assertThat(content)
                .contains(TmdbMetricsAutoConfiguration::class.java.name)
                .contains(TmdbClientAutoConfiguration::class.java.name)
                .contains(TmdbServiceAutoConfiguration::class.java.name)
                .contains(TmdbHealthAutoConfiguration::class.java.name)
        }
    }

    companion object {
        private const val IMPORTS_FILE =
            "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports"
    }
}