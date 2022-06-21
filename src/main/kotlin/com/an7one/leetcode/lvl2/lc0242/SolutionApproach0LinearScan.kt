package com.an7one.leetcode.lvl2.lc0242

import com.an7one.leetcode.util.Constant

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-anagram/
 * Time Complexity:     O(`lenS` + `lenT`) ~ O(max(`lenS`, `lenT`))
 * Space Complexity:    O(26) ~ O(1)
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0LinearScan {
    fun isAnagram(s: String, t: String): Boolean {
        // not used
        // val lenS = s.length
        // not used
        // val lenT = t.length

        val freqs = IntArray(26) { 0 }.also {
            for (ch in s) {
                ++it[ch - 'a']
            }
        }

        for (ch in t) {
            --freqs[ch - 'a']
        }

        for (freq in freqs) {
            if (freq != 0)
                return false
        }
        return true
    }
}