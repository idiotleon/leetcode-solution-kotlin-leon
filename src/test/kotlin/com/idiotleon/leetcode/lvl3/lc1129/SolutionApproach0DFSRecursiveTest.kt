package com.idiotleon.leetcode.lvl3.lc1129

import org.junit.Test
import kotlin.test.assertTrue

internal class SolutionApproach0DFSRecursiveTest {
    private val solution = SolutionApproach0DFSRecursive()

    @Test
    fun testWithSampleInput0_shouldReturnExpected() {
        val n = 3
        val redEdges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        val blueEdges = Array(0){IntArray(2)}
        val actual = solution.shortestAlternatingPaths(n, redEdges, blueEdges)
        val expected = intArrayOf(0, 1, -1)
        assertTrue (expected contentEquals actual)
    }
}