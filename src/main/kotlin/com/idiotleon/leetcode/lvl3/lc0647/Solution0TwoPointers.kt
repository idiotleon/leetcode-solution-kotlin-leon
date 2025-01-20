package com.idiotleon.leetcode.lvl3.lc0647

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome
 */
@Suppress(UNUSED)
class Solution0TwoPointers {
    fun countSubstrings(str: String): Int {
        var count = 0

        for (idx in str.indices) {
            count += expand(idx, idx, str)
            count += expand(idx, 1 + idx, str)
        }

        return count
    }

    private fun expand(low: Int, high: Int, str: String): Int {
        val lenS = str.length

        var count = 0
        var lo = low
        var hi = high

        while (lo >= 0 && hi < lenS && (str[lo] == str[hi])) {
            --lo
            ++hi
            ++count
        }

        return count
    }
}