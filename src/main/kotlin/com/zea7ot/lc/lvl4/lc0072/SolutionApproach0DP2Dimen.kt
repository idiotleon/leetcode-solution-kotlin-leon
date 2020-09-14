/**
 * https://leetcode.com/problems/edit-distance/
 *
 * Time Complexity:     O(len1 * len2)
 * Space Complexity:    O(len1 * len2)
 *
 * References:
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)/424626
 *  https://web.stanford.edu/class/cs124/lec/med.pdf
 */
package com.zea7ot.lc.lvl4.lc0072

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length

        val dp = Array(len1 + 1) { IntArray(len2 + 1) { 0 } }
        for (row in 0 until len1 + 1) {
            dp[row][0] = row
        }

        for (col in 0 until len2 + 1) {
            dp[0][col] = col
        }

        for (idx1 in 0 until len1) {
            for (idx2 in 0 until len2) {
                if (word1[idx1] == word2[idx2]) {
                    dp[idx1 + 1][idx2 + 1] = dp[idx1][idx2]
                } else {
                    val replace = dp[idx1][idx2]
                    val insert = dp[idx1][idx2 + 1]
                    val delete = dp[idx1 + 1][idx2]

                    val minCost = minOf(replace, insert, delete)
                    dp[idx1 + 1][idx2 + 1] = minCost + 1
                }
            }
        }

        return dp[len1][len2]
    }
}