/**
 * @author: Leon
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 *
 * Time Complexity:     O(`nWords` * ave_len_word)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.idiotleon.leetcode.lvl1.lc1897

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun makeEqual(words: Array<String>): Boolean {
        val nWords = words.size
        val freqs = IntArray(26) { 0 }

        for (word in words) {
            for (ch in word) {
                ++freqs[ch - 'a']
            }
        }

        for (freq in freqs) {
            if (freq % nWords != 0)
                return false
        }

        return true
    }
}