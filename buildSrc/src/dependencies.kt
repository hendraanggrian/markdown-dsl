import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

fun DependencyHandler.kotlinx(
    module: String,
    version: String? = null
) = "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" } ?: ""}"

fun DependencyHandler.dokka(module: String? = null) =
    "org.jetbrains.dokka:dokka-${module.wrap { "$it-" }}gradle-plugin:$VERSION_DOKKA"

fun PluginDependenciesSpec.dokka(module: String? = null) =
    id("org.jetbrains.dokka${module.wrap { "-$it" }}")

fun DependencyHandler.hendraanggrian(
    repository: String,
    module: String = repository,
    version: String
) = "com.hendraanggrian.$repository:$module:$version"

fun DependencyHandler.apache(module: String, version: String) =
    "org.apache.${module.split("-")[0]}:$module:$version"

fun DependencyHandler.truth() = "com.google.truth:truth:0.42"

fun DependencyHandler.junit() = "junit:junit:4.12"

fun DependencyHandler.bintray() = "com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4"

fun DependencyHandler.bintrayRelease() = "com.novoda:bintray-release:0.9"

fun DependencyHandler.gitPublish() = "org.ajoberstar:gradle-git-publish:0.3.3"

fun DependencyHandler.ktlint(module: String? = null) = when (module) {
    null -> "com.github.shyiko:ktlint:0.29.0"
    else -> "com.github.shyiko.ktlint:ktlint-$module:0.29.0"
}

private fun String?.wrap(wrapper: (String) -> String) = this?.let(wrapper).orEmpty()