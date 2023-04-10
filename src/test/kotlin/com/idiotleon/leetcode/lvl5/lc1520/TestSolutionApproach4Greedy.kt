package com.idiotleon.leetcode.lvl5.lc1520

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach4Greedy {
    val solution = SolutionApproach4Greedy()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val str = "adefaddaccc"

        val expected = listOf("e", "f", "ccc")

        assertEquals(expected, solution.maxNumOfSubstrings(str))
    }
}