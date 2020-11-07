/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 *
 * Time Complexity:     O(`nNums` * lg(`RANGE`))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc1283

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val RANGE = 1e6.toInt() + 1
    }

    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        val nNums = nums.size

        if (nNums == 1) return (nums[0] + threshold - 1) / threshold

        var lo = 1
        var hi = RANGE

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            val sum = getSum(mid, nums)
            if (sum <= threshold) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo
    }

    private fun getSum(divisor: Int, nums: IntArray): Int {
        var sum = 0
        for (num in nums) {
            sum += (num + divisor - 1) / divisor
        }
        return sum
    }
}