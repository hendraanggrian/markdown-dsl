package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class HeaderTest {

    @Test
    fun firstHeader() {
        assertEquals(
            "Hello world\n" +
                "=",
            buildMarkdown {
                firstHeader("Hello world")
            }.content.trim()
        )
        assertEquals(
            "Hello world\n" +
                "===========",
            buildMarkdown(true) {
                firstHeader("Hello world")
            }.content.trim()
        )
    }

    @Test
    fun secondHeader() {
        assertEquals(
            "Hello world\n" +
                "-",
            buildMarkdown {
                secondHeader("Hello world")
            }.content.trim()
        )
        assertEquals(
            "Hello world\n" +
                "-----------",
            buildMarkdown(true) {
                secondHeader("Hello world")
            }.content.trim()
        )
    }
}