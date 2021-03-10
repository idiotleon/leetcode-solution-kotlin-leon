package com.an7one.leetcode.lvl1.lc0088

import kotlin.test.Test
import kotlin.test.assertTrue


internal class SolutionApproach0ThreePointersTest {
    private val solution = SolutionApproach0ThreePointers1()

    @Test
    fun merge_SampleInput0_ShouldReturnExpected() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(2, 5, 6)
        val n = 3

        val expected = intArrayOf(1, 2, 2, 3, 5, 6)
        solution.merge(nums1, m, nums2, n)

        assertTrue(expected contentEquals nums1)
    }
}