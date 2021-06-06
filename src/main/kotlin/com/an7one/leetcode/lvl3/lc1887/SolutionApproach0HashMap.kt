/**
 * @author: Leon
 * https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 *
 * Time Complexity:     O(`nNums`) + O(`max` - `min`)
 * Space Complexity:    O(`nNums`)
 */
package com.an7one.leetcode.lvl3.lc1887

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun reductionOperations(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val numToFreq = HashMap<Int, Int>()

        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE

        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num] ?: 0)

            max = maxOf(max, num)
            min = minOf(min, num)
        }

        if (max == min)
            return 0

        var freq = 0
        var prevFreq = 0
        for (num in max downTo min + 1) {
            numToFreq[num]?.let {
                freq += prevFreq + it
                prevFreq += it
            }
        }

        return freq
    }
}