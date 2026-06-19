package dev.reuss.tmdb.common;

import dev.reuss.tmdb.common.genre.Genre;
import dev.reuss.tmdb.core.auth.TmdbAuth;
import dev.reuss.tmdb.core.http.TmdbRequest;
import dev.reuss.tmdb.domain.movie.MovieAppend;
import dev.reuss.tmdb.domain.search.query.SearchMovieQuery;
import dev.reuss.tmdb.query.AppendToResponse;
import dev.reuss.tmdb.value.id.CreditId;
import dev.reuss.tmdb.value.id.MovieId;
import dev.reuss.tmdb.value.language.Language;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class SerializableContractTest {

    @Test
    void representativeIdsAreSerializable() {
        assertInstanceOf(Serializable.class, MovieId.of(550));
        assertInstanceOf(Serializable.class, CreditId.of("credit-1"));
    }

    @Test
    void representativeValueObjectsAreSerializable() {
        assertInstanceOf(Serializable.class, TmdbAuth.bearerToken("token"));
        assertInstanceOf(Serializable.class, TmdbRequest.get("/movie/550"));
        assertInstanceOf(Serializable.class, Language.of("de-DE"));
    }

    @Test
    void representativeQueriesAreSerializable() {
        assertInstanceOf(Serializable.class, SearchMovieQuery.of("Fight Club"));
        assertInstanceOf(Serializable.class, AppendToResponse.of(MovieAppend.CREDITS));
    }

    @Test
    void representativeModelsUseSerializableMarker() {
        Genre genre = new Genre(18, "Drama");

        assertInstanceOf(TmdbModel.class, genre);
        assertInstanceOf(Serializable.class, genre);
    }
}
