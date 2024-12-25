package com.idiotleon.leetcode.lvl5.lc1074

import org.junit.Test
import kotlin.test.assertEquals

class TestSolution0SlidingWindow {
    private val solution = SolutionApproach0PrefixSums1()

    @Test
    fun sampleInput1_ShouldReturnExpected() {
        val matrix = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0))
        val target = 0

        val expected = 4

        assertEquals(expected, solution.numSubmatrixSumTarget(matrix, target))
    }
}