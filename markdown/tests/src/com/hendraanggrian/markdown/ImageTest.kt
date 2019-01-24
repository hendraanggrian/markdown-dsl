package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class ImageTest {

    @Test
    fun img() {
        assertEquals(
            """
                Hello ![world](https://www.google.com)
            """.trimIndent(),
            buildMarkdown {
                paragraph("Hello ${img("world", "https://www.google.com")}")
            }
        )
        assertEquals(
            """
                Hello ![world](https://www.google.com "Google")
            """.trimIndent(),
            buildMarkdown {
                paragraph("Hello ${img("world", "Google", "https://www.google.com")}")
            }
        )
    }
}