package com.zea7ot.leetcode.lvl5.lc0273

import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolutionApproach0StringParsing {

    private val solution = SolutionApproach0StringParsing1()

    @Test
    fun regularInput_ShouldReturnExpected() {
        val input = 12345
        val expected = "Twelve Thousand Three Hundred Forty Five"

        assertEquals(expected, solution.numberToWords(input))
    }
}