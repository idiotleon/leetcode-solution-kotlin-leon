package com.idiotleon.leetcode.lvl3.lc0748

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-completing-word/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/shortest-completing-word/discuss/110137/Java-Solution-using-character-Array
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val target = licensePlate.lowercase()
        val freqs = IntArray(26) { 0 }
        for (ch in target) {
            if (ch in 'a'..'z') {
                ++freqs[ch - 'a']
            }
        }

        var minLen = Int.MAX_VALUE
        var shortest = ""

        for (word in words) {
            val lenW = word.length
            if (matches(word.lowercase(), freqs) && lenW < minLen) {
                minLen = lenW
                shortest = word
            }
        }

        return shortest
    }

    private fun matches(word: String, freqs: IntArray): Boolean {
        val targetMap = IntArray(26) { 0 }
        for (ch in word) {
            if (ch in 'a'..'z') {
                ++targetMap[ch - 'a']
            }
        }

        for (idx in targetMap.indices) {
            if (freqs[idx] != 0 && targetMap[idx] < freqs[idx]) return false
        }

        return true
    }
}