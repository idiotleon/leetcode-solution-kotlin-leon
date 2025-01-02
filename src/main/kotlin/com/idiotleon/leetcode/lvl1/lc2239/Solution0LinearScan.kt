package com.idiotleon.leetcode.lvl1.lc2239

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/find-closest-number-to-zero/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val RANGE = 1e5.toInt() + 7
    }

    fun findClosestNumber(nums: IntArray): Int {
        val nNums = nums.size

        var closest = RANGE
        var closestGap = RANGE

        for (num in nums) {
            val gap = abs(num) - 0
            if (gap <= closestGap) {
                closestGap = gap
                closest = if (abs(closest) == abs(num)) {
                    maxOf(closest, num)
                } else {
                    num
                }
            }
        }

        return closest
    }
}