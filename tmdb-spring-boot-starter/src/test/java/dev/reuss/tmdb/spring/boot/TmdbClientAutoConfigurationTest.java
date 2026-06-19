package dev.reuss.tmdb.spring.boot;

import dev.reuss.tmdb.TmdbClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class TmdbClientAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TmdbClientAutoConfiguration.class));

    @Test
    void createsTmdbClientWhenAccessTokenIsConfigured() {
        contextRunner
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> assertThat(context).hasSingleBean(TmdbClient.class));
    }

    @Test
    void doesNotCreateTmdbClientWhenCustomBeanExists() {
        TmdbClient customClient = TmdbClient.builder()
                .accessToken("custom-token")
                .build();

        contextRunner
                .withBean(TmdbClient.class, () -> customClient)
                .withPropertyValues("tmdb.access-token=test-token")
                .run(context -> {
                    assertThat(context).hasSingleBean(TmdbClient.class);
                    assertThat(context.getBean(TmdbClient.class)).isSameAs(customClient);
                });
    }

    @Test
    void failsWhenAccessTokenIsMissing() {
        contextRunner.run(context -> assertThat(context).hasFailed());
    }

    @Test
    void bindsProperties() {
        contextRunner
                .withPropertyValues(
                        "tmdb.access-token=test-token",
                        "tmdb.default-language=de-DE",
                        "tmdb.default-region=DE",
                        "tmdb.connect-timeout=2s",
                        "tmdb.request-timeout=5s"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(TmdbClient.class);

                    TmdbProperties properties = context.getBean(TmdbProperties.class);
                    assertThat(properties.accessToken()).isEqualTo("test-token");
                    assertThat(properties.defaultLanguage()).isEqualTo("de-DE");
                    assertThat(properties.defaultRegion()).isEqualTo("DE");
                    assertThat(properties.connectTimeout()).hasSeconds(2);
                    assertThat(properties.requestTimeout()).hasSeconds(5);
                });
    }
}
