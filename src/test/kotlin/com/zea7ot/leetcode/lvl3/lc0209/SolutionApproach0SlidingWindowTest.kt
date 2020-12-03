package com.zea7ot.leetcode.lvl3.lc0209

import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionApproach0SlidingWindowTest {
    private val solution = SolutionApproach0SlidingWindow()

    @Test
    fun minSubArrayLen_SampleInput1_ShouldReturnExpected() {
        val nums = intArrayOf(2, 3, 1, 2, 4, 3)
        val s = 7

        val expected = 2

        assertEquals(expected, solution.minSubArrayLen(s, nums))
    }
}