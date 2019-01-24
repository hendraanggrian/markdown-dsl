package com.hendraanggrian.markdown

interface LinkBuilder : BaseMarkdownBuilder {

    fun url(text: String, url: String): String = "[$text]($url)"

    fun url(text: String, title: String, url: String): String = "[$text]($url \"$title\")"
}