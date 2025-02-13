package com.idiotleon.leetcode.lvl1.lc0917

import org.junit.Test
import kotlin.test.assertEquals

class Solution0HighLowPointersTest {
    val solution = SolutionApproach0HighLowPointers()

    @Test
    fun test_TestCase1_ShouldReturnExpected() {
        val input = "tNH95P=TV"

        val expected = "VTP95H=Nt"

        assertEquals(expected, solution.reverseOnlyLetters(input))
    }
}