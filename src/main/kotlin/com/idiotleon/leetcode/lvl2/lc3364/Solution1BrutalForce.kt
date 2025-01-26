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
class Solution1BrutalForce {
    fun minimumSumSubarray(nums: List<Int>, low: Int, high: Int): Int {
        val nNums = nums.size
        var minSum = Int.MAX_VALUE
        var found = false

        for (lo in 0 until nNums) {
            var sum = 0
            for (hi in lo until nNums) {
                sum += nums[hi]
                val len = hi - lo + 1
                if (len in low..high && sum > 0) {
                    minSum = minOf(minSum, sum)
                    found = true
                }
            }
        }

        return if (found) minSum else -1
    }
}