package com.idiotleon.leetcode.lvl2.lc2219

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-sum-score-of-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0PrefixSum1 {
    fun maximumSumScore(nums: IntArray): Long {
        val nNums = nums.size
        val totalSum = nums.sumOf { it.toLong() }

        var largest = totalSum
        var sum = 0L
        for (num in nums) {
            sum += num
            largest = maxOf(largest, sum, totalSum - sum + num)
        }

        return largest
    }
}