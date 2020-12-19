/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Time Complexity:     O(`len`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0680

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun validPalindrome(str: String): Boolean {
        // sanity check
        if (str.isEmpty()) return false

        val len = str.length
        var lo = 0
        var hi = len - 1

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