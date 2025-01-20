package com.idiotleon.leetcode.lvl2.lc1961

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/solutions/1390619/tricky-description/comments/1041447
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun isPrefixString(s: String, words: Array<String>): Boolean {
        val lenS = s.length
        val nWords = words.size

        var idxS = 0

        for (word in words) {
            for (ch in word) {
                if (idxS == lenS || s[idxS++] != ch) {
                    return false
                }
            }
            if (idxS == lenS) {
                return true
            }
        }
        return false
    }
}