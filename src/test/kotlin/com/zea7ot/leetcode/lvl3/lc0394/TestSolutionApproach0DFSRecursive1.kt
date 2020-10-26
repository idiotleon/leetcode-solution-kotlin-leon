package com.zea7ot.leetcode.lvl3.lc0394

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DFSRecursive1 {
    private val solution = SolutionApproach0DFSRecursive1()

    @Test
    fun test_RegularInput_ShouldReturnExpected() {
        val input = "3[a]2[bc]"

        val expected = "aaabcbc"

        assertEquals(expected, solution.decodeString(input))
    }
}