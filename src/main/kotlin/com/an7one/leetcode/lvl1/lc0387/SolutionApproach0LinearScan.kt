/**
 * @author: Leon
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(26)
 */
package com.an7one.leetcode.lvl1.lc0387

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun firstUniqChar(str: String): Int {
        // not used
        // val lenS = str.length

        val freqs = IntArray(26) { 0 }
        for (idx in str.indices) {
            ++freqs[str[idx] - 'a']
        }

        for (idx in str.indices) {
            if (freqs[str[idx] - 'a'] == 1) {
                return idx
            }
        }

        return -1
    }
}