package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class HeaderTest {

    @Test
    fun firstHeader() {
        assertEquals(
            """
                Hello world
                =
            """.trimIndent(),
            buildMarkdown {
                header("Hello world")
            }.trim()
        )
        assertEquals(
            """
                Hello world
                ===========
            """.trimIndent(),
            buildMarkdown(true) {
                header("Hello world")
            }.trim()
        )
    }

    @Test
    fun secondHeader() {
        assertEquals(
            """
                Hello world
                -
            """.trimIndent(),
            buildMarkdown {
                subheader("Hello world")
            }.trim()
        )
        assertEquals(
            """
                Hello world
                -----------
            """.trimIndent(),
            buildMarkdown(true) {
                subheader("Hello world")
            }.trim()
        )
    }
}