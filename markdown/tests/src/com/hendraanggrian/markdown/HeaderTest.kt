package com.hendraanggrian.markdown

import org.junit.Test
import kotlin.test.assertEquals

class HeaderTest {

    @Test
    fun firstHeader() {
        assertEquals(
            buildMarkdown {
                firstHeader("Hello world")
            }.content.trim(),
            "Hello world\n" +
                "="
        )
        assertEquals(
            buildMarkdown(true) {
                firstHeader("Hello world")
            }.content.trim(),
            "Hello world\n" +
                "==========="
        )
    }

    @Test
    fun secondHeader() {
        assertEquals(
            buildMarkdown {
                secondHeader("Hello world")
            }.content.trim(),
            "Hello world\n" +
                "-"
        )
        assertEquals(
            buildMarkdown(true) {
                secondHeader("Hello world")
            }.content.trim(),
            "Hello world\n" +
                "-----------"
        )
    }
}