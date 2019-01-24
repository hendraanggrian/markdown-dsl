package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class BlockquoteTest {

    @Test
    fun blockquoteLine() {
        assertEquals(
            ">Hello world",
            buildMarkdown {
                blockquote("Hello world")
            }.content.trim()
        )
        assertEquals(
            "> Hello world",
            buildMarkdown(true) {
                blockquote("Hello world")
            }.content.trim()
        )
    }

    @Test
    fun blockquote() {
        assertEquals(
            ">Hello\n" +
                ">=\n" +
                ">world",
            buildMarkdown {
                blockquote {
                    firstHeader("Hello")
                    paragraph("world")
                }
            }.content.trim()
        )
        assertEquals(
            "> Hello\n" +
                "> =====\n" +
                "> world",
            buildMarkdown(true) {
                blockquote {
                    firstHeader("Hello")
                    paragraph("world")
                }
            }.content.trim()
        )
    }

    @Test
    fun nestedBlockquote() {
        assertEquals(
            ">Hello\n" +
                ">>world\n" +
                ">I'm fine",
            buildMarkdown {
                blockquote {
                    paragraph("Hello")
                    blockquote {
                        paragraph("world")
                    }
                    paragraph("I'm fine")
                }
            }.content.trim()
        )
        assertEquals(
            "> Hello\n" +
                "> > world\n" +
                "> I'm fine",
            buildMarkdown(true) {
                blockquote {
                    paragraph("Hello")
                    blockquote {
                        paragraph("world")
                    }
                    paragraph("I'm fine")
                }
            }.content.trim()
        )
    }
}