package com.idiotleon.leetcode.lvl3.lc0213

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/house-robber-ii/
 *
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun rob(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size
        if (size == 1) return nums[0]

        val robFirst = rob(0, size - 2, nums)
        val robSecond = rob(1, size - 1, nums)

        return maxOf(robFirst, robSecond)
    }

    private fun rob(lo: Int, hi: Int, nums: IntArray): Int {
        var inclusive = 0
        var exclusive = 0

        for (i in lo until hi + 1) {
            val prevInclusive = inclusive
            val prevExclusive = exclusive

            inclusive = prevExclusive + nums[i]
            exclusive = maxOf(prevInclusive, prevExclusive)
        }

        return maxOf(inclusive, exclusive)
    }
}