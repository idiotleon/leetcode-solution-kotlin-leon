package com.zea7ot.leetcode.lvl2.lc1525

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0LinearScan {
    private val solution = SolutionApproach0LinearScan1()

    @Test
    fun test1_SampleInput1_ShouldReturnExpected() {
        val str = "aacaba"
        val expected = 2

        assertEquals(expected, solution.numSplits(str))
    }
}