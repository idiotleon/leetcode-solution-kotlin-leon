/**
 * https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100/752768
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425211/Java-Bit-manipulation-solution-Clean-code-5ms-beat-100
 */
package com.zea7ot.leetcode.lvl4.lc1255.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val nWords = words.size
        val freqs = IntArray(26) { 0 }
        for (ch in letters) ++freqs[ch - 'a']

        var maxScore = 0
        loop1@ for (combination in 0 until (1 shl nWords)) {
            // total scores for this combination
            var totalScore = 0
            val available = freqs.copyOf()

            loop2@ for (idx in 0 until nWords) {
                if ((combination and (1 shl idx)) > 0) {
                    val word = words[idx]
                    var curScore = 0

                    loop3@ for (ch in word) {
                        if (available[ch - 'a'] > 0) {
                            --available[ch - 'a']
                            curScore += score[ch - 'a']
                        } else {
                            curScore = 0
                            break@loop3
                        }
                    }

                    totalScore += curScore
                }

            }

            maxScore = maxOf(maxScore, totalScore)
        }

        return maxScore
    }
}