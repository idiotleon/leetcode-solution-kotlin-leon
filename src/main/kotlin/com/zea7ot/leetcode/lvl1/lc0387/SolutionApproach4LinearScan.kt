/**
 * @author: Leon
 * this does not work,
 *  because lower/later repeated characters, when they are met for the first time,
 *  overrides/shadows higher/previous single character(s)
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(26)
 */
package com.zea7ot.leetcode.lvl1.lc0387

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach4LinearScan {
    fun firstUniqChar(str: String): Int {
        var ans: Int? = null

        val freqs = IntArray(26) { 0 }
        for (idx in str.indices.reversed()) {
            if (++freqs[str[idx] - 'a'] == 1) {
                ans = idx
            }
        }

        return if (ans == null || freqs[str[ans] - 'a'] > 1) -1 else ans
    }
}