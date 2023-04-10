package com.idiotleon.leetcode.lvl1.lc0387

import kotlin.test.Test
import kotlin.test.assertEquals


internal class SolutionApproach4LinearScanTest {
    private val solution = SolutionApproach4LinearScan()

    @Test
    fun firstUniqChar_SampleInput0099_ShouldReturnExpected() {
        val input = "dddccdbba"

        val expected = 8

        assertEquals(expected, solution.firstUniqChar(input))
    }
}