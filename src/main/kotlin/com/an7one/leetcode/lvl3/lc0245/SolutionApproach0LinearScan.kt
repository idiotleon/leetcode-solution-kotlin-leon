/**
 * https://leetcode.com/problems/shortest-word-distance-iii/
 *
 * Time Complexity:     O(`nWords` * len)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/shortest-word-distance-iii/discuss/67097/12-16-lines-Java-C++/69108
 */
package com.an7one.leetcode.lvl3.lc0245

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun shortestWordDistance(words: Array<String>, word1: String, word2: String): Int {
        val nWords = words.size

        var shortest = Int.MAX_VALUE

        var idx1 = nWords
        var idx2 = -nWords

        val isSame = word1 == word2

        for (idx in words.indices) {
            when {
                words[idx] == word1 -> {
                    if (isSame) {
                        idx2 = idx1
                    }

                    idx1 = idx
                }

                words[idx] == word2 -> idx2 = idx
            }

            shortest = minOf(shortest, abs(idx1 - idx2))
        }

        return shortest
    }
}