package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Auto-configuration for Spring Boot Actuator health support.
 */
@AutoConfiguration(after = TmdbClientAutoConfiguration.class)
@ConditionalOnClass(HealthIndicator.class)
@ConditionalOnBean(TmdbClient.class)
@ConditionalOnEnabledHealthIndicator("tmdb")
public class TmdbHealthAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "tmdbHealthIndicator")
    public HealthIndicator tmdbHealthIndicator(TmdbClient tmdbClient) {
        return new TmdbHealthIndicator(tmdbClient);
    }
}
