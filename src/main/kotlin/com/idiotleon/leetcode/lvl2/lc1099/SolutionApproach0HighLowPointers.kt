/**
 * @author: Leon
 * https://leetcode.com/problems/two-sum-less-than-k/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1099

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    fun twoSumLessThanK(nums: IntArray, K: Int): Int {
        // not used
        // val nNums = nums.size

        nums.sort()

        var lo = 0
        var hi = nums.lastIndex
        var maxSum = Int.MIN_VALUE

        while (lo < hi) {
            val sum = nums[lo] + nums[hi]

            if (sum < K) {
                maxSum = maxOf(maxSum, sum)
                ++lo
            } else {
                --hi
            }
        }

        return if (maxSum == Int.MIN_VALUE) -1 else maxSum
    }
}