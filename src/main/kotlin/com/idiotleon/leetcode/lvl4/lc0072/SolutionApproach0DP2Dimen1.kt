package com.idiotleon.leetcode.lvl4.lc0072

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/edit-distance/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
 *  https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)/424626
 *  https://web.stanford.edu/class/cs124/lec/med.pdf
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length

        val costs = Array(len1 + 1) { IntArray(len2 + 1) { 0 } }
        for (idx1 in 0..len1) {
            costs[idx1][0] = idx1
        }
        for (idx2 in 0..len2) {
            costs[0][idx2] = idx2
        }

        for (idx1 in word1.indices) {
            for (idx2 in word2.indices) {
                costs[idx1 + 1][idx2 + 1] = if (word1[idx1] == word2[idx2]) {
                    costs[idx1][idx2]
                } else {
                    val insertion = costs[idx1][idx2 + 1]
                    val replacement = costs[idx1][idx2]
                    val deletion = costs[idx1 + 1][idx2]

                    1 + minOf(insertion, replacement, deletion)
                }
            }
        }

        return costs[len1][len2]
    }
}