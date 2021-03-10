package com.an7one.leetcode.ood.lvl6.lc0308

import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionApproach0BinaryIndexedTreeTest {
    private val matrix = arrayOf(intArrayOf(3, 0, 1, 4, 2),
            intArrayOf(5, 6, 3, 2, 1),
            intArrayOf(1, 2, 0, 1, 5),
            intArrayOf(4, 1, 0, 1, 7),
            intArrayOf(1, 0, 3, 0, 5))

    private val solution = SolutionApproach0BinaryIndexedTree(matrix)

    @Test
    fun update() {
    }

    @Test
    fun sumRegion_SampleInput1_ShouldReturnExpected() {
        val expected = 8

        assertEquals(expected, solution.sumRegion(2, 1, 4, 3))
    }
}