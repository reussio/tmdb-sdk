package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class TmdbMetricsAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TmdbMetricsAutoConfiguration.class));

    @Test
    void createsMetricsRecorderWhenMeterRegistryIsAvailable() {
        contextRunner
                .withBean(MeterRegistry.class, SimpleMeterRegistry::new)
                .run(context -> {
                    assertThat(context).hasSingleBean(TmdbMetricsRecorder.class);
                    assertThat(context.getBean(TmdbMetricsRecorder.class))
                            .isInstanceOf(SpringTmdbMetricsRecorder.class);
                });
    }

    @Test
    void doesNotCreateMetricsRecorderWhenMeterRegistryIsMissing() {
        contextRunner.run(context -> assertThat(context).doesNotHaveBean(TmdbMetricsRecorder.class));
    }

    @Test
    void doesNotReplaceCustomMetricsRecorder() {
        TmdbMetricsRecorder customRecorder = TmdbMetricsRecorder.NOOP;

        contextRunner
                .withBean(MeterRegistry.class, SimpleMeterRegistry::new)
                .withBean(TmdbMetricsRecorder.class, () -> customRecorder)
                .run(context -> {
                    assertThat(context).hasSingleBean(TmdbMetricsRecorder.class);
                    assertThat(context.getBean(TmdbMetricsRecorder.class)).isSameAs(customRecorder);
                });
    }

    @Test
    void createsMetricsRecorderBeforeTmdbClientInActuatorApplication() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(
                        MetricsAutoConfiguration.class,
                        SimpleMetricsExportAutoConfiguration.class,
                        CompositeMeterRegistryAutoConfiguration.class,
                        TmdbMetricsAutoConfiguration.class,
                        TmdbClientAutoConfiguration.class
                ))
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    assertThat(context).hasSingleBean(MeterRegistry.class);
                    assertThat(context).hasSingleBean(TmdbMetricsRecorder.class);
                    assertThat(context).hasSingleBean(TmdbClient.class);
                });
    }

    @Test
    void recordsRequestMetrics() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        SpringTmdbMetricsRecorder recorder = new SpringTmdbMetricsRecorder(meterRegistry);

        recorder.recordRequestStarted("GET", "/movie/550");
        recorder.recordRequestFinished("GET", "/movie/550", 200, Duration.ofMillis(25), 512);

        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.ACTIVE_REQUESTS_METRIC).gauge().value())
                .isZero();
        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.REQUESTS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .tag("status", "200")
                .tag("outcome", "SUCCESS")
                .timer()
                .count())
                .isEqualTo(1);
        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.RESPONSE_BYTES_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .summary()
                .totalAmount())
                .isEqualTo(512);
    }

    @Test
    void recordsErrorsRateLimitsAndMappingFailures() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        SpringTmdbMetricsRecorder recorder = new SpringTmdbMetricsRecorder(meterRegistry);

        recorder.recordRequestStarted("GET", "/movie/550");
        recorder.recordRequestFinished("GET", "/movie/550", 429, Duration.ofMillis(25), 128);
        recorder.recordRequestStarted("GET", "/movie/550");
        recorder.recordRequestFailed("GET", "/movie/550", new IllegalStateException("boom"), Duration.ofMillis(5));
        recorder.recordMappingFailed("GET", "/movie/550", String.class, new IllegalArgumentException("invalid"));

        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("type", "api")
                .tag("status", "429")
                .counter()
                .count())
                .isEqualTo(1);
        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.RATE_LIMIT_HITS_METRIC)
                .tag("method", "GET")
                .tag("path", "/movie/{id}")
                .counter()
                .count())
                .isEqualTo(1);
        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.ERRORS_METRIC)
                .tag("type", "exception")
                .tag("exception", "IllegalStateException")
                .counter()
                .count())
                .isEqualTo(1);
        assertThat(meterRegistry.get(SpringTmdbMetricsRecorder.MAPPING_ERRORS_METRIC)
                .tag("response_type", "String")
                .tag("exception", "IllegalArgumentException")
                .counter()
                .count())
                .isEqualTo(1);
    }
}
