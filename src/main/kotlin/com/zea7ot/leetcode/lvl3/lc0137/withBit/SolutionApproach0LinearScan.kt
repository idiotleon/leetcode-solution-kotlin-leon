/**
 * https://leetcode.com/problems/single-number-ii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`TYPE_INT_RANGE`) ~ O(1)
 *
 * References:
 *  https://docs.google.com/presentation/d/1_1mhjlmIwTHKV_rRpCo3YLI3Kc3FU8i4dbqhqghK6s8/edit#slide=id.ga4b64814d9_1_18
 */
package com.zea7ot.leetcode.lvl3.lc0137.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val TYPE_INT_RANGE = 32
    }

    fun singleNumber(nums: IntArray): Int {
        // not used
        // val totalNums = nums.size

        var single = 0
        val freqs = IntArray(TYPE_INT_RANGE) { 0 }

        for (num in nums) {
            saveIntoMap(num, freqs)
        }

        // to quench numbers that appear three times
        for (idx in freqs.indices) {
            freqs[idx] %= 3
        }

        // to get the remaining one that only appears once
        for (idx in freqs.indices) {
            single = single or (freqs[idx] shl idx)
        }

        return single
    }

    private fun saveIntoMap(shift: Int, freqs: IntArray) {
        for (idx in 0 until TYPE_INT_RANGE) {
            freqs[idx] += (shift shr idx) and 1
        }
    }
}