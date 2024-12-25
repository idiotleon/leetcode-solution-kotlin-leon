package com.idiotleon.leetcode.lvl3.lc2316

import kotlin.test.Test
import kotlin.test.assertEquals

internal class Solution0UnionFindTest {
    val solution = SolutionApproach0UnionFind()

    @Test
    fun testWithTestCase45_shouldReturnExpected() {
        val n = 11
        val edges = arrayOf(
            intArrayOf(5, 0),
            intArrayOf(1, 0),
            intArrayOf(10, 7),
            intArrayOf(9, 8),
            intArrayOf(7, 2),
            intArrayOf(1, 3),
            intArrayOf(0, 2),
            intArrayOf(8, 5),
            intArrayOf(4, 6),
            intArrayOf(4, 2)
        )
        val actual: Long = solution.countPairs(n, edges)
        val expected: Long = 0
        assertEquals(expected, actual)
    }
}
