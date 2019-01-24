package com.hendraanggrian.markdown

interface CodeBlockBuilder : BaseMarkdownBuilder {

    fun codeBlock(codeBlock: String) = codeBlock.split('\n').forEach {
        sb.appendln("    $it")
    }
}