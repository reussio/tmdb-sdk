package dev.reuss.tmdb;

import dev.reuss.tmdb.core.auth.TmdbAuth;
import dev.reuss.tmdb.core.config.TmdbClientConfig;
import dev.reuss.tmdb.value.language.Language;
import dev.reuss.tmdb.value.language.Languages;
import dev.reuss.tmdb.value.region.Region;

import java.time.Duration;
import java.util.Objects;

/**
 * Builder for creating {@link TmdbClient} instances.
 *
 * <p>The builder configures authentication, the TMDB API base URL and default
 * request settings such as language, region and timeouts.</p>
 *
 * <p>At minimum, an access token or {@link TmdbAuth} instance must be provided
 * before calling {@link #build()}.</p>
 *
 * <pre>{@code
 * TmdbClient tmdb = TmdbClient.builder()
 *         .accessToken("your-access-token")
 *         .defaultLanguage(Languages.DE_DE)
 *         .build();
 * }</pre>
 *
 * @see TmdbClient
 * @see TmdbAuth
 * @see TmdbClientConfig
 */
public final class TmdbClientBuilder {

    private TmdbAuth auth;
    private String baseUrl = "https://api.themoviedb.org/3";
    private Language defaultLanguage = Languages.EN_US;
    private Region defaultRegion;
    private Duration connectTimeout = Duration.ofSeconds(5);
    private Duration requestTimeout = Duration.ofSeconds(10);

    /**
     * Sets the TMDB bearer access token.
     *
     * @param accessToken the TMDB bearer access token
     * @return this builder
     * @throws IllegalArgumentException if the access token is {@code null}, blank or empty
     */
    public TmdbClientBuilder accessToken(String accessToken) {
        this.auth = TmdbAuth.bearerToken(accessToken);
        return this;
    }

    /**
     * Sets the TMDB authentication configuration.
     *
     * @param auth the TMDB authentication configuration
     * @return this builder
     * @throws NullPointerException if {@code auth} is {@code null}
     */
    public TmdbClientBuilder auth(TmdbAuth auth) {
        this.auth = Objects.requireNonNull(auth, "TMDB auth must not be null");
        return this;
    }

    /**
     * Sets the TMDB API base URL.
     *
     * <p>The default value is {@code https://api.themoviedb.org/3}.
     * This is mainly useful for testing or custom deployments.</p>
     *
     * @param baseUrl the TMDB API base URL
     * @return this builder
     */
    public TmdbClientBuilder baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Sets the default language for localized TMDB requests.
     *
     * <p>The default value is {@link Languages#EN_US}.</p>
     *
     * @param defaultLanguage the default language
     * @return this builder
     */
    public TmdbClientBuilder defaultLanguage(Language defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
        return this;
    }

    /**
     * Sets the default region for regional TMDB requests.
     *
     * <p>The default region is optional and may be {@code null}. Not every
     * TMDB request requires or supports a region.</p>
     *
     * @param defaultRegion the default region, or {@code null}
     * @return this builder
     */
    public TmdbClientBuilder defaultRegion(Region defaultRegion) {
        this.defaultRegion = defaultRegion;
        return this;
    }

    /**
     * Sets the HTTP connection timeout.
     *
     * <p>The default value is 5 seconds.</p>
     *
     * @param connectTimeout the connection timeout
     * @return this builder
     */
    public TmdbClientBuilder connectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    /**
     * Sets the overall HTTP request timeout.
     *
     * <p>The default value is 10 seconds.</p>
     *
     * @param requestTimeout the request timeout
     * @return this builder
     */
    public TmdbClientBuilder requestTimeout(Duration requestTimeout) {
        this.requestTimeout = requestTimeout;
        return this;
    }

    /**
     * Builds a new {@link TmdbClient}.
     *
     * @return a new TMDB client instance
     * @throws NullPointerException     if required configuration values are missing
     * @throws IllegalArgumentException if configuration values are invalid
     */
    public TmdbClient build() {
        TmdbClientConfig config = new TmdbClientConfig(
                auth,
                baseUrl,
                defaultLanguage,
                defaultRegion,
                connectTimeout,
                requestTimeout
        );

        return new DefaultTmdbClient(config);
    }
}