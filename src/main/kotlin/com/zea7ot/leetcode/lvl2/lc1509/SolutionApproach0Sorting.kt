/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://youtu.be/Ht6hc3UsvY0
 *  https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/discuss/751091/Detailed-Explanation-with-Code
 */
package com.zea7ot.leetcode.lvl2.lc1509

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sorting {
    fun minDifference(nums: IntArray): Int {
        val nNums = nums.size
        if (nNums <= 4) return 0

        nums.sort()
        var minDiff = Int.MAX_VALUE

        for (idx in 0 until 4) {
            minDiff = minOf(minDiff, nums[nNums - 1 - 3 + idx] - nums[idx])
        }

        return minDiff
    }
}