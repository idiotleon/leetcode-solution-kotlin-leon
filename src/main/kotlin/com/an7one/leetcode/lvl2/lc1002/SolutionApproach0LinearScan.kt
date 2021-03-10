/**
 * https://leetcode.com/problems/find-common-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-common-characters/discuss/247558/JavaPython-3-12-liner-and-7-liner-count-and-look-for-minimum.
 */
package com.an7one.leetcode.lvl2.lc1002

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun commonChars(strs: Array<String>): List<String> {
        val ans = ArrayList<String>()

        val minFreqs = IntArray(26) { Int.MAX_VALUE }
        for (str in strs) {
            val freqs = IntArray(26)
            for (ch in str) ++freqs[ch - 'a']

            for (idx in freqs.indices) {
                minFreqs[idx] = minOf(minFreqs[idx], freqs[idx])
            }
        }

        for (ch in 'a'..'z') {
            while (--minFreqs[ch - 'a'] >= 0) {
                ans.add(ch.toString())
            }
        }

        return ans
    }
}