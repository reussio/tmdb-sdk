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
import java.time.Duration

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

    @Test
    fun recordsRequestMetrics() {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(meterRegistry)

        recorder.recordRequestStarted("GET", "/movie/550")
        recorder.recordRequestFinished(
            "GET",
            "/movie/550",
            200,
            Duration.ofMillis(25),
            512,
        )

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC)
                .gauge()
                .value(),
        ).isZero()

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .tag("status", "200")
                .tag("outcome", "SUCCESS")
                .timer()
                .count(),
        ).isEqualTo(1)

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.RESPONSE_BYTES_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .summary()
                .totalAmount(),
        ).isEqualTo(512.0)
    }

    @Test
    fun recordsErrorsRateLimitsAndMappingFailures() {
        val meterRegistry = SimpleMeterRegistry()
        val recorder = SpringTmdbMetricsRecorder(meterRegistry)

        recorder.recordRequestStarted("GET", "/movie/550")
        recorder.recordRequestFinished(
            "GET",
            "/movie/550",
            429,
            Duration.ofMillis(25),
            128,
        )

        recorder.recordRequestStarted("GET", "/movie/550")
        recorder.recordRequestFailed(
            "GET",
            "/movie/550",
            IllegalStateException("boom"),
            Duration.ofMillis(5),
        )

        recorder.recordMappingFailed(
            "GET",
            "/movie/550",
            String::class.java,
            IllegalArgumentException("invalid"),
        )

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("type", "api")
                .tag("status", "429")
                .counter()
                .count(),
        ).isEqualTo(1.0)

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.RATE_LIMIT_HITS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .counter()
                .count(),
        ).isEqualTo(1.0)

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("type", "exception")
                .tag("exception", "IllegalStateException")
                .counter()
                .count(),
        ).isEqualTo(1.0)

        assertThat(
            meterRegistry
                .get(SpringTmdbMetricsRecorder.MAPPING_ERRORS_METRIC)
                .tag("response_type", "String")
                .tag("exception", "IllegalArgumentException")
                .counter()
                .count(),
        ).isEqualTo(1.0)
    }
}
