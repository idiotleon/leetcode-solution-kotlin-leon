package com.zea7ot.leetcode.lvl3.lc0877

import kotlin.test.Test
import kotlin.test.assertTrue

internal class SolutionApproach0DFSMemoTest {
    private val solution = SolutionApproach0DFSMemo()

    @Test
    fun stoneGame_SampleInput32_ShouldReturnTrue() {
        val input = intArrayOf(7, 8, 8, 10)

        assertTrue(solution.stoneGame(input))
    }
}
