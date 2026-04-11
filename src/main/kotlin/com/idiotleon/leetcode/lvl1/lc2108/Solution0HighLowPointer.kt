package com.idiotleon.leetcode.lvl1.lc2108

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 *
 * Time Complexity:     O(`nWords` * `lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0HighLowPointer {
    fun firstPalindrome(words: Array<String>): String {
        val nWords = words.size
        for (word in words) {
            if (isPalindrome(word)) {
                return word
            }
        }

        return ""
    }

    private fun isPalindrome(str: String): Boolean {
        val lenS = str.length
        var lo = 0
        var hi = lenS - 1
        while (lo < hi) {
            if (str[lo++] != str[hi--]) {
                return false
            }
        }
        return true
    }
}