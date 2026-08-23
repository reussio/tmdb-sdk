package dev.reuss.tmdb.core.exception

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TmdbExceptionsTest {
    @ParameterizedTest(name = "HTTP {0} -> {1}")
    @MethodSource("exceptionMappings")
    fun from_shouldCreateSpecificException_whenHttpStatusIsKnown(
        httpStatus: Int,
        expectedType: Class<out TmdbApiException>,
    ) {
        val exception =
            TmdbExceptions.from(
                httpStatus,
                TmdbError.RESOURCE_NOT_FOUND.code,
                "failure",
                "response body",
            )

        assertInstanceOf(expectedType, exception)
        assertEquals(httpStatus, exception.httpStatus)
        assertEquals(TmdbError.RESOURCE_NOT_FOUND.code, exception.tmdbStatusCode)
        assertEquals("response body", exception.responseBody)
        assertEquals("failure", exception.message)
        assertSame(TmdbError.RESOURCE_NOT_FOUND, exception.error().orElseThrow())
    }

    @Test
    fun fromHttpStatus_shouldUseUnknownTmdbStatus_whenBodyCannotBeParsed() {
        val exception =
            TmdbExceptions.fromHttpStatus(
                418,
                "teapot",
                "not json",
            )

        assertEquals(0, exception.tmdbStatusCode)
        assertFalse(exception.error().isPresent)
    }

    @Test
    fun fromCode_shouldReturnKnownErrorAndEmptyForUnknownCode() {
        assertSame(TmdbError.RATE_LIMIT_EXCEEDED, TmdbError.fromCode(25).orElseThrow())
        assertFalse(TmdbError.fromCode(Int.MAX_VALUE).isPresent)
    }

    companion object {
        @JvmStatic
        fun exceptionMappings(): Stream<Arguments> =
            Stream.of(
                Arguments.of(401, TmdbUnauthorizedException::class.java),
                Arguments.of(403, TmdbUnauthorizedException::class.java),
                Arguments.of(404, TmdbNotFoundException::class.java),
                Arguments.of(429, TmdbRateLimitException::class.java),
                Arguments.of(500, TmdbServerException::class.java),
                Arguments.of(504, TmdbServerException::class.java),
                Arguments.of(400, TmdbApiException::class.java),
            )
    }
}
