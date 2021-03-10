package com.an7one.leetcode.lvl4.lc0778

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0KruskalMST {
    val solution = SolutionApproach0KruskalMST()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val grid = arrayOf(intArrayOf(0, 2), intArrayOf(1, 3))

        val expected = 3

        assertEquals(expected, solution.swimInWater(grid))
    }
}