/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/discuss/877869/Java-O(nlogn)-with-easy-explanation
 */
package com.zea7ot.leetcode.lvl2.lc1608

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun specialArray(nums: IntArray): Int {
        val nNums = nums.size

        nums.sort()
        for (idx in nums.indices) {
            val x = nNums - idx

            val cond1 = x <= nums[idx]
            val cond2 = idx == 0 || x > nums[idx - 1]

            if (cond1 && cond2) return x
        }

        return -1
    }
}