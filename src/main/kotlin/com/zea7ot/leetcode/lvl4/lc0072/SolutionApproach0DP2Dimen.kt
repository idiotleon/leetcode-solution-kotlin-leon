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
package com.zea7ot.leetcode.lvl4.lc0072

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length

        val costs = Array(len1 + 1) { idx1 ->
            IntArray(len2 + 1) { idx2 ->
                when {
                    idx1 == 0 -> idx2
                    idx2 == 0 -> idx1
                    else -> 0
                }
            }
        }

        for (idx1 in word1.indices) {
            for (idx2 in word2.indices) {
                costs[idx1 + 1][idx2 + 1] = if (word1[idx1] == word2[idx2]) {
                    costs[idx1][idx2]
                } else {
                    val insert = costs[idx1][idx2 + 1]
                    val replace = costs[idx1][idx2]
                    val delete = costs[idx1 + 1][idx2]

                    1 + minOf(insert, replace, delete)
                }
            }
        }

        return costs[len1][len2]
    }
}