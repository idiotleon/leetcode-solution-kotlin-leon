package com.zea7ot.leetcode.lvl3.lc0131

import org.junit.Test
import kotlin.test.assertTrue

class TestSolutionApproach0DP2Dimen {
    private val solution = SolutionApproach0DP2Dimen()

    @Test
    fun test_RegularInput_ShouldReturnExpected() {
        val input = "aab"
        val result = solution.partition(input)
        val expected = listOf(listOf("aa", "b"), listOf("a", "a", "b"))

        assertTrue(result.containsAll(expected) && expected.containsAll(result))
    }
}