package com.hendraanggrian.markdown

interface BlockquoteBuilder : BaseMarkdownBuilder {

    fun blockquote(blockquote: String) = appendln("${getBlockquotePrefix(isPrettyPrint)}$blockquote")

    fun blockquote(builder: MarkdownBuilder.() -> Unit) = _MarkdownBuilder(isPrettyPrint).apply(builder)
        .sb.lines()
        .map { getBlockquotePrefix(isPrettyPrint) }
        .forEach { appendln(it) }

    fun getBlockquotePrefix(isPrettyPrint: Boolean) = if (isPrettyPrint) "> " else ">"
}