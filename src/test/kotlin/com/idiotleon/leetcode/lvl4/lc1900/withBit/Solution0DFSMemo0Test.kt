package com.idiotleon.leetcode.lvl4.lc1900.withBit

import kotlin.test.Test
import kotlin.test.assertTrue


internal class Solution0DFSMemo0Test {
    private val solution = SolutionApproach0DFSMemo0()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val n = 11
        val firstPlayer = 2
        val secondPlayer = 4

        val actual = solution.earliestAndLatest(n, firstPlayer, secondPlayer)

        val expected = intArrayOf(3, 4)

        assertTrue { expected contentEquals actual }
    }
}