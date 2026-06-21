package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class TmdbHealthAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                    TmdbClientAutoConfiguration.class,
                    TmdbHealthAutoConfiguration.class
            ));

    @Test
    void createsTmdbHealthIndicatorWhenActuatorAndClientAreAvailable() {
        contextRunner
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    assertThat(context).hasSingleBean(TmdbClient.class);
                    assertThat(context).hasBean("tmdbHealthIndicator");
                    assertThat(context).hasSingleBean(HealthIndicator.class);

                    Health health = context.getBean(HealthIndicator.class).health();

                    assertThat(health.getStatus()).isEqualTo(Status.UP);
                    assertThat(health.getDetails()).containsEntry("client", "configured");
                });
    }

    @Test
    void doesNotCreateTmdbHealthIndicatorWhenDisabled() {
        contextRunner
                .withPropertyValues(
                        "tmdb.access-token=test-token",
                        "management.health.tmdb.enabled=false"
                )
                .run(context -> assertThat(context).doesNotHaveBean("tmdbHealthIndicator"));
    }

    @Test
    void doesNotReplaceCustomTmdbHealthIndicator() {
        HealthIndicator customHealthIndicator = () -> Health.up()
                .withDetail("client", "custom")
                .build();

        contextRunner
                .withBean("tmdbHealthIndicator", HealthIndicator.class, () -> customHealthIndicator)
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    assertThat(context).hasBean("tmdbHealthIndicator");
                    assertThat(context.getBean("tmdbHealthIndicator", HealthIndicator.class))
                            .isSameAs(customHealthIndicator);
                });
    }
}
