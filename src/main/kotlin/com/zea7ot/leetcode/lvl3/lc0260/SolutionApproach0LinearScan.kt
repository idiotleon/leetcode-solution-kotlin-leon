/**
 * https://leetcode.com/problems/single-number-iii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * `num and (num - 1)`, to turn the rightmost 1-bit to 0
 * `num and (num - 1).inv()`, to keep the right most 1-bit, and turn the reset bits to 0
 *
 * `num and (-num)`, to keep the rightmost 1-bit and sets all the other bits to 0
 *
 * References:
 *  https://docs.google.com/presentation/d/1_1mhjlmIwTHKV_rRpCo3YLI3Kc3FU8i4dbqhqghK6s8/edit#slide=id.ga4b64814d9_1_51
 *  https://docs.google.com/presentation/d/1_1mhjlmIwTHKV_rRpCo3YLI3Kc3FU8i4dbqhqghK6s8/edit#slide=id.ga4b64814d9_1_31
 *  https://docs.google.com/presentation/d/1_1mhjlmIwTHKV_rRpCo3YLI3Kc3FU8i4dbqhqghK6s8/edit#slide=id.ga4b64814d9_1_43
 */
package com.zea7ot.leetcode.lvl3.lc0260

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun singleNumber(nums: IntArray): IntArray {
        // not used
        // val totalNums = nums.size

        var diffBits = 0 // the 2 different bits left
        for (num in nums) {
            diffBits = diffBits xor num
        }

        // to find the different bit between the two single numbers
        // complement code, by keeping the rightmost 1-bit and setting all the other bits to 0
        val lastDigit = diffBits and (-diffBits)
        // or equivalently
        // complement code = inverse code + 1
        // val lastDigit = diffBits and (diffBits.inv() + 1)
        var single1 = 0
        var single2 = 0

        for (num in nums) {
            if ((lastDigit and num) == 0)
                single1 = single1 xor num
            else single2 = single2 xor num
        }

        return intArrayOf(single1, single2)
    }
}