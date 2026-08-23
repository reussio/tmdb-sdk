package dev.reuss.tmdb

import com.sun.net.httpserver.HttpServer
import dev.reuss.tmdb.core.auth.TmdbAuth
import dev.reuss.tmdb.core.metrics.TmdbMetricsRecorder
import dev.reuss.tmdb.domain.movie.query.MoviePopularQuery
import dev.reuss.tmdb.value.language.Languages
import dev.reuss.tmdb.value.region.Regions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.net.InetSocketAddress
import java.time.Duration

class TmdbClientBuilderTest {
    private var server: HttpServer? = null

    @AfterEach
    fun stopServer() {
        server?.stop(0)
        server = null
    }

    @Test
    fun buildsTmdbClientWithAccessToken() {
        val client =
            TmdbClient
                .builder()
                .accessToken("token")
                .build()

        assertNotNull(client)
    }

    @Test
    fun buildsTmdbClientWithAuth() {
        val client =
            TmdbClient
                .builder()
                .auth(TmdbAuth.bearerToken("token"))
                .build()

        assertNotNull(client)
    }

    @Test
    fun build_shouldApplyRequestDefaultsAndAllowExplicitOverrides() {
        var rawQuery: String? = null
        val metrics = CountingMetricsRecorder()
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        server.createContext("/movie/popular") { exchange ->
            rawQuery = exchange.requestURI.rawQuery
            val body =
                """{"page":1,"results":[],"total_pages":1,"total_results":0}"""
                    .toByteArray()
            exchange.sendResponseHeaders(200, body.size.toLong())
            exchange.responseBody.use { it.write(body) }
        }
        server.start()
        this.server = server

        val client =
            TmdbClient
                .builder()
                .accessToken("token")
                .baseUrl("http://127.0.0.1:${server.address.port}")
                .defaultLanguage(Languages.DE_DE)
                .defaultRegion(Regions.DE)
                .connectTimeout(Duration.ofSeconds(1))
                .requestTimeout(Duration.ofSeconds(2))
                .metricsRecorder(metrics)
                .build()

        client.movies().popular()
        assertEquals("language=de-DE&region=DE", rawQuery)

        client
            .movies()
            .popular(
                MoviePopularQuery
                    .create()
                    .language(Languages.EN_US)
                    .region(Regions.US),
            )
        assertEquals("language=en-US&region=US", rawQuery)
        assertEquals(2, metrics.started)
        assertEquals(2, metrics.finished)

        TmdbClient
            .builder()
            .accessToken("token")
            .baseUrl("http://127.0.0.1:${server.address.port}")
            .build()
            .movies()
            .popular()
        assertEquals("language=en-US", rawQuery)
    }

    @Test
    fun rejectsMissingAuthOnBuild() {
        assertThrows<IllegalArgumentException> {
            TmdbClient.builder().build()
        }
    }

    @Test
    fun rejectsBlankAccessToken() {
        assertThrows<IllegalArgumentException> {
            TmdbClient.builder().accessToken("")
        }

        assertThrows<IllegalArgumentException> {
            TmdbClient.builder().accessToken("   ")
        }
    }

    @Test
    fun buildCreatesStableInstancesForEveryDomainService() {
        val client = TmdbClient.builder().accessToken("token").build()

        listOf(
            client.configuration(),
            client.imageUrls(),
            client.certifications(),
            client.companies(),
            client.credits(),
            client.discover(),
            client.find(),
            client.genres(),
            client.keywords(),
            client.networks(),
            client.reviews(),
            client.trending(),
            client.watchProviders(),
            client.search(),
            client.people(),
            client.tvSeries(),
            client.tvSeason(),
            client.tvEpisode(),
            client.tvEpisodeGroup(),
            client.movies(),
            client.collections(),
        ).forEach { service ->
            assertNotNull(service)
        }

        assertSame(client.configuration(), client.configuration())
        assertSame(client.movies(), client.movies())
        assertSame(client.tvSeries(), client.tvSeries())
    }

    @Test
    fun buildRejectsInvalidBaseUrlAndTimeouts() {
        assertThrows<IllegalArgumentException> {
            TmdbClient
                .builder()
                .accessToken("token")
                .baseUrl("   ")
                .build()
        }
        assertThrows<IllegalArgumentException> {
            TmdbClient
                .builder()
                .accessToken("token")
                .connectTimeout(Duration.ZERO)
                .build()
        }
        assertThrows<IllegalArgumentException> {
            TmdbClient
                .builder()
                .accessToken("token")
                .requestTimeout(Duration.ofSeconds(-1))
                .build()
        }
    }

    private class CountingMetricsRecorder : TmdbMetricsRecorder {
        var started = 0
        var finished = 0

        override fun recordRequestStarted(
            method: String,
            path: String,
        ) {
            started++
        }

        override fun recordRequestFinished(
            method: String,
            path: String,
            statusCode: Int,
            duration: Duration,
            responseBytes: Long,
        ) {
            finished++
        }
    }
}
