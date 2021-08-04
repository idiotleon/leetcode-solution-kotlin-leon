package com.an7one.leetcode.lvl2.lc0078.withBit

import org.junit.Test
import kotlin.test.assertTrue

class SolutionApproach0BacktrackRecursiveTest {
    private val solution = SolutionApproach0Backtrack()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val nums = intArrayOf(1, 2, 3)
        val res = solution.subsets(nums)

        val expected = listOf(listOf(3), listOf(1), listOf(2), listOf(1, 2, 3), listOf(1, 3), listOf(2, 3), listOf(1, 2), listOf())

        assertTrue(expected.containsAll(res) && res.containsAll(expected))
    }
}