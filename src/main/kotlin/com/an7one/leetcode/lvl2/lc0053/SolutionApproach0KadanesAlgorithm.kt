/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  Kadane's Algorithm
 *  https://hackernoon.com/kadanes-algorithm-explained-50316f4fd8a6
 *  https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */
package com.an7one.leetcode.lvl2.lc0053

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KadanesAlgorithm {
    fun maxSubArray(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var sum = 0
        var largest = Int.MIN_VALUE

        for (num in nums) {
            sum += num

            if (sum > largest)
                largest = sum

            if (sum < 0)
                sum = 0
        }

        return largest
    }
}