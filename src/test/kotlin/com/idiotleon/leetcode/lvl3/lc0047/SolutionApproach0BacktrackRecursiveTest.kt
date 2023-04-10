package com.idiotleon.leetcode.lvl3.lc0047

import org.junit.Test
import kotlin.test.assertEquals

class SolutionApproach0BacktrackRecursiveTest {
    val solution = SolutionApproach0Backtrack()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val nums = intArrayOf(1, 1, 2)

        val expected = listOf(listOf(1, 1, 2), listOf(1, 2, 1), listOf(2, 1, 1))

        assertEquals(expected, solution.permuteUnique(nums))
    }
}