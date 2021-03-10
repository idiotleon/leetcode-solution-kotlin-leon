package com.an7one.leetcode.lvl4.lc1548

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0DijkstraSPF {
    val solution = SolutionApproach0DijkstraSPF()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val n = 5
        val roads = arrayOf(intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 4))
        val names = arrayOf("ATL", "PEK", "LAX", "DXB", "HND")
        val targetPath = arrayOf("ATL", "DXB", "HND", "LAX")

        val expected = listOf(0, 2, 4, 2)

        assertEquals(expected, solution.mostSimilar(n, roads, names, targetPath))
    }
}