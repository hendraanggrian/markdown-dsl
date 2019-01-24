package com.hendraanggrian.markdown

import java.io.File

class Markdown(val content: String) {

    fun writeTo(file: File) = file.writeText(content)
}

inline fun buildMarkdown(
    isPrettyPrint: Boolean = false,
    builder: MarkdownBuilder.() -> Unit
): Markdown = Markdown(_MarkdownBuilder(isPrettyPrint).apply(builder).toString())