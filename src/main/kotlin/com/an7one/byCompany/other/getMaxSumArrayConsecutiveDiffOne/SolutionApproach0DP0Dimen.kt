/**
 * @author: Leon
 *
 * Time Complexity:         O(`VALUE_RANGE`)
 * Space Complexity:        O(`VALUE_RANGE`)
 */
package com.an7one.byCompany.other.getMaxSumArrayConsecutiveDiffOne

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    private companion object {
        // to assume the value range of numbers is [-1e6, +1e6]
        private const val VALUE_RANGE = 1e6.toInt() + 7
    }

    fun getMaxSum(nums: IntArray): Int {
        // no need at all
        // nums.sort()

        val numToFreqs = IntArray(VALUE_RANGE) { 0 }
        for (num in nums) {
            // to skip all negative numbers
            if (num < 0) continue

            // to accumulate the frequencies
            ++numToFreqs[num]
        }

        // the answer to return
        var maxSum = 0

        // two/high-low pointers approach to find "consecutive(diff <= 1)" subarray of `numToFreqs`.
        // the indexes of `numToFreqs` actually are numbers in `nums`
        var hi = 0

        while (hi < VALUE_RANGE) {
            if (hi < VALUE_RANGE - 1 && numToFreqs[hi] > 0 && numToFreqs[hi + 1] > 0) {
                // to keep track of the start of the "consecutive(diff <= 1)" subarray of `numToFreqs`
                val lo = hi
                // to find the end of the "consecutive" subarray of `numToFreqs`
                while (hi < VALUE_RANGE && numToFreqs[hi] > 0) ++hi

                maxSum += getLocalMaxSum(lo, hi, nums)
            } else {
                // to take all if it is not "consecutive(diff <= 1)"
                // (negative values have been kicked out in the initialization step)
                maxSum += hi * numToFreqs[hi]
                ++hi
            }
        }

        return maxSum
    }

    /**
     * House Robber
     * 0/1 Pack, Knapsack,
     *
     * the subarray in the range of [lo, hi) is guaranteed to be "consecutive(diff <= 1)"
     *
     * Time Complexity:     O(`hi` - `lo`)
     * Space Complexity:    O(1)
     */
    private fun getLocalMaxSum(lo: Int, hi: Int, numToFreqs: IntArray): Int {
        if (lo >= hi) return 0

        var prevTakenSum = 0
        var prevSkippedSum = 0

        for (num in lo until hi) {
            // to take the current number
            val curTakenSum = prevSkippedSum + num * numToFreqs[num]
            // to skip the current number
            val curSkippedSum = maxOf(prevSkippedSum, prevTakenSum)

            prevTakenSum = curTakenSum
            prevSkippedSum = curSkippedSum
        }

        return maxOf(prevTakenSum, prevSkippedSum)
    }
}