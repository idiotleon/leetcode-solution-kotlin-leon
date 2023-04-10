/**
 * @author: Leon
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.idiotleon.leetcode.lvl1.lc0387

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun firstUniqChar(str: String): Int {
        // not used
        // val lenS = str.length

        val freqs = IntArray(26) { 0 }.also {
            for (ch in str) {
                ++it[ch - 'a']
            }
        }

        for ((idx, ch) in str.withIndex()) {
            if (freqs[ch - 'a'] == 1)
                return idx
        }

        return -1
    }
}