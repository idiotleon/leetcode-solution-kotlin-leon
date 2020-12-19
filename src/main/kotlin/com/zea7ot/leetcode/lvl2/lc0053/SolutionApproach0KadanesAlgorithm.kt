/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 *  https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
package com.zea7ot.leetcode.lvl2.lc0053

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KadanesAlgorithm {
    fun maxSubArray(nums: IntArray): Int {

        // not used
        // val totalNums = nums.size

        var localMax = 0
        var globalMax = Int.MIN_VALUE

        for (num in nums) {
            localMax += num

            if (globalMax < localMax) {
                globalMax = localMax
            }

            if (localMax < 0) {
                localMax = 0
            }
        }

        return globalMax
    }
}