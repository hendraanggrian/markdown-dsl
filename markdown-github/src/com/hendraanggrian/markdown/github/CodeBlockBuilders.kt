package com.hendraanggrian.markdown.github

import com.hendraanggrian.markdown.BaseMarkdownBuilder

fun BaseMarkdownBuilder.codeBlock(language: String, codeBlock: String) {
    sb.appendln("```$language")
    codeBlock.split('\n').forEach {
        sb.appendln(it)
    }
    sb.appendln("```")
}