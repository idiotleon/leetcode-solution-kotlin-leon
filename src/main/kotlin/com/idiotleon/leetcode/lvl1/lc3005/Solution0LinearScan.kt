package com.idiotleon.leetcode.lvl1.lc3005

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun maxFrequencyElements(nums: IntArray): Int {
        val nNums = nums.size

        val numToFreq = HashMap<Int, Int>(nNums)

        var maxFreq = 0
        var sumFreq = 0

        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num] ?: 0)

            val freq = numToFreq[num] ?: 0
            if (freq > maxFreq) {
                maxFreq = freq
                sumFreq = freq
            } else if (freq == maxFreq) {
                sumFreq += maxFreq
            }
        }

        return sumFreq
    }
}