package com.hendraanggrian.markdown

interface ParagraphBuilder : BaseMarkdownBuilder {

    fun paragraph(paragraph: String) {
        sb.appendln(paragraph)
        sb.appendln()
    }
}