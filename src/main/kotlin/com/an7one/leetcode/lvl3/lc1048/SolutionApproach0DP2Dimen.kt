package com.an7one.leetcode.lvl3.lc1048

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-string-chain/
 *
 * Time Complexity:     O(`nWords` * lg(`nWords`)) + O((`nWords` ^ 2) * L)
 *  O(`nWords` * lg(`nWords`)), consumed by sorting
 *  O((`nWords` ^ 2) * L), consumed by DP
 *
 * Space Complexity:    O(`nWords`)
 *
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun longestStrChain(words: Array<String>): Int {
        // sanity check
        if (words.isEmpty()) return 0

        val nWords = words.size

        words.sortBy { it.length }

        val dp = IntArray(nWords) { 1 }
        var longest = 1

        for (hi in 1 until nWords) {
            for (lo in 0 until hi) {
                val word1 = words[lo]
                val word2 = words[hi]
                if (word2.length - word1.length <= 1) {
                    if (isPredecessor(word1, word2)) {
                        dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                    }
                }
            }

            longest = maxOf(longest, dp[hi])
        }

        return longest
    }

    // to check whether `word1` is a predecessor of `word2`
    private fun isPredecessor(word1: String, word2: String): Boolean {
        val len1 = word1.length
        val len2 = word2.length

        if (len1 == len2) return false

        var idx1 = 0
        var idx2 = 0
        var diff = 0

        while (idx1 < len1) {
            if (word1[idx1] == word2[idx2]) {
                ++idx1
                ++idx2
            } else {
                if (++diff > 1) return false
                ++idx2
            }
        }

        return true
    }
}