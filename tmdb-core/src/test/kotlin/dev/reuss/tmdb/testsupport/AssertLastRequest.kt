package dev.reuss.tmdb.testsupport

import org.junit.jupiter.api.Assertions.assertEquals

fun assertLastRequest(
    httpClient: RecordingTmdbHttpClient,
    path: String,
    queryParams: Map<String, String>,
    responseType: Class<*>,
) {
    val request = httpClient.lastRequest()

    assertEquals(path, request.path)
    assertEquals(queryParams, request.queryParams)
    assertEquals(responseType, httpClient.lastResponseType())
    assertEquals(1, httpClient.calls())
}

inline fun <reified T> assertRequest(
    path: String,
    queryParams: Map<String, String> = emptyMap(),
    call: (RecordingTmdbHttpClient) -> Unit,
) {
    val httpClient = RecordingTmdbHttpClient()

    call(httpClient)

    assertLastRequest(
        httpClient,
        path,
        queryParams,
        T::class.java,
    )
}
