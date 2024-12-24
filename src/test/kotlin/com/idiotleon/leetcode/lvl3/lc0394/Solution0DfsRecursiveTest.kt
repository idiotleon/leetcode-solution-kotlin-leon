package com.idiotleon.leetcode.lvl3.lc0394

import org.junit.Test
import kotlin.test.assertEquals

class Solution0DfsRecursiveTest {
    private val solution = SolutionApproach0DFSRecursive()

    @Test
    fun test_RegularInput_ShouldReturnExpected() {
        val input = "3[a]2[bc]"

        val expected = "aaabcbc"

        assertEquals(expected, solution.decodeString(input))
    }
}