package com.hendraanggrian.markdown

import com.hendraanggrian.markdown.internal.MarkdownBuilderImpl
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke
import java.io.File

open class MarkdownExtension(val project: Project) {

    internal val markdowns: MutableMap<File, String> = mutableMapOf()

    var isPrettyPrint: Boolean = false

    fun write(file: File, action: Action<MarkdownBuilder>) {
        markdowns[file] = MarkdownBuilderImpl(isPrettyPrint).also { action(it) }.toString()
    }

    fun write(fileName: String, action: Action<MarkdownBuilder>) =
        write(project.projectDir.resolve("$fileName.md"), action)

    fun write(vararg paths: String, action: Action<MarkdownBuilder>) {
        check(paths.isNotEmpty()) { "Can't use empty paths" }
        var file = project.projectDir
        paths.dropLast(1).forEach {
            file = file.resolve(it)
        }
        write(file.resolve("${paths.last()}.md"), action)
    }
}