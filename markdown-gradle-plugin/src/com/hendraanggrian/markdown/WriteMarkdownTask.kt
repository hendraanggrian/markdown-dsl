package com.hendraanggrian.markdown

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.IOException

open class WriteMarkdownTask : DefaultTask() {

    @Input lateinit var markdowns: Map<File, String>

    @TaskAction
    @Throws(IOException::class)
    @Suppress("unused")
    fun write() = markdowns.forEach { (file, content) ->
        file.writeText(content)
    }
}