package com.hendraanggrian.markdown

import com.hendraanggrian.markdown.internal.MarkdownBuilderImpl

inline fun buildMarkdown(
    isPrettyPrint: Boolean = false,
    builder: MarkdownBuilder.() -> Unit
): String = MarkdownBuilderImpl(isPrettyPrint).apply(builder).toString()