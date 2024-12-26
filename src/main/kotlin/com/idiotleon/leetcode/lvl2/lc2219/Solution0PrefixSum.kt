package com.idiotleon.leetcode.lvl2.lc2219

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-sum-score-of-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-sum-score-of-array/solutions/1908407/python-prefix-sum-2-pass-constant-space-1-pass-constant-space-best-solution/
 */
@Suppress(UNUSED)
class Solution0PrefixSum {
    private companion object {
        private const val RANGE = 1e5.toLong() + 7
    }

    fun maximumSumScore(nums: IntArray): Long {
        val nNums = nums.size

        var loSum = 0L
        var hiSum = 0L
        var largest = -RANGE

        for (idx in nums.indices) {
            loSum += nums[idx]
            hiSum += nums[nNums - 1 - idx]
            largest = maxOf(largest, loSum, hiSum)
        }

        return largest
    }
}