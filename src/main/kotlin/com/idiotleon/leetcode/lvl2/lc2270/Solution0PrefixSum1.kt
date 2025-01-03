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
class Solution0PrefixSum1 {
    fun waysToSplitArray(nums: IntArray): Int {
        val nNums = nums.size

        val prefixSums = IntArray(nNums) { 0 }.also {
            var sum = 0
            for ((idx, num) in nums.withIndex()) {
                sum += num
                it[idx] = sum
            }
        }

        var count = 0
        for (idx in 0 until nNums - 1) {
            val loSum = prefixSums[idx]
            val hiSum = prefixSums[nNums - 1] - loSum
            if (loSum >= hiSum) {
                ++count
            }
        }
        return count
    }
}