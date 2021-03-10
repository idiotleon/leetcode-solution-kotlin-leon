/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 * Time Complexity:     O(distinctNums * lg(distinctNums)) + O(distinctNums * `K`)
 *  distinctNums, the amount of distinct numbers
 *
 * Space Complexity:    O(distinctNums)
 *  distinctNums, the amount of distinct numbers
 *
 * References:
 *  https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/discuss/470238/JavaC%2B%2BPython-Exactly-Same-as-846.-Hand-of-Straights
 */
package com.an7one.leetcode.lvl3.lc1296

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TreeMap {
    fun isPossibleDivide(nums: IntArray, K: Int): Boolean {
        // not used
        // val totalNums = nums.size

        val freqs = TreeMap<Int, Int>()
        for (num in nums) freqs[num] = 1 + (freqs[num] ?: 0)
        for ((num, freq) in freqs) {
            if (freq == 0) continue
            for (k in K - 1 downTo 0) {
                val expected = num + k
                if ((freqs[expected] ?: 0) < freq) return false
                freqs[expected] = (freqs[expected] ?: 0) - freq
            }
        }

        return true
    }
}