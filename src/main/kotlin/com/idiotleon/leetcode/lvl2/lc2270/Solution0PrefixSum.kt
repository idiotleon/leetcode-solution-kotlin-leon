package com.idiotleon.leetcode.lvl2.lc2270

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-ways-to-split-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0PrefixSum {
    fun waysToSplitArray(nums: IntArray): Int {
        val nNums = nums.size
        val totalSum: Long = nums.sumOf { it.toLong() }

        var loSum = 0L
        var count = 0
        for (idx in 0 until nNums - 1) {
            loSum += nums[idx]
            val hiSum = totalSum - loSum
            if (loSum >= hiSum) {
                ++count
            }
        }
        return count
    }
}