package com.idiotleon.leetcode.lvl3.lc0962

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxWidthRamp(nums: IntArray): Int {
        val nNums = nums.size

        val hiMax = IntArray(nNums) { 0 }
        for (idx in nNums - 1 downTo 0) {
            hiMax[idx] = if (idx == nNums - 1) {
                nums[nNums - 1]
            } else {
                maxOf(hiMax[idx + 1], nums[idx])
            }
        }

        var lo = 0
        var hi = 0
        var widest = 0

        while (hi < nNums) {
            while (lo < hi && nums[lo] > hiMax[hi]) {
                ++lo
            }

            widest = maxOf(widest, hi - lo)
            ++hi
        }

        return widest
    }
}