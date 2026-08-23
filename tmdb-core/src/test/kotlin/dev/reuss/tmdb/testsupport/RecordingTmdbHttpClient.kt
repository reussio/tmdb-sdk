package dev.reuss.tmdb.testsupport

import dev.reuss.tmdb.core.http.TmdbHttpClient
import dev.reuss.tmdb.core.http.TmdbRequest

class RecordingTmdbHttpClient : TmdbHttpClient {
    private lateinit var lastRequest: TmdbRequest
    private lateinit var lastResponseType: Class<*>
    private var response: Any? = null
    private var calls: Int = 0

    fun respondWith(response: Any?) =
        apply {
            this.response = response
        }

    override fun <T> get(
        request: TmdbRequest,
        responseType: Class<T>,
    ): T {
        lastRequest = request
        lastResponseType = responseType
        calls++

        return responseType.cast(response)
    }

    fun lastRequest(): TmdbRequest = lastRequest

    fun lastResponseType(): Class<*> = lastResponseType

    fun calls(): Int = calls
}
