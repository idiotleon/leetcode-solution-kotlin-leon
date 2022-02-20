/**
 * @author: Leon
 * https://leetcode.com/problems/continuous-subarray-sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * the remainder theorem:
 *  (a+(n*x))%x is same as (a%x)
 *
 * for the padding (0, -1):
 *  1. to return true when `runningSum % k == 0`
 *  2. to prevent early returns if `nums[0] % k == 0`
 *
 * References:
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space/103559
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
 */
package com.an7one.leetcode.lvl3.lc0523

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        // not used
        // val nNums = nums.size

        val sumToIdx = hashMapOf(0 to -1)

        var sum = 0

        for ((idx, num) in nums.withIndex()) {
            sum += num

            if (k != 0)
                sum %= k

            if (idx - sumToIdx.getOrPut(sum) { idx } > 1)
                return true
        }

        return false
    }
}