package com.an7one.leetcode.lvl3.lc0491

import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionApproach0BacktrackTest {
    val solution = SolutionApproach0Backtrack()

    @Test
    fun findSubsequence_SampleInput1_ShouldReturnExpected() {
        val input = intArrayOf(4, 6, 7, 7)

        val expected = listOf(listOf(4, 6),
                listOf(4, 7),
                listOf(4, 6, 7),
                listOf(4, 6, 7, 7),
                listOf(6, 7),
                listOf(6, 7, 7),
                listOf(7, 7),
                listOf(4, 7, 7))

        assertEquals(expected, solution.findSubsequences(input))
    }
}