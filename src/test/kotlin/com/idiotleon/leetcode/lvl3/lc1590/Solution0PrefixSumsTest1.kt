package com.idiotleon.leetcode.lvl3.lc1590

import org.junit.Test
import kotlin.test.assertEquals

internal class Solution0PrefixSumsTest1 {
    val solution = SolutionApproach0PrefixSums()

    @Test
    fun minSubarray_SampleInput1_ShouldReturnExpected() {
        val nums = intArrayOf(3, 1, 4, 2)
        val p = 6

        val expected = 1
        assertEquals(expected, solution.minSubarray(nums, p))
    }

    @Test
    fun minSubarray_SampleInput2_ShouldReturnExpected() {
        val nums = intArrayOf(1000000000, 1000000000, 1000000000)
        val p = 3

        val expected = 0
        assertEquals(expected, solution.minSubarray(nums, p))
    }
}