/**
 * https://leetcode.com/problems/check-if-it-is-a-good-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/check-if-it-is-a-good-array/discuss/419368/JavaC%2B%2BPython-Chinese-Remainder-Theorem
 */
package com.zea7ot.leetcode.lvl4.lc1250

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun isGoodArray(nums: IntArray): Boolean {
        var x = nums[0]
        for (num in nums) {
            var a = num
            while (a > 0) {
                val y = x % a
                x = a
                a = y
            }
        }

        return x == 1
    }
}