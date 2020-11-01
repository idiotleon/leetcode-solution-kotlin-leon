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

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1BacktrackNaive {
    fun partition(str: String): List<List<String>> {

        val paths = ArrayList<List<String>>()
        val path = ArrayList<String>()
        backtrack(0, path, str, paths)
        return paths
    }

    private fun backtrack(startIdx: Int,
                          path: ArrayList<String>,
                          str: String,
                          paths: ArrayList<List<String>>) {

        val lenS = str.length
        if (startIdx == lenS) {
            paths.add(path.toList())
            return
        }

        for (i in startIdx until lenS) {
            if (isPalindrome(startIdx, i, str)) {
                path.add(str.substring(startIdx, i + 1))
                backtrack(i + 1, path, str, paths)
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