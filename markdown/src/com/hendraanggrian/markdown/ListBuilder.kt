package com.hendraanggrian.markdown

import com.hendraanggrian.markdown.internal.MarkdownBuilderImpl

interface ListBuilder : BaseMarkdownBuilder {

    fun list(bulletType: BulletType = BulletType.ASTERISK, builder: ListItemBuilder.() -> Unit) =
        UnorderedListItemBuilder(isPrettyPrint, "${bulletType.char}").apply(builder)
            .sb.lines()
            .forEach { sb.appendln(it) }

    fun orderedList(builder: ListItemBuilder.() -> Unit) =
        OrderedListItemBuilder(isPrettyPrint).apply(builder)
            .sb.lines()
            .forEach { sb.appendln(it) }

    enum class BulletType(val char: Char) {
        ASTERISK('*'),
        PLUS('+'),
        HYPHEN('-');
    }

    interface ListItemBuilder : BaseMarkdownBuilder {

        val prefix: String

        fun item(value: String) {
            sb.appendln("$prefix $value")
        }

        fun item(value: String, builder: MarkdownBuilder.() -> Unit) {
            val prefix = prefix
            sb.appendln("$prefix $value")
            sb.appendln()
            val lines = MarkdownBuilderImpl(isPrettyPrint).apply(builder).sb.lines().toMutableList()
            // merge newlines
            lines.forEachIndexed { index, line ->
                if (index != lines.lastIndex &&
                    line.isBlank() &&
                    lines[index + 1].isBlank()
                ) {
                    lines.removeAt(index)
                }
            }
            lines.forEach {
                when {
                    it.isBlank() -> sb.appendln()
                    else -> {
                        val blankPrefix = prefix.map { " " }.joinToString("") + " "
                        sb.appendln("$blankPrefix$it")
                    }
                }
            }
        }
    }

    private class UnorderedListItemBuilder(override val isPrettyPrint: Boolean, override val prefix: String) :
        ListItemBuilder {

        override val sb = StringBuilder()

        override fun toString(): String = sb.toString()
    }

    private class OrderedListItemBuilder(override val isPrettyPrint: Boolean) : ListItemBuilder {
        private var index: Int = 1

        override val prefix: String get() = "${index++}."

        override val sb = StringBuilder()

        override fun toString(): String = sb.toString()
    }
}