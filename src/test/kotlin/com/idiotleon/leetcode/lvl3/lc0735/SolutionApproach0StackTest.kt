package com.idiotleon.leetcode.lvl3.lc0735

import org.junit.Test
import kotlin.test.assertTrue

class SolutionApproach0StackTest {
    private val solution = SolutionApproach0Stack()

    @Test
    fun regularInput_ShouldReturnExpected() {
        val input = intArrayOf(-2, -2, 1, -2)
        val expected = intArrayOf(-2, -2, -2)
        assertTrue(expected contentEquals solution.asteroidCollision(input))
    }
}