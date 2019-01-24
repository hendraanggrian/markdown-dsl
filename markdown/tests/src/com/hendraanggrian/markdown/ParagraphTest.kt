package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class ParagraphTest {

    @Test
    fun paragraph() {
        assertEquals(
            "Hello world",
            buildMarkdown {
                paragraph("Hello world")
            }.content.trim()
        )
    }
}