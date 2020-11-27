/**
 * https://leetcode.com/problems/camelcase-matching/
 *
 * Time Complexity:     O(`nQueries` * (`lenQ` * `lenP`))
 * Space Complexity:    O(`lenQ` * `lenP`)
 *
 * References:
 *  https://leetcode.com/problems/camelcase-matching/discuss/270742/java-4ms-dp-solution-and-summarization-of-string-match-problems
 */
package com.zea7ot.leetcode.lvl3.lc1023

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1DP2Dimen {
    fun camelMatch(queries: Array<String>, pattern: String): BooleanArray {
        val nQueries = queries.size
        val ans = BooleanArray(nQueries) { false }

        var idx = 0
        for (query in queries) {
            ans[idx++] = isMatching(query, pattern)
        }

        return ans
    }

    private fun isMatching(query: String, pattern: String): Boolean {
        val lenQ = query.length
        val lenP = pattern.length
        val dp = Array(lenQ + 1) { BooleanArray(lenP + 1) { false } }.also {
            it[0][0] = true

            for (idx in query.indices) {
                if (query[idx] in 'a'..'z') {
                    it[idx + 1][0] = it[idx][0]
                }
            }
        }

        for (idxQ in query.indices) {
            for (idxP in pattern.indices) {
                if (query[idxQ] == pattern[idxP]) {
                    dp[idxQ + 1][idxP + 1] = dp[idxQ][idxP]
                } else if (query[idxQ] in 'a'..'z') {
                    dp[idxQ + 1][idxP + 1] = dp[idxQ][idxP + 1]
                }
            }
        }

        return dp[lenQ][lenP]
    }
}