/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl1.lc1913

class SolutionApproach0LinearScan {
    private companion object {
        private const val RANGE_DATA = 1e4.toInt() + 7
    }

    fun maxProductDifference(nums: IntArray): Int {
        var max = -1
        var secMax = -1
        var min = RANGE_DATA
        var secMin = RANGE_DATA

        for (num in nums) {
            if (num > max) {
                secMax = max
                max = num
            } else if (num > secMax)
                secMax = num

            if (num < min) {
                secMin = min
                min = num
            } else if (num < secMin)
                secMin = num
        }

        return max * secMax - min * secMin
    }
}