package dev.reuss.tmdb.value.id;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TmdbResourceIdContractTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("numericIds")
    void numericResourceIdsAcceptPositiveValues(NumericIdCase idCase) {
        TmdbResourceId id = idCase.create(42);

        assertInstanceOf(TmdbResourceId.class, id);
        assertEquals(42, Integer.valueOf(id.asString()));
        assertEquals("42", id.asString());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("numericIds")
    void numericResourceIdsRejectZeroAndNegativeValues(NumericIdCase idCase) {
        assertThrows(IllegalArgumentException.class, () -> idCase.create(0));
        assertThrows(IllegalArgumentException.class, () -> idCase.create(-1));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("stringIds")
    void stringResourceIdsAcceptNonBlankValues(StringIdCase idCase) {
        Object id = idCase.create("  stable-id  ");

        assertInstanceOf(TmdbResourceId.class, id);
        assertEquals("stable-id", idCase.asString(id));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("stringIds")
    void stringResourceIdsRejectNullEmptyAndBlankValues(StringIdCase idCase) {
        assertThrows(IllegalArgumentException.class, () -> idCase.create(null));
        assertThrows(IllegalArgumentException.class, () -> idCase.create(""));
        assertThrows(IllegalArgumentException.class, () -> idCase.create("   "));
    }

    static Stream<NumericIdCase> numericIds() {
        return Stream.of(
                new NumericIdCase("MovieId", MovieId::of),
                new NumericIdCase("TvShowId", TvShowId::of),
                new NumericIdCase("TvSeasonId", TvSeasonId::of),
                new NumericIdCase("TvEpisodeId", TvEpisodeId::of),
                new NumericIdCase("PersonId", PersonId::of),
                new NumericIdCase("CompanyId", CompanyId::of),
                new NumericIdCase("NetworkId", NetworkId::of),
                new NumericIdCase("KeywordId", KeywordId::of)
        );
    }

    static Stream<StringIdCase> stringIds() {
        return Stream.of(
                new StringIdCase("CreditId", CreditId::of, id -> ((CreditId) id).asString()),
                new StringIdCase("ReviewId", ReviewId::of, id -> ((ReviewId) id).asString()),
                new StringIdCase("ExternalId", ExternalId::of, id -> ((ExternalId) id).asString()),
                new StringIdCase("TvEpisodeGroupId", TvEpisodeGroupId::of, id -> ((TvEpisodeGroupId) id).asString())
        );
    }

    private record NumericIdCase(String name, IntFunction<TmdbResourceId> factory) {

        TmdbResourceId create(int value) {
            return factory.apply(value);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private record StringIdCase(String name, Function<String, Object> factory, Function<Object, String> asString) {

        Object create(String value) {
            return factory.apply(value);
        }

        String asString(Object id) {
            return asString.apply(id);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
