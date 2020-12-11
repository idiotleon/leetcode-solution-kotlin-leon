/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-difference/
 *
 * Time Complexity:     O(LEN_S) + O(LEN_T) ~ O(LEN_T)
 * Space Complexity:    O(1) / O(L)
 */
package com.zea7ot.leetcode.lvl1.lc0389

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findTheDifference(s: String, t: String): Char {

        val freqs = IntArray(26) { 0 }

        for (ch in s) {
            ++freqs[ch - 'a']
        }

        for (ch in t) {
            if (--freqs[ch - 'a'] < 0)
                return ch
        }

        return '#'
    }
}