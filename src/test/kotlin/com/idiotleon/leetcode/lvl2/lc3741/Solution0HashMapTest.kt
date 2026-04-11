package com.idiotleon.leetcode.lvl2.lc3741

import org.junit.Assert
import org.junit.Test

internal class Solution0HashMapTest {
    private val solution = Solution0HashMap()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val nums = intArrayOf(1, 2, 1, 1, 3)
        val actual = solution.minimumDistance(nums)
        val expected = 6

        Assert.assertEquals(expected, actual)
    }
}