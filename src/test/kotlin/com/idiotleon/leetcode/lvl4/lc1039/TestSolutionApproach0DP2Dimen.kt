package com.idiotleon.leetcode.lvl4.lc1039

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DP2Dimen {
    private val solution = SolutionApproach0DP2Dimen()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val input = intArrayOf(1, 2, 3)

        val expected = 6

        assertEquals(expected, solution.minScoreTriangulation(input))
    }
}