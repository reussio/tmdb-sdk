package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean

/**
 * Registers the non-networking `tmdb` health indicator when Actuator health support and a
 * [TmdbClient] bean are present.
 */
@AutoConfiguration(after = [TmdbClientAutoConfiguration::class])
@ConditionalOnClass(HealthIndicator::class)
@ConditionalOnBean(TmdbClient::class)
@ConditionalOnEnabledHealthIndicator("tmdb")
class TmdbHealthAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(name = ["tmdbHealthIndicator"])
    fun tmdbHealthIndicator(tmdbClient: TmdbClient): HealthIndicator = TmdbHealthIndicator(tmdbClient)
}
