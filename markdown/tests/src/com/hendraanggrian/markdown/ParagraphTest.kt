package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class ParagraphTest {

    @Test
    fun paragraph() {
        assertEquals(
            """
                Hello world
            """.trimIndent(),
            buildMarkdown {
                paragraph("Hello world")
            }.trim()
        )
    }
}