package com.idiotleon.leetcode.lvl4.lc0699

import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionApproach0SegmentTreeTest {
    private val solution = SolutionApproach0SegmentTree()

    @Test
    fun fallingSquares_TestCase1_ShouldReturnExpected() {
        val input = arrayOf(intArrayOf(2, 1), intArrayOf(2, 9), intArrayOf(1, 8))
        val ans = solution.fallingSquares(input)

        val expected = listOf(1, 10, 18)

        assertEquals(expected, ans)
    }
}