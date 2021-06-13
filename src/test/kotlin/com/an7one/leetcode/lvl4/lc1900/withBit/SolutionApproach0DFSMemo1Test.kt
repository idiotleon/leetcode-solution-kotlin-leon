package com.an7one.leetcode.lvl4.lc1900.withBit

import kotlin.test.Test
import kotlin.test.assertTrue

internal class SolutionApproach0DFSMemo1Test {
    private val solution = SolutionApproach0DFSMemo1()

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