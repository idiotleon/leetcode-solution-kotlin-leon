package com.idiotleon.leetcode.lvl3.lc1140

import org.junit.Test
import kotlin.test.assertEquals

internal class Solution0DfsMemoTest {
    val solution = SolutionApproach0DFSMemo()

    @Test
    fun stoneGameII_SampleInput1_ShouldReturnExpected() {
        val piles = intArrayOf(2, 7, 9, 4, 4)
        val expected = 10

        assertEquals(expected, solution.stoneGameII(piles))
    }

}