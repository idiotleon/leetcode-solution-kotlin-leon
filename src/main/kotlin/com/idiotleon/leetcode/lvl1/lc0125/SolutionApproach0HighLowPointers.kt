/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl1.lc0125

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    private companion object {
        private const val SPACE = ' '
    }

    fun isPalindrome(str: String): Boolean {
        val lenS = str.length

        var lo = 0
        var hi = lenS - 1

        while (lo < hi) {
            while (lo < hi && !str[lo].isLetterOrDigit()) ++lo
            while (lo < hi && !str[hi].isLetterOrDigit()) --hi

            if (str[lo].toLowerCase() != str[hi].toLowerCase())
                return false

            ++lo
            --hi
        }

        return true
    }
}