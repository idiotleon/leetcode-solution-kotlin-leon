package com.an7one.leetcode.lvl2.lc0266

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/palindrome-permutation/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`len`)
 */
@Suppress(UNUSED)
class SolutionApproach0CountFreqs {
    fun canPermutePalindrome(str: String): Boolean {
        val freqs = IntArray(256) { 0 }
        for (ch in str) {
            ++freqs[ch.code]
        }

        var cntOdd = 0
        for (freq in freqs) {
            if (freq % 2 == 1)
                if (++cntOdd > 1)
                    return false
        }

        return true
    }
}