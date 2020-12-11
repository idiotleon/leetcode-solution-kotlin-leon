/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Time Complexity:     O((2 ^ `lenS`) * (`lenS` ^ 2))
 * Space Complexity:    O(`lenS`)
 *
 *
 * References:
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *  https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
 */
package com.zea7ot.leetcode.lvl3.lc0131

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1BacktrackNaive {
    fun partition(str: String): List<List<String>> {
        val paths = mutableListOf<List<String>>()
        val path = mutableListOf<String>()
        backtrack(0, path, str, paths)
        return paths
    }

    private fun backtrack(idxStart: Int,
                          path: MutableList<String>,
                          str: String,
                          paths: MutableList<List<String>>) {

        val lenS = str.length
        if (idxStart == lenS) {
            paths.add(path.toList())
            return
        }

        for (idx in idxStart until lenS) {
            if (isPalindrome(idxStart, idx, str)) {
                path.add(str.substring(idxStart, idx + 1))
                backtrack(idx + 1, path, str, paths)
                path.removeAt(path.size - 1)
            }
        }
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