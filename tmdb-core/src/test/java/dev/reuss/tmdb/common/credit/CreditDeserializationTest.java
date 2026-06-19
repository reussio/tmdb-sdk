package dev.reuss.tmdb.common.credit;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.reuss.tmdb.domain.movie.model.MovieCredits;
import dev.reuss.tmdb.domain.tv.episode.model.TvEpisodeCredits;
import dev.reuss.tmdb.domain.tv.series.model.TvSeriesCredits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CreditDeserializationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void movieCreditsExposeMovieSpecificCastId() throws Exception {
        MovieCredits credits = objectMapper.readValue("""
                {
                  "id": 550,
                  "cast": [
                    {
                      "adult": false,
                      "gender": 2,
                      "id": 819,
                      "known_for_department": "Acting",
                      "name": "Edward Norton",
                      "original_name": "Edward Norton",
                      "popularity": 22.5,
                      "profile_path": "/profile.jpg",
                      "cast_id": 4,
                      "character": "Narrator",
                      "credit_id": "52fe4250c3a36847f80149f3",
                      "order": 0
                    }
                  ]
                }
                """, MovieCredits.class);

        CastCredit cast = credits.cast().getFirst();

        assertEquals(4, cast.castId());
    }

    @Test
    void tvSeriesCreditsShareCastModelWithoutMovieCastId() throws Exception {
        TvSeriesCredits credits = objectMapper.readValue("""
                {
                  "id": 1399,
                  "cast": [
                    {
                      "adult": false,
                      "gender": 2,
                      "id": 22970,
                      "known_for_department": "Acting",
                      "name": "Peter Dinklage",
                      "original_name": "Peter Dinklage",
                      "popularity": 32.4,
                      "profile_path": "/dinklage.jpg",
                      "character": "Tyrion Lannister",
                      "credit_id": "5256c8b219c2956ff60479f6",
                      "order": 0
                    }
                  ]
                }
                """, TvSeriesCredits.class);

        CastCredit cast = credits.cast().getFirst();

        assertNull(cast.castId());
    }

    @Test
    void tvEpisodeCreditsExposeGuestStars() throws Exception {
        TvEpisodeCredits credits = objectMapper.readValue("""
                {
                  "id": 63056,
                  "guest_stars": [
                    {
                      "adult": false,
                      "gender": 2,
                      "id": 144336,
                      "known_for_department": "Acting",
                      "name": "Ian McElhinney",
                      "original_name": "Ian McElhinney",
                      "popularity": 5.5,
                      "profile_path": "/ian.jpg",
                      "character": "Barristan Selmy",
                      "credit_id": "5256c8bc19c2956ff6047b28",
                      "order": 10
                    }
                  ]
                }
                """, TvEpisodeCredits.class);

        GuestStarCredit guestStar = credits.guestStars().getFirst();

        assertEquals("Barristan Selmy", guestStar.character());
    }
}
