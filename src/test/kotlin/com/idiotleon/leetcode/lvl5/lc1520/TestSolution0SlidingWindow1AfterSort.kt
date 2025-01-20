package com.idiotleon.leetcode.lvl5.lc1520

import org.junit.Test
import kotlin.test.assertEquals

class TestSolution0SlidingWindow1AfterSort {
    val solution = SolutionApproach0Greedy()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val str = "adefaddaccc"

        val expected = listOf("e", "f", "ccc")

        assertEquals(expected.sorted(), solution.maxNumOfSubstrings(str).sorted())
    }

    @Test
    fun test_TestCase1_ShouldReturnExpected() {
        val str = "bbcacbaba"

        val expected = listOf("bbcacbaba")

        assertEquals(expected.sorted(), solution.maxNumOfSubstrings(str).sorted())
    }
}