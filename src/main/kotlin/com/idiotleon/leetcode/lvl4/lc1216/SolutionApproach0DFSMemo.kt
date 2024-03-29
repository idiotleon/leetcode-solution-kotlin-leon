package com.idiotleon.leetcode.lvl4.lc1216

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-palindrome-iii/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/valid-palindrome-iii/discuss/397606/Find-Longest-Palindromic-Subsequence.
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun isValidPalindrome(s: String, k: Int): Boolean {
        val lenS = s.length
        val memo = Array(lenS) { Array<Int?>(lenS) { null } }

        return lenS - dfs(0, lenS - 1, s, memo) <= k
    }

    private fun dfs(lo: Int, hi: Int, str: String, memo: Array<Array<Int?>>): Int {
        if (lo > hi) return 0
        if (lo == hi) return 1

        memo[lo][hi]?.let { return it }

        val longest = if (str[lo] == str[hi]) {
            dfs(lo + 1, hi - 1, str, memo) + 2
        } else {
            maxOf(dfs(lo + 1, hi, str, memo), dfs(lo, hi - 1, str, memo))
        }

        memo[lo][hi] = longest
        return longest
    }
}