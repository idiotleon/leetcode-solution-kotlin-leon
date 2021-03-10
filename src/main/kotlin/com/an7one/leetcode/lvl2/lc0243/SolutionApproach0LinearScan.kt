/**
 * https://leetcode.com/problems/shortest-word-distance/
 *
 * Time Complexity:     O(`nWords` * lenW)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/shortest-word-distance/discuss/66931/AC-Java-clean-solution/178697
 *  https://leetcode.com/problems/shortest-word-distance/discuss/66931/AC-Java-clean-solution
 */
package com.an7one.leetcode.lvl2.lc0243

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        // not used
        // val nWords = words.size

        var shortest = Int.MAX_VALUE
        var idx1: Int? = null
        var idx2: Int? = null

        for (idx in words.indices) {
            if (words[idx] == word1) {
                idx1 = idx
                idx2?.let { shortest = minOf(shortest, idx1 - it) }
            }

            if (words[idx] == word2) {
                idx2 = idx
                idx1?.let { shortest = minOf(shortest, idx2 - it) }
            }
        }

        return shortest
    }
}