group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka()
    id("com.jfrog.bintray")
    id("com.novoda.bintray-release")
    id("org.ajoberstar.git-publish")
}

sourceSets {
    getByName("main") {
        java.srcDir("src")
        resources.srcDir("res")
    }
    get("test").java.srcDir("tests/src")
}

val configuration = configurations.register("ktlint")

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))

    testImplementation(kotlin("test", VERSION_KOTLIN))
    testImplementation(junit())
    testImplementation(truth())

    configuration {
        invoke(ktlint())
    }
}

tasks {
    val ktlint = register("ktlint", JavaExec::class) {
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        inputs.dir("src")
        outputs.dir("src")
        description = "Check Kotlin code style."
        classpath(configuration.get())
        main = "com.github.shyiko.ktlint.Main"
        args("src/**/*.kt")
    }
    "check" {
        dependsOn(ktlint.get())
    }
    register("ktlintFormat", JavaExec::class) {
        group = "formatting"
        inputs.dir("src")
        outputs.dir("src")
        description = "Fix Kotlin code style deviations."
        classpath(configuration.get())
        main = "com.github.shyiko.ktlint.Main"
        args("-F", "src/**/*.kt")
    }

    named<org.jetbrains.dokka.gradle.DokkaTask>("dokka") {
        outputDirectory = "$buildDir/docs"
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = RELEASE_ARTIFACT
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEBSITE
}