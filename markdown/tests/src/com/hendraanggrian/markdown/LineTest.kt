package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class LineTest {

    @Test
    fun line() {
        assertEquals(
            """
                Hello world

                ---
            """.trimIndent(),
            buildMarkdown {
                paragraph("Hello world")
                line()
            }.trim()
        )
        assertEquals(
            """
                Hello world

                - - -
            """.trimIndent(),
            buildMarkdown(true) {
                paragraph("Hello world")
                line()
            }.trim()
        )
    }
}