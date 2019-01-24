package com.hendraanggrian.markdown

import java.io.File

class Markdown(val content: String) {

    fun writeTo(file: File) = file.writeText(content)
}

inline fun buildMarkdown(
    isPrettyPrint: Boolean = false,
    builder: MarkdownBuilder.() -> Unit
): Markdown = Markdown(_MarkdownBuilder(isPrettyPrint).apply(builder).toString())

/** Markdown syntax as seen in `https://daringfireball.net/projects/markdown/syntax`. */
interface MarkdownBuilder : ParagraphBuilder, HeaderBuilder// , BlockquoteBuilder

@PublishedApi
@Suppress("ClassName")
internal class _MarkdownBuilder(override val isPrettyPrint: Boolean) : MarkdownBuilder {
    val sb = StringBuilder()

    override fun append(value: Any) {
        sb.append(value)
    }

    override fun append(value: String) {
        sb.append(value)
    }

    override fun append(value: Char) {
        sb.append(value)
    }

    override fun appendln(value: String) {
        sb.appendln(value)
    }

    override fun appendln(value: Char) {
        sb.appendln(value)
    }

    override fun appendln() {
        sb.appendln()
    }

    override fun toString(): String = sb.toString()
}