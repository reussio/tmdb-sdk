package dev.reuss.tmdb.domain.certifications

import dev.reuss.tmdb.domain.certifications.model.MovieCertifications
import dev.reuss.tmdb.domain.certifications.model.TvCertifications
import dev.reuss.tmdb.testsupport.assertRequest
import org.junit.jupiter.api.Test

class DefaultCertificationServiceTest {
    @Test
    fun certificationMethods_shouldUseExpectedPathsAndResponseTypes() {
        assertRequest<MovieCertifications>("/certification/movie/list") {
            DefaultCertificationService(it).movieCertifications()
        }
        assertRequest<TvCertifications>("/certification/tv/list") {
            DefaultCertificationService(it).tvCertifications()
        }
    }
}
