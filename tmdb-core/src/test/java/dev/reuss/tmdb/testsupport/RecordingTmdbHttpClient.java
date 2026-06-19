package dev.reuss.tmdb.testsupport;

import dev.reuss.tmdb.core.http.TmdbHttpClient;
import dev.reuss.tmdb.core.http.TmdbRequest;

import java.util.Objects;

public final class RecordingTmdbHttpClient implements TmdbHttpClient {

    private TmdbRequest lastRequest;
    private Class<?> lastResponseType;
    private Object response;
    private int calls;

    public RecordingTmdbHttpClient() {
    }

    public RecordingTmdbHttpClient respondWith(Object response) {
        this.response = response;
        return this;
    }

    @Override
    public <T> T get(TmdbRequest request, Class<T> responseType) {
        this.lastRequest = Objects.requireNonNull(request, "TMDB request must not be null");
        this.lastResponseType = Objects.requireNonNull(responseType, "Response type must not be null");
        this.calls++;
        return responseType.cast(response);
    }

    public TmdbRequest lastRequest() {
        return lastRequest;
    }

    public Class<?> lastResponseType() {
        return lastResponseType;
    }

    public int calls() {
        return calls;
    }
}
