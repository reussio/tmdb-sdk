package dev.reuss.tmdb.core.http;

import com.sun.net.httpserver.HttpServer;
import dev.reuss.tmdb.core.auth.TmdbAuth;
import dev.reuss.tmdb.core.config.TmdbClientConfig;
import dev.reuss.tmdb.core.exception.*;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JavaNetTmdbHttpClientTest {

    private HttpServer server;
    private String lastRequestUri;
    private String lastAuthorizationHeader;

    @AfterEach
    void stopServer() {
        if (server != null) {
            server.stop(0);
        }
    }

    @Test
    void mapsHttpErrorResponsesToSdkExceptions() throws Exception {
        assertHttpStatusMapsTo(401, TmdbUnauthorizedException.class);
        assertHttpStatusMapsTo(403, TmdbUnauthorizedException.class);
        assertHttpStatusMapsTo(404, TmdbNotFoundException.class);
        assertHttpStatusMapsTo(429, TmdbRateLimitException.class);
        assertHttpStatusMapsTo(500, TmdbServerException.class);
        assertHttpStatusMapsTo(502, TmdbServerException.class);
        assertHttpStatusMapsTo(503, TmdbServerException.class);
        assertHttpStatusMapsTo(504, TmdbServerException.class);
        assertHttpStatusMapsTo(418, TmdbApiException.class);
    }

    @Test
    void mapsInvalidJsonFromSuccessfulResponseToMappingException() throws Exception {
        startServer(200, "{ invalid-json");

        JavaNetTmdbHttpClient client = new JavaNetTmdbHttpClient(config(serverBaseUrl()));

        assertThrows(TmdbMappingException.class, () -> client.get(TmdbRequest.get("/movie/550"), SuccessResponse.class));
    }

    @Test
    void wrapsIoFailuresInClientException() {
        JavaNetTmdbHttpClient client = new JavaNetTmdbHttpClient(config("http://127.0.0.1:9"));

        assertThrows(TmdbClientException.class, () -> client.get(TmdbRequest.get("/movie/550"), SuccessResponse.class));
    }

    @Test
    void sendsAuthorizationHeaderAndEncodesQuery() throws Exception {
        startServer(200, "{\"id\":550}");

        JavaNetTmdbHttpClient client = new JavaNetTmdbHttpClient(config(serverBaseUrl()));
        SuccessResponse response = client.get(
                TmdbRequest.get("/movie/550", QueryParams.create().add("query", "Fight Club")),
                SuccessResponse.class
        );

        assertEquals(550, response.id());
        assertEquals("/movie/550?query=Fight+Club", lastRequestUri);
        assertEquals("Bearer test-token", lastAuthorizationHeader);
    }

    private void assertHttpStatusMapsTo(int status, Class<? extends TmdbApiException> exceptionType) throws Exception {
        startServer(status, """
                {
                  "success": false,
                  "status_code": %d,
                  "status_message": "mapped error"
                }
                """.formatted(status));

        JavaNetTmdbHttpClient client = new JavaNetTmdbHttpClient(config(serverBaseUrl()));

        TmdbApiException exception = assertThrows(TmdbApiException.class,
                () -> client.get(TmdbRequest.get("/failing"), SuccessResponse.class));

        assertInstanceOf(exceptionType, exception);
        assertEquals(status, exception.httpStatus());

        stopServer();
        server = null;
    }

    private void startServer(int status, String body) throws IOException {
        stopServer();
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/", exchange -> {
            lastRequestUri = exchange.getRequestURI().toString();
            lastAuthorizationHeader = exchange.getRequestHeaders().getFirst("Authorization");
            byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(status, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.close();
        });
        server.start();
    }

    private String serverBaseUrl() {
        return "http://127.0.0.1:" + server.getAddress().getPort();
    }

    private static TmdbClientConfig config(String baseUrl) {
        return new TmdbClientConfig(
                TmdbAuth.bearerToken("test-token"),
                baseUrl,
                Language.of("en-US"),
                null,
                Duration.ofSeconds(1),
                Duration.ofSeconds(1)
        );
    }

    private record SuccessResponse(int id) {
    }
}
