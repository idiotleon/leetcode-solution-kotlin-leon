package com.an7one.leetcode.lvl2.lc0680

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun validPalindrome(str: String): Boolean {
        // sanity check
        if (str.isEmpty())
            return false

        val lenS = str.length
        var lo = 0
        var hi = lenS - 1

        while (lo < hi) {
            if (str[lo] != str[hi])
                return isPalindrome(lo + 1, hi, str) || isPalindrome(lo, hi - 1, str)

            ++lo
            --hi
        }

        return true
    }

    private fun isPalindrome(low: Int, high: Int, str: String): Boolean {
        var lo = low
        var hi = high

        while (lo < hi) {
            if (str[lo++] != str[hi--]) {
                return false
            }
        }

        return true
    }
}