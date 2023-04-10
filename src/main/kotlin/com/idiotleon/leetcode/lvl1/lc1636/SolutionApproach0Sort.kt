/**
 * @author: Leon
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 */
package com.idiotleon.leetcode.lvl1.lc1636

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun frequencySort(nums: IntArray): IntArray {
        // not used
        // val nNums = nums.size

        val numToFreq = HashMap<Int, Int>()
        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num] ?: 0)
        }

        return nums.sortedWith(compareBy({ numToFreq[it]!! }, { -it })).toIntArray()
    }
}