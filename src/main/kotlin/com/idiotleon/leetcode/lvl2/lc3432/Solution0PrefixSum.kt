package com.idiotleon.leetcode.lvl2.lc3432

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/count-partitions-with-even-sum-difference/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0PrefixSum {
    fun countPartitions(nums: IntArray): Int {
        val nNums = nums.size
        val prefixSums = IntArray(nNums) { 0 }.also {
            it[0] = nums[0]
            for (idx in 1 until nNums) {
                it[idx] = it[idx - 1] + nums[idx]
            }
        }

        var count = 0
        for (idx in 0 until nNums - 1) {
            val loSum = prefixSums[idx]
            val hiSum = prefixSums.last() - loSum
            if (abs(hiSum - loSum) % 2 == 0) {
                ++count
            }
        }
        return count
    }
}