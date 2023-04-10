/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/unique-number-of-occurrences/discuss/392858/JavaPython-3-4-liner-and-2-liner-Using-Map-and-Set-w-brief-explanation-and-analysis./469490
 *  https://leetcode.com/problems/unique-number-of-occurrences/discuss/392858/JavaPython-3-4-liner-and-2-liner-Using-Map-and-Set-w-brief-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl1.lc1207

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun uniqueOccurrences(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        val freqs = HashMap<Int, Int>().also {
            for (num in nums) {
                it[num] = 1 + (it[num] ?: 0)
            }
        }
        val seen = HashSet<Int>()
        for ((_, freq) in freqs) {
            if (!seen.add(freq))
                return false
        }

        return true
    }
}