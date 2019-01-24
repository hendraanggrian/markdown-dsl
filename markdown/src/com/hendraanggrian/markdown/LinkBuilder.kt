package com.hendraanggrian.markdown

interface LinkBuilder : BaseMarkdownBuilder {

    fun link(text: String, url: String) {
    }
}