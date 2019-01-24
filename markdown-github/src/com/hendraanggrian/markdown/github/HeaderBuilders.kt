package com.hendraanggrian.markdown.github

import com.hendraanggrian.markdown.BaseMarkdownBuilder

fun BaseMarkdownBuilder.h1(header: String) = appendln("# $header")

fun BaseMarkdownBuilder.h2(header: String) = appendln("## $header")

fun BaseMarkdownBuilder.h3(header: String) = appendln("### $header")

fun BaseMarkdownBuilder.h4(header: String) = appendln("### $header")

fun BaseMarkdownBuilder.h5(header: String) = appendln("#### $header")

fun BaseMarkdownBuilder.h6(header: String) = appendln("##### $header")