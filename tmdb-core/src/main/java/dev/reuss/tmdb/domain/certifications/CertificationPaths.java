package dev.reuss.tmdb.domain.certifications;

final class CertificationPaths {

    private static final String CERTIFICATION = "/certification";

    private CertificationPaths() {
    }

    static String movieCertifications() {
        return CERTIFICATION + "/movie/list";
    }

    static String tvCertifications() {
        return CERTIFICATION + "/tv/list";
    }
}