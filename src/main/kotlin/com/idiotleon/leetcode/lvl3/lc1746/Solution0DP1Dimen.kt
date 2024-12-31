package com.idiotleon.leetcode.lvl3.lc1746

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/solutions/1440772/top-down-bottom-up-bottom-up-with-o-1-space/?envType=weekly-question&envId=2024-12-29
 */
@Suppress(UNUSED)
class Solution0DP1Dimen {
    fun maxSumAfterOperation(nums: IntArray): Int {
        val nNums = nums.size

        val squared = IntArray(nNums) { 0 }.also {
            it[0] = nums[0] * nums[0]
        }
        val notSquared = IntArray(nNums) { 0 }.also {
            it[0] = nums[0]
        }

        var max = squared[0]

        for (idx in 1 until nNums) {
            notSquared[idx] = maxOf(notSquared[idx - 1] + nums[idx], 0)
            squared[idx] = maxOf(squared[idx - 1] + nums[idx], notSquared[idx - 1] + nums[idx] * nums[idx])
            max = maxOf(max, squared[idx])
        }

        return max
    }
}