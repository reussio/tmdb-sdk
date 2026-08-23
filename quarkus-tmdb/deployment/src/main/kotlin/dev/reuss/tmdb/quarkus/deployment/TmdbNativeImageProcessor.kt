package dev.reuss.tmdb.quarkus.deployment

import io.quarkus.deployment.annotations.BuildProducer
import io.quarkus.deployment.annotations.BuildStep
import io.quarkus.deployment.builditem.CombinedIndexBuildItem
import io.quarkus.deployment.builditem.IndexDependencyBuildItem
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem
import org.jboss.jandex.DotName
import org.jboss.jandex.IndexView
import java.util.TreeSet

/**
 * Registers TMDB SDK model classes for native-image reflection.
 */
class TmdbNativeImageProcessor {

    @BuildStep
    fun indexTmdbCore(): IndexDependencyBuildItem =
        IndexDependencyBuildItem(
            "dev.reuss.tmdb",
            "tmdb-core"
        )

    @BuildStep
    fun registerTmdbModelsForReflection(
        combinedIndex: CombinedIndexBuildItem,
        reflectiveClasses: BuildProducer<ReflectiveClassBuildItem>
    ) {
        val classNames = reflectionClassNames(combinedIndex.index)

        if (classNames.isNotEmpty()) {
            reflectiveClasses.produce(
                ReflectiveClassBuildItem.builder(classNames)
                    .constructors(true)
                    .methods(true)
                    .fields(true)
                    .reason("TMDB SDK Jackson model deserialization")
                    .build()
            )
        }
    }

    companion object {
        private val TMDB_MODEL =
            DotName.createSimple("dev.reuss.tmdb.common.TmdbModel")

        private const val TMDB_ERROR_RESPONSE =
            "dev.reuss.tmdb.core.exception.TmdbErrorResponse"

        @JvmStatic
        fun reflectionClassNames(index: IndexView): Set<String> {
            val classNames = TreeSet<String>()

            index.getAllKnownImplementations(TMDB_MODEL)
                .asSequence()
                .filterNot { it.isInterface }
                .filterNot { it.isAbstract }
                .map { it.name().toString() }
                .filter { it.startsWith("dev.reuss.tmdb.") }
                .forEach(classNames::add)

            classNames += TMDB_ERROR_RESPONSE

            return classNames
        }
    }
}