package com.idiotleon.leetcode.lvl2.lc0136

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/single-number/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun singleNumber(nums: IntArray): Int {
        val numToFreq = HashMap<Int, Int>()

        var single = 0

        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num] ?: 0)
        }

        for ((num, freq) in numToFreq) {
            if (freq == 1)
                single = num
        }

        return single
    }
}