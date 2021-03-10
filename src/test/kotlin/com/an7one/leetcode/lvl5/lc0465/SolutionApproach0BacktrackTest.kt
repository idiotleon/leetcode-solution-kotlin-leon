package com.an7one.leetcode.lvl5.lc0465

import org.junit.Test
import kotlin.test.assertEquals


internal class SolutionApproach0BacktrackTest {
    private val solution = SolutionApproach0Backtrack()

    @Test
    fun minTransfers_SampleInput1_ShouldReturnExpected() {
        val input = arrayOf(intArrayOf(0, 1, 10), intArrayOf(2, 0, 5))

        val expected = 2

        assertEquals(expected, solution.minTransfers(input))
    }
}