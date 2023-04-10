package com.idiotleon.leetcode.lvl3.lc0300.followup

import kotlin.test.Test
import kotlin.test.assertEquals

internal class SolutionApproach0DP1DimenBinarySearch1Test {
    val solution = SolutionApproach0DP1DimenBinarySearch()

    @Test
    fun lengthOfLIS_SampleInput5_ShouldReturnExpected() {
        val input = intArrayOf(-2, -1)

        val expected = 1

        assertEquals(expected, solution.lengthOfLIS(input))
    }
}