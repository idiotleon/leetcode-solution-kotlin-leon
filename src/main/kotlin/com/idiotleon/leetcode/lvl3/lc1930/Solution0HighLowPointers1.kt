package com.idiotleon.leetcode.lvl3.lc1930

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/editorial/
 */
@Suppress(UNUSED)
class Solution0HighLowPointers1 {
    fun countPalindromicSubsequence(s: String): Int {
        val lenS = s.length

        var ans = 0
        for (idxCh in 0 until 26) {
            val ch = ('a' + idxCh).toChar()

            val lo = s.indexOf(ch)
            val hi = s.lastIndexOf(ch)

            val between = HashSet<Char>()
            for (mid in lo + 1 until hi) {
                between.add(s[mid])
            }

            ans += between.size
        }

        return ans
    }
}