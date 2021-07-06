/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 *
 * Time Complexity:     O(`nNums`) + O(distinct(`nNums`) * lg(distinct(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 *  https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/496714/Java-O(N)-solution/441523
 */
package com.an7one.leetcode.lvl2.lc1338

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun minSetSize(nums: IntArray): Int {
        val nNums = nums.size

        val numToFreq = HashMap<Int, Int>()
        for (num in nums) {
            val newFreq = 1 + (numToFreq[num] ?: 0)
            if (newFreq >= nNums / 2)
                return 1
            numToFreq[num] = newFreq
        }

        val orderedFreqs = numToFreq.values.sortedDescending()

        var count = 0
        var sumFreq = 0
        for (freq in orderedFreqs) {
            sumFreq += freq
            ++count
            if (sumFreq >= nNums / 2)
                return count
        }

        return count
    }
}