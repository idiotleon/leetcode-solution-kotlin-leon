/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/two-sum-iii-data-structure-design/discuss/52005/Trade-off-in-this-problem-should-be-considered/115286
 */
package com.an7one.leetcode.ood.lvl3.lc0170

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private val freqs = hashMapOf<Int, Int>()

    /** Initialize your data structure here. */


    /** Add the number to an internal data structure.. */
    fun add(num: Int) {
        freqs[num] = (freqs[num] ?: 0) + 1
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    fun find(value: Int): Boolean {
        for ((num1, freq) in freqs) {
            val num2 = value - num1
            if ((num1 == num2) && (freq > 1)
                || (num1 != num2) && (freqs[num2] != null)
            ) return true
        }

        return false
    }
}