package com.hendraanggrian.markdown

import com.hendraanggrian.markdown.github.h1
import org.junit.Test
import kotlin.test.assertEquals

class HeadersTest {

    @Test
    fun h1() {
        assertEquals(
            """
                #Hello world
            """.trimIndent(),
            buildMarkdown {
                h1("Hello world")
            }
        )
        assertEquals(
            """
                # Hello world
            """.trimIndent(),
            buildMarkdown(true) {
                h1("Hello world")
            }
        )
    }
}