package com.hendraanggrian.markdown

/** Markdown syntax as seen in `https://daringfireball.net/projects/markdown/syntax`. */
interface MarkdownBuilder : ParagraphBuilder,
    HeaderBuilder,
    BlockquoteBuilder,
    ListBuilder,
    CodeBlockBuilder,
    LineBuilder,
    LinkBuilder,
    ImageBuilder