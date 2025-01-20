package com.idiotleon.leetcode.lvl2.lc3427

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sum-of-variable-length-subarrays/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0PrefixSum {
    fun subarraySum(nums: IntArray): Int {
        val nNums = nums.size
        val prefixSums = IntArray(nNums) { 0 }.also {
            it[0] = nums[0]
            for (idx in 1 until nNums) {
                it[idx] = nums[idx] + it[idx - 1]
            }
        }

        var totalSum = 0
        for (idx in nums.indices) {
            val idxStart = maxOf(0, idx - nums[idx])
            val sum = prefixSums[idx] - if (idxStart == 0) 0 else prefixSums[idxStart - 1]
            totalSum += sum
        }

        return totalSum
    }
}