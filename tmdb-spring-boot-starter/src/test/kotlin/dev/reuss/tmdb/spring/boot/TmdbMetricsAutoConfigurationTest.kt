package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigurations
import org.springframework.boot.test.context.runner.ApplicationContextRunner

class TmdbMetricsAutoConfigurationTest {
    private val contextRunner =
        ApplicationContextRunner()
            .withConfiguration(
                AutoConfigurations.of(TmdbMetricsAutoConfiguration::class.java),
            )

    @Test
    fun createsMetricsRecorderWhenMeterRegistryIsAvailable() {
        contextRunner
            .withBean(
                MeterRegistry::class.java,
                { SimpleMeterRegistry() },
            ).run { context ->
                assertThat(context)
                    .hasSingleBean(TmdbMetricsRecorder::class.java)

                assertThat(
                    context.getBean(TmdbMetricsRecorder::class.java),
                ).isInstanceOf(SpringTmdbMetricsRecorder::class.java)
            }
    }

    @Test
    fun doesNotCreateMetricsRecorderWhenMeterRegistryIsMissing() {
        contextRunner.run { context ->
            assertThat(context)
                .doesNotHaveBean(TmdbMetricsRecorder::class.java)
        }
    }

    @Test
    fun doesNotReplaceCustomMetricsRecorder() {
        val customRecorder = TmdbMetricsRecorder.NOOP

        contextRunner
            .withBean(
                MeterRegistry::class.java,
                { SimpleMeterRegistry() },
            ).withBean(
                TmdbMetricsRecorder::class.java,
                { customRecorder },
            ).run { context ->
                assertThat(context)
                    .hasSingleBean(TmdbMetricsRecorder::class.java)

                assertThat(
                    context.getBean(TmdbMetricsRecorder::class.java),
                ).isSameAs(customRecorder)
            }
    }

    @Test
    fun createsMetricsRecorderBeforeTmdbClientInActuatorApplication() {
        ApplicationContextRunner()
            .withConfiguration(
                AutoConfigurations.of(
                    MetricsAutoConfiguration::class.java,
                    SimpleMetricsExportAutoConfiguration::class.java,
                    CompositeMeterRegistryAutoConfiguration::class.java,
                    TmdbMetricsAutoConfiguration::class.java,
                    TmdbClientAutoConfiguration::class.java,
                ),
            ).withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context)
                    .hasSingleBean(MeterRegistry::class.java)

                assertThat(context)
                    .hasSingleBean(TmdbMetricsRecorder::class.java)

                assertThat(context)
                    .hasSingleBean(TmdbClient::class.java)
            }
    }
}
