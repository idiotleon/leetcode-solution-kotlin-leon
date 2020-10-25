package com.zea7ot.leetcode.lvl4.lc0218

import org.junit.Test
import kotlin.test.assertTrue

class TestSolutionApproach0SweepLine {
    private val solution = SolutionApproach0SweepLine()

    @Test
    fun test() {
        val input = arrayOf(intArrayOf(0, 2, 3), intArrayOf(2, 5, 3))

        val expected = arrayOf(intArrayOf(0, 3), intArrayOf(5, 0))

        assertTrue(expected contentEquals solution.getSkyline(input).toTypedArray())
    }
}