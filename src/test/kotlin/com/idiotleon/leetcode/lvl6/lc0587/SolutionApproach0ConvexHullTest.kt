package com.idiotleon.leetcode.lvl6.lc0587

import kotlin.test.Test
import kotlin.test.assertTrue


internal class SolutionApproach0ConvexHullTest {
    private val solution = SolutionApproach0ConvexHull()

    @Test
    fun outerTree_SampleInput0_ShouldReturnExpected() {
        val input = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 0),
            intArrayOf(2, 4),
            intArrayOf(3, 3),
            intArrayOf(4, 2)
        )

        val expected = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 0),
            intArrayOf(4, 2),
            intArrayOf(3, 3),
            intArrayOf(2, 4)
        )

        assertTrue(expected contentDeepEquals solution.outerTrees(input))
    }
}
