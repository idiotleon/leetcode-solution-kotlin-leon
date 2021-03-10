package com.an7one.leetcode.lvl4.lc0947

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0UnionFind {
    private val solution = SolutionApproach0UnionFind()

    @Test
    fun test_RegularInput_ShouldReturnExpected() {
        val stones = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(2, 2))
        val expected = 5

        assertEquals(expected, solution.removeStones(stones))
    }
}