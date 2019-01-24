package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class ListTest {

    @Test
    fun list() {
        assertEquals(
            """
                * Hello
                * world
            """.trimIndent(),
            buildMarkdown {
                list {
                    item("Hello")
                    item("world")
                }
            }.trim()
        )
    }

    @Test
    fun orderedList() {
        assertEquals(
            """
                1. Hello
                2. world
            """.trimIndent(),
            buildMarkdown {
                orderedList {
                    item("Hello")
                    item("world")
                }
            }
        )
    }

    @Test
    fun multiParagraphList() {
        assertEquals(
            """
                * Hello

                  Hello

                * world
            """.trimIndent(),
            buildMarkdown {
                list {
                    item("Hello") {
                        paragraph("Hello")
                    }
                    item("world")
                }
            }
        )
        assertEquals(
            """
                1. Hello

                   Hello

                2. world
            """.trimIndent(),
            buildMarkdown {
                orderedList {
                    item("Hello") {
                        paragraph("Hello")
                    }
                    item("world")
                }
            }
        )
    }
}