/**
 * https://leetcode.com/problems/single-number/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
package com.zea7ot.leetcode.lvl2.lc0136

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun singleNumber(nums: IntArray): Int {
        val freqs = HashMap<Int, Int>()

        var single = 0

        for (num in nums) {
            freqs[num] = 1 + (freqs[num] ?: 0)
        }

        for ((num, freq) in freqs) {
            if (freq == 1) {
                single = num
            }
        }

        return single
    }
}