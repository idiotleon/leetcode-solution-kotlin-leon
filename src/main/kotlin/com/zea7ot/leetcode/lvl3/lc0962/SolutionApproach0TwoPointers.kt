/**
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
package com.zea7ot.leetcode.lvl3.lc0962

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun maxWidthRamp(nums: IntArray): Int {
        val totalNums = nums.size

        val rightMax = IntArray(totalNums)
        for (idx in totalNums - 1 downTo 0) {
            rightMax[idx] = if (idx == totalNums - 1) {
                nums[totalNums - 1]
            } else {
                maxOf(rightMax[idx + 1], nums[idx])
            }
        }

        var lo = 0
        var hi = 0
        var widest = 0

        while (hi < totalNums) {
            while (lo < hi && nums[lo] > rightMax[hi]) {
                ++lo
            }

            widest = maxOf(widest, hi - lo)
            ++hi
        }

        return widest
    }
}