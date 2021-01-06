package com.zea7ot.leetcode.lvl4.lc1012

import kotlin.test.Test
import kotlin.test.assertEquals

internal class SolutionApproach0MathTest {
    private val solution = SolutionApproach0Math()

    @Test
    fun numDupDigitsAtMostN_SampleInput_ShouldReturnExpected() {
        val input = 100

        val expected = 1

        assertEquals(expected, solution.numDupDigitsAtMostN(input))
    }
}
