package com.hendraanggrian.markdown

import com.hendraanggrian.markdown.internal.MarkdownBuilderImpl

interface BlockquoteBuilder : BaseMarkdownBuilder {

    fun blockquote(blockquote: String) = sb.appendln("${getBlockquotePrefix(isPrettyPrint)}$blockquote")

    fun blockquote(builder: MarkdownBuilder.() -> Unit) = MarkdownBuilderImpl(isPrettyPrint).apply(builder)
        .sb.lines()
        .filter { it.isNotBlank() }
        .map { "${getBlockquotePrefix(isPrettyPrint)}$it" }
        .forEach { sb.appendln(it) }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun getBlockquotePrefix(isPrettyPrint: Boolean) = if (isPrettyPrint) "> " else ">"
}