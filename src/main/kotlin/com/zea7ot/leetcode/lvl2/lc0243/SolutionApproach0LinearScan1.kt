/**
 * https://leetcode.com/problems/shortest-word-distance/
 *
 * Time Complexity:     O(`nWords` * lenW)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/shortest-word-distance/discuss/66939/Java%3A-only-need-to-keep-one-index
 *  https://leetcode.com/problems/shortest-word-distance/discuss/66939/Java:-only-need-to-keep-one-index/69011
 */
package com.zea7ot.leetcode.lvl2.lc0243

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        val nWords = words.size

        var shortest = nWords
        var prevIdx: Int? = null

        for (idx in words.indices) {
            if (words[idx] == word1 || words[idx] == word2) {
                prevIdx?.let {
                    if (words[it] != words[idx]) {
                        shortest = minOf(shortest, idx - it)
                    }
                }

                prevIdx = idx
            }
        }

        return shortest
    }
}