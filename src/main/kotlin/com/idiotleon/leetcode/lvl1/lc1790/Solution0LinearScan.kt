package com.idiotleon.leetcode.lvl1.lc1790

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val lenS1 = s1.length
        val lenS2 = s2.length
        if (s1 == s2) {
            return true
        }

        var count = 0
        var idx1: Int? = null
        var idx2: Int? = null

        for (idx in 0 until lenS1) {
            if (s1[idx] != s2[idx]) {
                if (++count > 2) {
                    return false
                }
                if (idx1 == null) {
                    idx1 = idx
                } else if (idx2 == null) {
                    idx2 = idx
                }
            }
        }

        if (count == 1) {
            return false
        }

        return s1[idx1!!] == s2[idx2!!] && s1[idx2!!] == s2[idx1!!]
    }
}