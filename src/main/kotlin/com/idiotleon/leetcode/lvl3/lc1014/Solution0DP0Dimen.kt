package com.idiotleon.leetcode.lvl3.lc1014

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/best-sightseeing-pair/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/best-sightseeing-pair/editorial/
 */
@Suppress(UNUSED)
class Solution0DP0Dimen {
    fun maxScoreSightseeingPair(nums: IntArray): Int {
        val nNums = nums.size

        var prevLoMax = nums[0] + 0

        var max = 0

        for (idx in 1 until nNums) {
            val curHiScore = nums[idx] - idx

            max = maxOf(max, prevLoMax + curHiScore)

            val curLoScore = nums[idx] + idx
            prevLoMax = maxOf(prevLoMax, curLoScore)
        }

        return max
    }
}