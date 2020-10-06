/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * the remainder theorem:
 *  (a+(n*x))%x is same as (a%x)
 *
 * for the padding (0, -1):
 *  1. to return true when `runningSum % k == 0`
 *  2. to prevent early returns if `nums[0] % k == 0`
 *
 * References:
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
 */
package com.zea7ot.leetcode.lvl3.lc0523

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        // sanity check
        if (nums.isEmpty()) return false

        val size = nums.size

        val prefixSums = hashMapOf(0 to -1)

        var sum = 0
        for (i in 0 until size) {
            sum += nums[i]
            if (k != 0) sum %= k

            if (i - (prefixSums.getOrPut(sum) { i }) > 1) return true
        }

        return false
    }
}