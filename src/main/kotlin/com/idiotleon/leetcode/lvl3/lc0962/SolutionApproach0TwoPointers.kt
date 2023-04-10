/**
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
package com.idiotleon.leetcode.lvl3.lc0962

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxWidthRamp(nums: IntArray): Int {
        val nNums = nums.size

        val rightMax = IntArray(nNums)
        for (idx in nNums - 1 downTo 0) {
            rightMax[idx] = if (idx == nNums - 1) {
                nums[nNums - 1]
            } else {
                maxOf(rightMax[idx + 1], nums[idx])
            }
        }

        var lo = 0
        var hi = 0
        var widest = 0

        while (hi < nNums) {
            while (lo < hi && nums[lo] > rightMax[hi]) {
                ++lo
            }

            widest = maxOf(widest, hi - lo)
            ++hi
        }

        return widest
    }
}