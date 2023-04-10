package com.idiotleon.leetcode.lvl2.lc0053.followup.followup1

/**
 * follow up of
 * https://leetcode.com/problems/maximum-subarray/
 * to return the subarray with the largest sum.
 *  if there are more than one, to return any of them.
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
class SolutionApproach0KadaneAlgorithm {
    fun maxSubArray(nums: IntArray): IntArray {
        // not used
        // val nNums = nums.size

        var sum = 0
        var len = 0
        var largest = Int.MIN_VALUE

        var lo = 0
        var hi = 0

        for ((idx, num) in nums.withIndex()) {
            sum += num

            if (sum > largest) {
                largest = sum
                lo = idx - len
                hi = idx
            }

            if (sum < 0) {
                sum = 0
                len = 0
            } else
                ++len
        }

        return nums.copyOfRange(lo, hi + 1)
    }
}