package com.hendraanggrian.markdown

/** Markdown syntax as seen in `https://daringfireball.net/projects/markdown/syntax`. */
interface MarkdownBuilder : ParagraphBuilder, HeaderBuilder, BlockquoteBuilder, ListBuilder

@PublishedApi
@Suppress("ClassName")
internal class _MarkdownBuilder(override val isPrettyPrint: Boolean) : MarkdownBuilder {

    override val sb = StringBuilder()

    override fun toString(): String = sb.toString()
}