package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class ParagraphTest {

    @Test
    fun paragraph() {
        assertEquals(
            buildMarkdown {
                paragraph("Hello world")
            }.content.trim(),
            "Hello world"
        )
    }
}