package com.an7one.leetcode.lvl1.lc0819

import com.an7one.leetcode.util.Constant

/**
 * https://leetcode.com/problems/most-common-word/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/most-common-word/discuss/124286/Clean-6ms-C%2B%2B-solution
 */
@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0HashMap {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val lenP = paragraph.length
        val wordToFreq = HashMap<String, Int>()

        var idx = 0
        while (idx < lenP) {
            val builder = StringBuilder()
            while (idx < lenP && paragraph[idx].isLetter()) {
                builder.append(paragraph[idx++].toLowerCase())
            }

            while (idx < lenP && !paragraph[idx].isLetter()) {
                idx++
            }

            val word = builder.toString()
            wordToFreq[word] = 1 + (wordToFreq[word] ?: 0)
        }

        for (word in banned) {
            wordToFreq.remove(word)
        }

        var ans = ""
        var mostFreq = 0

        for ((word, freq) in wordToFreq) {
            if (freq > mostFreq) {
                ans = word
                mostFreq = freq
            }
        }

        return ans
    }
}