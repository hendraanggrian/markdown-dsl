buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(files("markdown-0.1.jar"))
        classpath(files("markdown-github-0.1.jar"))
        classpath(files("markdown-gradle-plugin-0.1.jar"))
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
        classpath(bintray())
        classpath(bintrayRelease())
    }
}

allprojects {
    repositories {
        jcenter()
    }
    tasks {
        withType<Delete> {
            delete(projectDir.resolve("out"))
        }
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
}

tasks {
    register<Delete>("clean") {
        delete(buildDir)
    }
    named<Wrapper>("wrapper") {
        gradleVersion = VERSION_GRADLE
    }
}