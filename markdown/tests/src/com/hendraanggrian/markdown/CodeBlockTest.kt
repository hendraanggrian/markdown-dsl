package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class CodeBlockTest {

    @Test
    fun codeBlock() {
        assertEquals(
            """
                This is a normal paragraph:

                    This is a code block.
            """.trimIndent(),
            buildMarkdown {
                paragraph("This is a normal paragraph:")
                codeBlock("This is a code block.")
            }.trim()
        )
    }
}