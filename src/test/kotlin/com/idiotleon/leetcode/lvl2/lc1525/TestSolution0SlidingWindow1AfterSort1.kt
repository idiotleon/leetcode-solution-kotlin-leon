package com.idiotleon.leetcode.lvl2.lc1525

import org.junit.Test
import kotlin.test.assertEquals

class TestSolution0SlidingWindow1AfterSort1 {
    private val solution = SolutionApproach0LinearScan1()

    @Test
    fun test1_SampleInput1_ShouldReturnExpected() {
        val str = "aacaba"
        val expected = 2

        assertEquals(expected, solution.numSplits(str))
    }
}