/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/largest-number-at-least-twice-of-others/discuss/152120/One-Pass-O(N)-Java-Solution-9ms-100
 */
package com.zea7ot.leetcode.lvl1.lc0747

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun dominantIndex(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var max = -1
        var secMax = -1
        var index = -1

        for (idx in nums.indices) {
            if (nums[idx] > max) {
                secMax = max
                max = nums[idx]
                index = idx
            } else if (nums[idx] > secMax) {
                secMax = nums[idx]
            }
        }

        return if (secMax * 2 <= max) index else -1
    }
}