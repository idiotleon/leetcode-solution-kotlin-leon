/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`DATA_RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/discuss/877791/Java-Counting-Sort-Two-Pass-Simple-Code
 */
package com.zea7ot.leetcode.lvl2.lc1608

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    private companion object {
        private const val DATA_RANGE = 1000 + 1
        // private const val ARRAY_SIZE = 100 + 1
    }

    fun specialArray(nums: IntArray): Int {
        val nNums = nums.size

        val freqs = IntArray(DATA_RANGE) { 0 }
        for (num in nums) ++freqs[num]

        var num = nNums
        // for(idx in 0 until ARRAY_SIZE){
        for (idx in 0..nNums) {
            if (num == idx) return idx
            num -= freqs[idx]
        }

        return -1
    }
}