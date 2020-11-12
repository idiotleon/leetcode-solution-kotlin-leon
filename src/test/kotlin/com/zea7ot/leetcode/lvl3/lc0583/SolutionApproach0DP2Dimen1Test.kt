package com.zea7ot.leetcode.lvl3.lc0583

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DP2Dimen1 {
    private val solution = SolutionApproach0DP2Dimen1()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val word1 = "sea"
        val word2 = "eat"

        val expected = 2

        assertEquals(expected, solution.minDistance(word1, word2))
    }
}