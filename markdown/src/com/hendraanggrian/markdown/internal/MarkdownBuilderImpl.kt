package com.hendraanggrian.markdown.internal

import com.hendraanggrian.markdown.MarkdownBuilder

class MarkdownBuilderImpl(override val isPrettyPrint: Boolean) : MarkdownBuilder {

    override val sb = StringBuilder()

    override fun toString(): String = sb.toString()
}