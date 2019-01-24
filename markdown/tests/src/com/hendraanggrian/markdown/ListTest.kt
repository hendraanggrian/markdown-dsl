package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class ListTest {

    @Test
    fun list() {
        assertEquals(
            "* Hello\n" +
                "* world",
            buildMarkdown {
                list {
                    item("Hello")
                    item("world")
                }
            }.content.trim()
        )
    }

    @Test
    fun orderedList() {
        assertEquals(
            "1. Hello\n" +
                "2. world",
            buildMarkdown {
                orderedList {
                    item("Hello")
                    item("world")
                }
            }.content.trim()
        )
    }

    @Test
    fun multiParagraphList() {
        assertEquals(
            "* Hello\n" +
                "  \n" +
                "  Hello\n" +
                "  \n" +
                "* world",
            buildMarkdown {
                list {
                    item("Hello") {
                        paragraph("Hello")
                    }
                    item("world")
                }
            }.content.trim()
        )
        assertEquals(
            "1. Hello\n" +
                "   \n" +
                "   Hello\n" +
                "   \n" +
                "2. world",
            buildMarkdown {
                orderedList {
                    item("Hello") {
                        paragraph("Hello")
                    }
                    item("world")
                }
            }.content.trim()
        )
    }
}