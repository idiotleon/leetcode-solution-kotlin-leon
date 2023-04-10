package com.idiotleon.leetcode.lvl1.lc0830

import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolutionApproach0830 {
    private val solution = SolutionApproach0Greedy()

    @Test
    fun regularInput_ShouldReturnExpected() {
        val input = "abbxxxxzzy"
        val expected = arrayListOf(arrayListOf(3, 6))

        assertEquals(expected, solution.largeGroupPositions(input))
    }

    @Test
    fun pureEligible_ShouldReturnAll() {
        val input = "aaa"
        val expected = arrayListOf(arrayListOf(0, 2))

        assertEquals(expected, solution.largeGroupPositions(input))
    }
}