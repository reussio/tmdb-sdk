package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusMetricsExportAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Auto-configuration for Micrometer metrics support.
 */
@AutoConfiguration(
        after = {
            MetricsAutoConfiguration.class,
            PrometheusMetricsExportAutoConfiguration.class,
            SimpleMetricsExportAutoConfiguration.class,
            CompositeMeterRegistryAutoConfiguration.class
        },
        before = TmdbClientAutoConfiguration.class
)
@ConditionalOnClass(MeterRegistry.class)
@ConditionalOnBean(MeterRegistry.class)
public class TmdbMetricsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TmdbMetricsRecorder tmdbMetricsRecorder(MeterRegistry meterRegistry) {
        return new SpringTmdbMetricsRecorder(meterRegistry);
    }
}
