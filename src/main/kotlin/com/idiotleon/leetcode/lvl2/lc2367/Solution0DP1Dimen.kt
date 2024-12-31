package com.idiotleon.leetcode.lvl2.lc2367

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-arithmetic-triplets/
 *
 * Time Complexity:     O(`RANGE`)
 * Space Complexity:    O(`RANGE`)
 */
@Suppress(UNUSED)
class Solution0DP1Dimen {
    private companion object {
        private const val RANGE = 200 + 1
    }

    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val exists = BooleanArray(RANGE) { false }
        var count = 0

        for (num in nums) {
            if (num >= 2 * diff) {
                if (exists[num - diff] && exists[num - 2 * diff]) {
                    ++count
                }
            }
            exists[num] = true
        }

        return count
    }
}