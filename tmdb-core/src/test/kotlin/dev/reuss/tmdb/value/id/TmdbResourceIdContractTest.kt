package dev.reuss.tmdb.value.id

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.lang.reflect.InvocationTargetException
import java.util.stream.Stream

class TmdbResourceIdContractTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("numericIds")
    fun numericResourceIdsAcceptPositiveValues(idCase: NumericIdCase) {
        val id = idCase.create(42)

        assertInstanceOf(TmdbResourceId::class.java, id)
        assertEquals(42, id.asString().toInt())
        assertEquals("42", id.asString())
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("numericIds")
    fun numericResourceIdsRejectZeroAndNegativeValues(idCase: NumericIdCase) {
        assertThrows<IllegalArgumentException> {
            idCase.create(0)
        }

        assertThrows<IllegalArgumentException> {
            idCase.create(-1)
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("stringIds")
    fun stringResourceIdsAcceptNonBlankValues(idCase: StringIdCase) {
        val id = idCase.create("  stable-id  ")

        assertInstanceOf(TmdbResourceId::class.java, id)
        assertEquals("stable-id", id.asString())
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("stringIds")
    fun stringResourceIdsRejectNullEmptyAndBlankValues(idCase: StringIdCase) {
        assertThrows<NullPointerException> {
            idCase.createWithNull()
        }

        assertThrows<IllegalArgumentException> {
            idCase.create("")
        }

        assertThrows<IllegalArgumentException> {
            idCase.create("   ")
        }
    }

    private fun StringIdCase.createWithNull() {
        try {
            type
                .getMethod("of", String::class.java)
                .invoke(null, *arrayOf<Any?>(null))
        } catch (exception: InvocationTargetException) {
            throw exception.targetException
        }
    }

    data class NumericIdCase(
        val name: String,
        val factory: (Int) -> TmdbResourceId,
    ) {
        fun create(value: Int): TmdbResourceId = factory(value)

        override fun toString(): String = name
    }

    data class StringIdCase(
        val name: String,
        val type: Class<out TmdbResourceId>,
        val factory: (String) -> TmdbResourceId,
    ) {
        fun create(value: String): TmdbResourceId = factory(value)

        override fun toString(): String = name
    }

    companion object {
        @JvmStatic
        fun numericIds(): Stream<NumericIdCase> =
            Stream.of(
                NumericIdCase("MovieId", MovieId::of),
                NumericIdCase("TvShowId", TvShowId::of),
                NumericIdCase("TvSeasonId", TvSeasonId::of),
                NumericIdCase("TvEpisodeId", TvEpisodeId::of),
                NumericIdCase("PersonId", PersonId::of),
                NumericIdCase("CompanyId", CompanyId::of),
                NumericIdCase("NetworkId", NetworkId::of),
                NumericIdCase("KeywordId", KeywordId::of),
            )

        @JvmStatic
        fun stringIds(): Stream<StringIdCase> =
            Stream.of(
                StringIdCase("CreditId", CreditId::class.java, CreditId::of),
                StringIdCase("ReviewId", ReviewId::class.java, ReviewId::of),
                StringIdCase("ExternalId", ExternalId::class.java, ExternalId::of),
                StringIdCase(
                    "TvEpisodeGroupId",
                    TvEpisodeGroupId::class.java,
                    TvEpisodeGroupId::of,
                ),
            )
    }
}
