package dev.reuss.tmdb.spring.boot

import dev.reuss.tmdb.TmdbClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.actuate.health.Status
import org.springframework.boot.autoconfigure.AutoConfigurations
import org.springframework.boot.test.context.runner.ApplicationContextRunner

class TmdbHealthAutoConfigurationTest {

    private val contextRunner = ApplicationContextRunner()
        .withConfiguration(
            AutoConfigurations.of(
                TmdbClientAutoConfiguration::class.java,
                TmdbHealthAutoConfiguration::class.java
            )
        )

    @Test
    fun createsTmdbHealthIndicatorWhenActuatorAndClientAreAvailable() {
        contextRunner
            .withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context).hasSingleBean(TmdbClient::class.java)
                assertThat(context).hasBean("tmdbHealthIndicator")
                assertThat(context).hasSingleBean(HealthIndicator::class.java)

                val health = context
                    .getBean(HealthIndicator::class.java)
                    .health()

                assertThat(health.status)
                    .isEqualTo(Status.UP)

                assertThat(health.details)
                    .containsEntry("client", "configured")
            }
    }

    @Test
    fun doesNotCreateTmdbHealthIndicatorWhenDisabled() {
        contextRunner
            .withPropertyValues(
                "tmdb.access-token=test-token",
                "management.health.tmdb.enabled=false"
            )
            .run { context ->
                assertThat(context)
                    .doesNotHaveBean("tmdbHealthIndicator")
            }
    }

    @Test
    fun doesNotReplaceCustomTmdbHealthIndicator() {
        val customHealthIndicator =
            HealthIndicator {
                Health.up()
                    .withDetail("client", "custom")
                    .build()
            }

        contextRunner
            .withBean(
                "tmdbHealthIndicator",
                HealthIndicator::class.java,
                { customHealthIndicator }
            )
            .withPropertyValues("tmdb.access-token=test-token")
            .run { context ->
                assertThat(context).hasBean("tmdbHealthIndicator")

                assertThat(
                    context.getBean(
                        "tmdbHealthIndicator",
                        HealthIndicator::class.java
                    )
                ).isSameAs(customHealthIndicator)
            }
    }
}