package com.hendraanggrian.markdown

interface ImageBuilder : BaseMarkdownBuilder {

    fun img(text: String, url: String): String = "![$text]($url)"

    fun img(text: String, title: String, url: String): String = "![$text]($url \"$title\")"
}