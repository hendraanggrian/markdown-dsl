package com.hendraanggrian.markdown

interface BlockquoteBuilder : BaseMarkdownBuilder {

    fun blockquote(blockquote: String) = sb.appendln("${getBlockquotePrefix(isPrettyPrint)}$blockquote")

    fun blockquote(builder: MarkdownBuilder.() -> Unit) = _MarkdownBuilder(isPrettyPrint).apply(builder)
        .sb.lines()
        .filter { it.isNotBlank() }
        .map { "${getBlockquotePrefix(isPrettyPrint)}$it" }
        .forEach { sb.appendln(it) }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun getBlockquotePrefix(isPrettyPrint: Boolean) = if (isPrettyPrint) "> " else ">"
}