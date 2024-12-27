package com.idiotleon.leetcode.lvl2.lc1167

import org.junit.Test
import kotlin.test.assertEquals

class TestSolution0LinearScan {
    private val solution = SolutionApproach0Greedy()

    @Test
    fun test_RegularInput0_ShouldReturnExpected() {
        val input = intArrayOf(2, 4, 3)

        val expected = 14

        assertEquals(expected, solution.connectSticks(input))
    }

    @Test
    fun test_RegularInput1_ShouldReturnExpected() {
        val input = intArrayOf(1, 8, 3, 5)

        val expected = 30

        assertEquals(expected, solution.connectSticks(input))
    }

    @Test
    fun test_RegularInput2_ShouldReturnExpected() {
        val input = intArrayOf(3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009)

        val expected = 151646

        assertEquals(expected, solution.connectSticks(input))
    }
}