/**
 * https://leetcode.com/problems/split-two-strings-to-make-palindrome/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/split-two-strings-to-make-palindrome/discuss/888967/JavaC%2B%2BPython-Greedy-Solution-O(1)-Space
 */
package com.idiotleon.leetcode.lvl3.lc1616

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun checkPalindromeFormation(a: String, b: String): Boolean {
        return checkPalindrome(a, b) || checkPalindrome(b, a)
    }

    private fun checkPalindrome(str1: String, str2: String): Boolean {
        val lenS = str1.length
        var lo = 0
        var hi = lenS - 1

        while (lo < hi) {
            if (str1[lo] != str2[hi]) {
                return isPalindrome(lo, hi, str1) || isPalindrome(lo, hi, str2)
            }

            ++lo
            --hi
        }

        return true
    }

    private fun isPalindrome(low: Int, high: Int, str: String): Boolean {
        var lo = low
        var hi = high

        while (lo < hi) {
            if (str[lo++] != str[hi--])
                return false
        }

        return true
    }
}