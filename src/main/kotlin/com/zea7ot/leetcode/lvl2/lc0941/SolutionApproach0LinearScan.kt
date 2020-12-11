/**
 * @author: Leon
 * https://leetcode.com/problems/valid-mountain-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0941

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun validMountainArray(nums: IntArray): Boolean {
        val nNums = nums.size
        var everDecreased = false
        var everIncreased = false

        for (idx in 1 until nNums) {
            when {
                nums[idx - 1] > nums[idx] -> {
                    everDecreased = true
                }

                nums[idx - 1] < nums[idx] -> {
                    if (everDecreased) return false
                    everIncreased = true
                }

                else -> return false
            }
        }

        return everIncreased && everDecreased
    }
}