package com.hendraanggrian.markdown

interface HeaderBuilder : BaseMarkdownBuilder {

    fun firstHeader(header: String) = setHeader(header, '=')

    fun secondHeader(header: String) = setHeader(header, '-')

    @Suppress("NOTHING_TO_INLINE")
    private inline fun setHeader(header: String, char: Char) {
        sb.appendln(header)
        when {
            isPrettyPrint -> sb.appendln(header.map { char }.joinToString(""))
            else -> sb.appendln(char)
        }
    }
}