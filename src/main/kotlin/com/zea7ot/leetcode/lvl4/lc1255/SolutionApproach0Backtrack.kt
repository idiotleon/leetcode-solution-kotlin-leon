/**
 * https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 *
 * Time Complexity:     O(2 ^ (`nWords` * lenW))
 *  lenW, average length of words
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100/747500
 */
package com.zea7ot.leetcode.lvl4.lc1255

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        // not used
        // val nWords = words.size

        val freqs = IntArray(26) { 0 }
        for (ch in letters) ++freqs[ch - 'a']

        return backtrack(0, freqs, score, words)
    }

    private fun backtrack(startIdx: Int,
                          freqs: IntArray,
                          score: IntArray,
                          words: Array<String>): Int {

        val nWords = words.size

        var maxScore = 0
        var curScore = 0
        for (idx in startIdx until nWords) {
            val word = words[idx]
            var canBeFormed = true

            // to further backtrack to the next state
            for (ch in word) {
                if (--freqs[ch - 'a'] < 0) canBeFormed = false
                curScore += score[ch - 'a']
            }

            if (canBeFormed) {
                curScore += backtrack(idx + 1, freqs, score, words)
                maxScore = maxOf(maxScore, curScore)
            }

            // to backtrack to the previous state
            for (ch in word) {
                ++freqs[ch - 'a']
            }
            curScore = 0
        }

        return maxScore
    }
}