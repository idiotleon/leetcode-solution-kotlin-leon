package com.idiotleon.leetcode.lvl2.lc1150

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


internal class SolutionApproach0BinarySearch1Test {
    private val solution = SolutionApproach0BinarySearch1()

    @Test
    fun sampleInput0_ShouldReturnExpected() {
        val nums = intArrayOf(2, 5, 5)
        val target = 5

        val actual = solution.isMajorityElement(nums, target)
        assertTrue { actual }
    }

    @Test
    fun targetLargerThanAll_ShouldReturnExpected() {
        val nums = intArrayOf(2, 5, 5)
        val target = 6

        val actual = solution.isMajorityElement(nums, target)
        assertFalse { actual }
    }

    @Test
    fun targetSmallerThanAll_ShouldReturnExpected() {
        val nums = intArrayOf(2, 5, 5)
        val target = 1

        val actual = solution.isMajorityElement(nums, target)
        assertFalse { actual }
    }
}