package com.zea7ot.leetcode.lvl3.lc0890

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0LinearScan1 {
    private val solution = SolutionApproach0LinearScan1()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val words = arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc")
        val pattern = "abb"

        val expected = listOf("mee", "aqq")

        assertEquals(expected, solution.findAndReplacePattern(words, pattern))
    }
}