package dev.reuss.tmdb.query

import dev.reuss.tmdb.domain.movie.MovieAppend
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.InvocationTargetException

class AppendToResponseTest {
    @Test
    fun serializesValuesInStableOrder() {
        val append =
            AppendToResponse.of(
                MovieAppend.CREDITS,
                MovieAppend.WATCH_PROVIDERS,
                MovieAppend.VIDEOS,
            )

        assertEquals("credits,watch/providers,videos", append.toString())
    }

    @Test
    fun removesDuplicateValues() {
        val append =
            AppendToResponse.of(
                MovieAppend.CREDITS,
                MovieAppend.VIDEOS,
                MovieAppend.CREDITS,
            )

        assertEquals("credits,videos", append.toString())
        assertEquals(2, append.values.size)
    }

    @Test
    fun rejectsMissingInvalidOrTooManyValues() {
        assertThrows<NullPointerException> {
            invokeOf(null)
        }

        assertThrows<IllegalArgumentException> {
            AppendToResponse.of<MovieAppend>()
        }

        assertThrows<NullPointerException> {
            invokeOf(
                arrayOf(
                    MovieAppend.CREDITS,
                    null,
                ),
            )
        }

        assertThrows<IllegalArgumentException> {
            AppendToResponse.of(*TestAppend.entries.toTypedArray())
        }
    }

    private fun invokeOf(values: Array<out AppendableResponse?>?) {
        val method =
            AppendToResponse::class.java.methods
                .single {
                    it.name == "of" &&
                        it.parameterCount == 1
                }

        try {
            method.invoke(null, values)
        } catch (exception: InvocationTargetException) {
            throw exception.targetException
        }
    }

    private enum class TestAppend(
        override val value: String,
        override val responseType: Class<*>,
    ) : AppendableResponse {
        V01("v01", Any::class.java),
        V02("v02", Any::class.java),
        V03("v03", Any::class.java),
        V04("v04", Any::class.java),
        V05("v05", Any::class.java),
        V06("v06", Any::class.java),
        V07("v07", Any::class.java),
        V08("v08", Any::class.java),
        V09("v09", Any::class.java),
        V10("v10", Any::class.java),
        V11("v11", Any::class.java),
        V12("v12", Any::class.java),
        V13("v13", Any::class.java),
        V14("v14", Any::class.java),
        V15("v15", Any::class.java),
        V16("v16", Any::class.java),
        V17("v17", Any::class.java),
        V18("v18", Any::class.java),
        V19("v19", Any::class.java),
        V20("v20", Any::class.java),
        V21("v21", Any::class.java),
    }
}
