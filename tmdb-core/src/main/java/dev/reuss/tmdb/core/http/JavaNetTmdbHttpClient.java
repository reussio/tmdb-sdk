package dev.reuss.tmdb.core.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.reuss.tmdb.core.config.TmdbClientConfig;
import dev.reuss.tmdb.core.exception.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * {@link TmdbHttpClient} implementation based on Java's built-in
 * {@link HttpClient}.
 *
 * <p>This client applies the configured TMDB authentication, builds absolute
 * request URIs from {@link TmdbRequest} instances, sends HTTP GET requests and
 * maps successful JSON responses to the requested Java type.</p>
 *
 * <p>Non-successful HTTP responses are translated into SDK-specific runtime
 * exceptions such as {@link TmdbUnauthorizedException},
 * {@link TmdbNotFoundException}, {@link TmdbRateLimitException} or
 * {@link TmdbServerException}.</p>
 */
public final class JavaNetTmdbHttpClient implements TmdbHttpClient {

    private final TmdbClientConfig config;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    /**
     * Creates a new HTTP client using the given TMDB client configuration.
     *
     * @param config the TMDB client configuration
     * @throws NullPointerException if {@code config} is {@code null}
     */
    public JavaNetTmdbHttpClient(TmdbClientConfig config) {
        this.config = Objects.requireNonNull(config, "TMDB client config must not be null");
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(config.connectTimeout())
                .build();
        this.objectMapper = new ObjectMapper()
                .findAndRegisterModules()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Sends a GET request to TMDB and maps the JSON response body to the given type.
     *
     * @param request      the TMDB request to send
     * @param responseType the expected response type
     * @param <T>          the expected response type
     * @return the mapped response body
     * @throws NullPointerException      if {@code request} or {@code responseType} is {@code null}
     * @throws TmdbUnauthorizedException if TMDB returns HTTP 401
     * @throws TmdbNotFoundException     if TMDB returns HTTP 404
     * @throws TmdbRateLimitException    if TMDB returns HTTP 429
     * @throws TmdbServerException       if TMDB returns an HTTP 5xx response
     * @throws TmdbMappingException      if the response body cannot be mapped
     * @throws TmdbException             for network errors, interruptions or other non-successful responses
     */
    @Override
    public <T> T get(TmdbRequest request, Class<T> responseType) {
        Objects.requireNonNull(request, "TMDB request must not be null");
        Objects.requireNonNull(responseType, "Response type must not be null");

        URI uri = buildUri(request);

        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .timeout(config.requestTimeout())
                .header("Authorization", config.auth().authorizationHeaderValue())
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(
                    httpRequest,
                    HttpResponse.BodyHandlers.ofString()
            );

            return handleResponse(response, responseType);

        } catch (IOException e) {
            throw new TmdbClientException("Failed to execute TMDB request", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TmdbClientException("TMDB request was interrupted", e);
        }
    }

    private URI buildUri(TmdbRequest request) {
        String baseUrl = config.baseUrl().endsWith("/")
                ? config.baseUrl().substring(0, config.baseUrl().length() - 1)
                : config.baseUrl();

        String url = baseUrl + request.path();

        if (!request.queryParams().isEmpty()) {
            url += "?" + toQueryString(request.queryParams());
        }

        return URI.create(url);
    }

    private String toQueryString(Map<String, String> queryParams) {
        return queryParams.entrySet()
                .stream()
                .map(entry -> encode(entry.getKey()) + "=" + encode(entry.getValue()))
                .collect(Collectors.joining("&"));
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    private <T> T handleResponse(HttpResponse<String> response, Class<T> responseType) {
        int httpStatus = response.statusCode();
        String body = response.body();

        if (httpStatus >= 200 && httpStatus < 300) {
            return mapBody(body, responseType, httpStatus);
        }

        throw mapErrorResponse(httpStatus, body);
    }

    private TmdbApiException mapErrorResponse(int httpStatus, String body) {
        try {
            TmdbErrorResponse errorResponse = objectMapper.readValue(
                    body,
                    TmdbErrorResponse.class
            );

            return TmdbExceptions.from(
                    httpStatus,
                    errorResponse.statusCode(),
                    errorResponse.statusMessage(),
                    body
            );
        } catch (Exception exception) {
            return TmdbExceptions.fromHttpStatus(
                    httpStatus,
                    "TMDB request failed with status code " + httpStatus,
                    body
            );
        }
    }

    private <T> T mapBody(String body, Class<T> responseType, int statusCode) {
        try {
            return objectMapper.readValue(body, responseType);
        } catch (Exception exception) {
            throw new TmdbMappingException(
                    "Failed to map TMDB response to " + responseType.getSimpleName(),
                    exception
            );
        }
    }
}
