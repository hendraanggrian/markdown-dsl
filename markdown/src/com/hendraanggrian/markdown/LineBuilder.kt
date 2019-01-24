package com.hendraanggrian.markdown

interface LineBuilder : BaseMarkdownBuilder {

    fun line(type: Type = Type.HYPHEN) {
        sb.appendln(
            when {
                isPrettyPrint -> "${type.char} ${type.char} ${type.char}"
                else -> "${type.char}${type.char}${type.char}"
            }
        )
    }

    enum class Type(val char: Char) {
        ASTERISK('*'),
        HYPHEN('-');
    }
}