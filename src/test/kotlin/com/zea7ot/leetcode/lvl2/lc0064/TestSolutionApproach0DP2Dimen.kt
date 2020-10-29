package com.zea7ot.leetcode.lvl2.lc0064

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DP2Dimen {
    val solution = SolutionApproach0DP2Dimen()

    @Test
    fun test_RegularInput1_ShouldReturnExpected() {
        val input = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))

        val expected = 7

        assertEquals(expected, solution.minPathSum(input))
    }
}