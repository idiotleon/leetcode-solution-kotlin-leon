package com.idiotleon.leetcode.lvl3.lc1288

import kotlin.test.Test
import kotlin.test.assertEquals

class SolutionApproach0GreedyTest {
    private val solution = SolutionApproach0Greedy()

    @Test
    fun test() {
        val intervals = arrayOf(
                intArrayOf(1, 4),
                intArrayOf(1, 3),
                intArrayOf(3, 6),
                intArrayOf(2, 8)
        )

        val expected = 2
        assertEquals(expected, solution.removeCoveredIntervals(intervals))
    }
}