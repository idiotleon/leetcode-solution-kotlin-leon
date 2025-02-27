package com.idiotleon.leetcode.lvl1.lc1913

import kotlin.test.Test
import kotlin.test.assertEquals

internal class Solution0SlidingWindow1AfterSort1Test {
    private val solution = SolutionApproach0LinearScan()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val nums = intArrayOf(5, 6, 2, 7, 4)
        val actual = solution.maxProductDifference(nums)

        val expected = 34
        assertEquals(expected, actual)
    }
}