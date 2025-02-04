package com.idiotleon.leetcode.lvl1.lc0067

import org.junit.Assert
import org.junit.Test

internal class Solution0SlidingWindow1AfterSort1Test {
    private val solution = Solution0LinearScan()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val a = "11"
        val b = "1"

        val actual = solution.addBinary(a, b)
        val expected = "100"

        Assert.assertEquals(expected, actual)
    }
}