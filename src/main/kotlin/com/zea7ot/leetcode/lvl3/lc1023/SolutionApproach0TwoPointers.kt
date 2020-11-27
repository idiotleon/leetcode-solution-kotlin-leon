/**
 * https://leetcode.com/problems/camelcase-matching/
 *
 * Time Complexity: O(`nQueries` * len)
 *  nQueries, the number of words
 *  len, the average length of the words
 *
 * Space Complexity:  O(`nQueries`)
 *  nQueries, the space consumed by the answer list
 */
package com.zea7ot.leetcode.lvl3.lc1023

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun camelMatch(queries: Array<String>, pattern: String): BooleanArray {
        val nQueries = queries.size
        val ans = BooleanArray(nQueries) { false }

        var idx = 0
        for (query in queries) {
            ans[idx++] = isMatch(query, pattern)
        }

        return ans
    }

    private fun isMatch(query: String, pattern: String): Boolean {
        val lenP = pattern.length
        var idx = 0

        for (ch in query) {
            if (idx < lenP && ch == pattern[idx]) ++idx
            else if (ch < 'a') return false
        }

        return idx == lenP
    }
}