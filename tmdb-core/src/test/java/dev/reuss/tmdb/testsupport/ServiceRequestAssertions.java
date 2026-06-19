package dev.reuss.tmdb.testsupport;

import dev.reuss.tmdb.core.http.TmdbRequest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class ServiceRequestAssertions {

    private ServiceRequestAssertions() {
    }

    public static void assertLastRequest(
            RecordingTmdbHttpClient httpClient,
            String path,
            Map<String, String> queryParams,
            Class<?> responseType
    ) {
        TmdbRequest request = httpClient.lastRequest();

        assertEquals(path, request.path());
        assertEquals(queryParams, request.queryParams());
        assertEquals(responseType, httpClient.lastResponseType());
        assertEquals(1, httpClient.calls());
    }
}
