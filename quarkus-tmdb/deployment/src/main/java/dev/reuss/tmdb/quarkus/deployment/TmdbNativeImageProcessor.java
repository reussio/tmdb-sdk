package dev.reuss.tmdb.quarkus.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.builditem.IndexDependencyBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;
import org.jboss.jandex.DotName;
import org.jboss.jandex.IndexView;

import java.util.Set;
import java.util.TreeSet;

/**
 * Registers TMDB SDK model classes for native-image reflection.
 */
public class TmdbNativeImageProcessor {

    private static final DotName TMDB_MODEL = DotName.createSimple("dev.reuss.tmdb.common.TmdbModel");
    private static final String TMDB_ERROR_RESPONSE = "dev.reuss.tmdb.core.exception.TmdbErrorResponse";

    @BuildStep
    IndexDependencyBuildItem indexTmdbCore() {
        return new IndexDependencyBuildItem("dev.reuss.tmdb", "tmdb-core");
    }

    @BuildStep
    void registerTmdbModelsForReflection(
            CombinedIndexBuildItem combinedIndex,
            BuildProducer<ReflectiveClassBuildItem> reflectiveClasses
    ) {
        Set<String> classNames = reflectionClassNames(combinedIndex.getIndex());

        if (!classNames.isEmpty()) {
            reflectiveClasses.produce(ReflectiveClassBuildItem.builder(classNames)
                    .constructors(true)
                    .methods(true)
                    .fields(true)
                    .reason("TMDB SDK Jackson model deserialization")
                    .build());
        }
    }

    static Set<String> reflectionClassNames(IndexView index) {
        Set<String> classNames = new TreeSet<>();

        index.getAllKnownImplementations(TMDB_MODEL)
                .stream()
                .filter(classInfo -> !classInfo.isInterface())
                .filter(classInfo -> !classInfo.isAbstract())
                .map(classInfo -> classInfo.name().toString())
                .filter(className -> className.startsWith("dev.reuss.tmdb."))
                .forEach(classNames::add);

        classNames.add(TMDB_ERROR_RESPONSE);

        return classNames;
    }
}
