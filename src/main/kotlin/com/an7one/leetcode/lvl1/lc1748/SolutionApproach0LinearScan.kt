/**
 * @author: Leon
 * https://leetcode.com/problems/sum-of-unique-elements/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
package com.an7one.leetcode.lvl1.lc1748

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun sumOfUnique(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        val numToFreq = HashMap<Int, Int>()

        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num] ?: 0)
        }

        var sum = 0
        for ((num, freq) in numToFreq) {
            if (freq == 1)
                sum += num
        }

        return sum
    }
}