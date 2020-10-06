package com.zea7ot.leetcode.lc4.lc0269

import com.zea7ot.leetcode.lvl4.lc0269.SolutionApproach0TopologicalSort
import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0TopologicalSort {
    private val solution = SolutionApproach0TopologicalSort()

    @Test
    fun test() {
        val sample = arrayOf("za", "zb", "ca", "cb")
        val expected = "abzc"
        assertEquals(expected, solution.alienOrder(sample))
    }
}