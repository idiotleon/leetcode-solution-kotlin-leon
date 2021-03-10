/**
 * https://leetcode.com/problems/single-number-iii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 */
package com.an7one.leetcode.lvl3.lc0260

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1HashMap {
    fun singleNumber(nums: IntArray): IntArray {
        // not used
        // val totalNums = nums.size

        val freqs = HashMap<Int, Int>()
        for (num in nums) {
            freqs[num] = 1 + (freqs[num] ?: 0)
        }

        val ans = ArrayList<Int>()
        for ((num, freq) in freqs) {
            if (freq == 1) {
                ans.add(num)
            }
        }

        return ans.toIntArray()
    }
}