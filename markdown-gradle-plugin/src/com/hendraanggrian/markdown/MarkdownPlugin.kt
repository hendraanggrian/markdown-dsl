package com.hendraanggrian.markdown

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

@Suppress("unused")
class MarkdownPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val ext = project.extensions.create<MarkdownExtension>("markdown", project)
        project.tasks.register("writeMarkdowns", WriteMarkdownTask::class) {
            markdowns = ext.markdowns
        }
    }
}