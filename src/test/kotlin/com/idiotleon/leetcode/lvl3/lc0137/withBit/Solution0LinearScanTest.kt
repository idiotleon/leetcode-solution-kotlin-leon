package com.idiotleon.leetcode.lvl3.lc0137.withBit

import org.junit.Test
import kotlin.test.assertEquals

class Solution0LinearScanTest {
    private val solution = SolutionApproach0LinearScan()

    @Test
    fun test() {
        val input = intArrayOf(2, 2, 3, 2)
        val expected = 3

        assertEquals(expected, solution.singleNumber(input))
    }
}