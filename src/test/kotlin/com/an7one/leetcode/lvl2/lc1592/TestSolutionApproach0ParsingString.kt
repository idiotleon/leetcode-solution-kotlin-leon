package com.an7one.leetcode.lvl2.lc1592

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0ParsingString {
    val solution = SolutionApproach0ParsingString()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val text = "  this   is  a sentence "

        val expected = "this   is   a   sentence"

        assertEquals(expected, solution.reorderSpaces(text))
    }
}