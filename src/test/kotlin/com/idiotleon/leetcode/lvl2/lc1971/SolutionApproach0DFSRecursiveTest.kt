package com.idiotleon.leetcode.lvl2.lc1971

import org.junit.Assert
import kotlin.test.Test

internal class SolutionApproach0DFSRecursiveTest {
    private val solution = SolutionApproach0DFSRecursive()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val n = 3
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0))
        val start = 0
        val end = 2

        Assert.assertTrue(solution.validPath(n, edges, start, end))
    }
}