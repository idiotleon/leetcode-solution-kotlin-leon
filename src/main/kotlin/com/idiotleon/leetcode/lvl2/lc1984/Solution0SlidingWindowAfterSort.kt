package com.idiotleon.leetcode.lvl2.lc1984

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindowAfterSort {
    private companion object {
        private const val RANGE = 1e5.toInt() + 7
    }

    fun minimumDifference(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        if (k == 1) {
            return 0
        }

        nums.sort()
        var min = RANGE
        for (hi in k - 1 until nNums) {
            val lo = hi - k + 1
            val gap = nums[hi] - nums[lo]
            min = minOf(min, gap)
        }

        return min
    }
}