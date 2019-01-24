package com.hendraanggrian.markdown

interface BaseMarkdownBuilder {

    val isPrettyPrint: Boolean

    fun append(value: Any)

    fun append(value: String)

    fun append(value: Char)

    fun appendln(value: String)

    fun appendln(value: Char)

    fun appendln()

    override fun toString(): String
}