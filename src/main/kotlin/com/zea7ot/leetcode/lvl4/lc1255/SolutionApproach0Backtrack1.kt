/**
 * https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 *
 * Time Complexity:     O(2 ^ (`nWords` * lenW))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100/747500
 *  https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100
 */
package com.zea7ot.leetcode.lvl4.lc1255

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack1 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        // not used
        // val nWords = words.size

        val freqs = IntArray(26) { 0 }
        for (ch in letters) ++freqs[ch - 'a']

        return dfs(0, freqs, score, words)
    }

    private fun dfs(idx: Int,
                    freqs: IntArray,
                    score: IntArray,
                    words: Array<String>): Int {

        val nWords = words.size
        if (idx == nWords) return 0

        val word = words[idx]

        return if (!canBeFormed(word, freqs)) {
            dfs(idx + 1, freqs, score, words)
        } else {
            var curScore = 0
            val available = freqs.copyOf()
            for (ch in word) {
                --available[ch - 'a']
                curScore += score[ch - 'a']
            }

            val notPicked = dfs(idx + 1, freqs, score, words)
            val picked = curScore + dfs(idx + 1, available, score, words)
            maxOf(notPicked, picked)
        }
    }

    private fun canBeFormed(word: String, freqs: IntArray): Boolean {
        val available = freqs.copyOf()

        for (ch in word) {
            if (--available[ch - 'a'] < 0) return false
        }

        return true
    }
}