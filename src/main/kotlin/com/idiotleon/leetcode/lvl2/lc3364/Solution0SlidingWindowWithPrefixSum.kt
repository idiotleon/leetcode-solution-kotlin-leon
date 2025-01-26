package com.idiotleon.leetcode.lvl2.lc3364

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-positive-sum-subarray/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-positive-sum-subarray/solutions/6077873/4-method-c-beginner-friendly-beat-100/
 */
@Suppress(UNUSED)
class Solution0SlidingWindowWithPrefixSum {
    fun minimumSumSubarray(nums: List<Int>, low: Int, high: Int): Int {
        val nNums = nums.size
        val prefixSums = IntArray(nNums + 1) { 0 }.also {
            for (idx in 0 until nNums) {
                it[idx + 1] = it[idx] + nums[idx]
            }
        }

        var minSum = Int.MAX_VALUE
        var found = false

        for (k in low..high) {
            for (idx in 0..nNums - k) {
                val sum = prefixSums[idx + k] - prefixSums[idx]
                if (sum > 0) {
                    minSum = minOf(minSum, sum)
                    found = true
                }
            }
        }

        return if (found) minSum else -1
    }
}