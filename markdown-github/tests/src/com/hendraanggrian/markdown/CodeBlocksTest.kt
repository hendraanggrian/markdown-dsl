package com.hendraanggrian.markdown

import com.hendraanggrian.markdown.github.codeBlock
import org.junit.Test
import kotlin.test.assertEquals

class CodeBlocksTest {

    @Test
    fun codeBlock() {
        assertEquals(
            """
                This is a normal paragraph:

                ```java
                this.isCode() == true
                ```
            """.trimIndent(),
            buildMarkdown {
                paragraph("This is a normal paragraph:")
                codeBlock(
                    "java", """
                        this.isCode() == true
                        """.trimIndent()
                )
            }
        )
    }
}