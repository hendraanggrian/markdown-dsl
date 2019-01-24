package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class BlockquoteTest {

    @Test
    fun blockquoteLine() {
        assertEquals(
            """
                >Hello world
            """.trimIndent(),
            buildMarkdown {
                blockquote("Hello world")
            }.trim()
        )
        assertEquals(
            """
                > Hello world
            """.trimIndent(),
            buildMarkdown(true) {
                blockquote("Hello world")
            }.trim()
        )
    }

    @Test
    fun blockquote() {
        assertEquals(
            """
                >Hello
                >=
                >world
            """.trimIndent(),
            buildMarkdown {
                blockquote {
                    header("Hello")
                    paragraph("world")
                }
            }.trim()
        )
        assertEquals(
            """
                > Hello
                > =====
                > world
            """.trimIndent(),
            buildMarkdown(true) {
                blockquote {
                    header("Hello")
                    paragraph("world")
                }
            }.trim()
        )
    }

    @Test
    fun nestedBlockquote() {
        assertEquals(
            """
                >Hello
                >>world
                >I'm fine
            """.trimIndent(),
            buildMarkdown {
                blockquote {
                    paragraph("Hello")
                    blockquote {
                        paragraph("world")
                    }
                    paragraph("I'm fine")
                }
            }.trim()
        )
        assertEquals(
            """
                > Hello
                > > world
                > I'm fine
            """.trimIndent(),
            buildMarkdown(true) {
                blockquote {
                    paragraph("Hello")
                    blockquote {
                        paragraph("world")
                    }
                    paragraph("I'm fine")
                }
            }.trim()
        )
    }
}