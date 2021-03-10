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
package com.an7one.leetcode.lvl1.lc1207

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun uniqueOccurrences(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        val freqs = HashMap<Int, Int>()
        for (num in nums) freqs[num] = 1 + (freqs[num] ?: 0)

        val seen = HashSet<Int>()
        for ((_, freq) in freqs) {
            if (!seen.add(freq)) return false
        }

        return true
    }
}