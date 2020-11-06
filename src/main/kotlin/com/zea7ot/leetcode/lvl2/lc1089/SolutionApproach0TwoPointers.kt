/**
 * https://leetcode.com/problems/duplicate-zeros/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/duplicate-zeros/discuss/312727/C++Java-Two-Pointers-Space-O(1)/290867
 */
package com.zea7ot.leetcode.lvl2.lc1089

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun duplicateZeros(nums: IntArray): Unit {
        val nNums = nums.size

        var cntZero = 0
        for (num in nums) {
            if (num == 0) ++cntZero
        }

        val nPadded = nNums + cntZero

        var lo = nNums - 1
        var hi = nPadded - 1

        while (lo >= 0 && hi >= 0) {
            if (nums[lo] != 0) {
                if (hi < nNums) {
                    nums[hi] = nums[lo]
                }
            } else {
                if (hi < nNums) {
                    nums[hi] = nums[lo]
                }

                --hi

                // to copy twice when hitting '0'
                if (hi < nNums) {
                    nums[hi] = nums[lo]
                }
            }

            --lo
            --hi
        }
    }
}