package com.hendraanggrian.markdown

interface BaseMarkdownBuilder {

    val sb: StringBuilder

    val isPrettyPrint: Boolean

    override fun toString(): String
}