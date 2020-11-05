/**
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/mean-of-array-after-removing-some-elements/discuss/898699/JavaPython-3-Sort-and-sum.
 */
package com.zea7ot.leetcode.lvl2.lc1619

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun trimMean(nums: IntArray): Double {
        val nNums = nums.size
        nums.sort()

        var sum = 0.0
        for (idx in nNums / 20 until nNums - nNums / 20) {
            sum += nums[idx].toDouble()
        }

        return sum / (nNums * 9 / 10)
    }
}