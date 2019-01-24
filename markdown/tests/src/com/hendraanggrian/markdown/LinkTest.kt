package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class LinkTest {

    @Test
    fun url() {
        assertEquals(
            """
                Hello [world](https://www.google.com)
            """.trimIndent(),
            buildMarkdown {
                paragraph("Hello ${url("world", "https://www.google.com")}")
            }
        )
        assertEquals(
            """
                Hello [world](https://www.google.com "Google")
            """.trimIndent(),
            buildMarkdown {
                paragraph("Hello ${url("world", "Google", "https://www.google.com")}")
            }
        )
    }
}