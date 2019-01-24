package com.hendraanggrian.markdown

interface ParagraphBuilder : BaseMarkdownBuilder {

    fun paragraph(paragraph: String) {
        appendln(paragraph)
        appendln()
    }
}