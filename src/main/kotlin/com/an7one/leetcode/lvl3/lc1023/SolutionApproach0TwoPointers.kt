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
package com.an7one.leetcode.lvl3.lc1023

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
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
        val lenP = pattern.length
        var idx = 0

        // two pointers approach
        for (ch in query) {
            if (idx < lenP && ch == pattern[idx]) ++idx
            else if (ch < 'a') return false
        }

        return idx == lenP
    }
}