package com.an7one.leetcode.lvl2.lc0053.followup.followup1

import kotlin.test.Test
import kotlin.test.assertTrue

internal class SolutionApproach0KadaneAlgorithmTest {
    private val solution = SolutionApproach0KadaneAlgorithm()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val input = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

        val actual = solution.maxSubArray(input)
        val expected = intArrayOf(4, -1, 2, 1)

        assertTrue { actual contentEquals expected }
    }

    @Test
    fun sampleInput1_ShouldReturnExpected() {
        val input = intArrayOf(1)

        val actual = solution.maxSubArray(input)
        val expected = intArrayOf(1)

        assertTrue { actual contentEquals expected }
    }

    @Test
    fun sampleInput2_ShouldReturnExpected() {
        val input = intArrayOf(5, 4, -1, 7, 8)

        val actual = solution.maxSubArray(input)
        val expected = intArrayOf(5, 4, -1, 7, 8)

        assertTrue { actual contentEquals expected }
    }

    @Test
    fun sampleInput3_ShouldReturnExpected() {
        val input = intArrayOf(-1)

        val actual = solution.maxSubArray(input)
        val expected = intArrayOf(-1)

        assertTrue { actual contentEquals expected }
    }
}