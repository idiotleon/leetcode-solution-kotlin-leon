/**
 * https://leetcode.com/problems/shortest-completing-word/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/shortest-completing-word/discuss/110137/Java-Solution-using-character-Array
 */
package com.zea7ot.leetcode.lvl3.lc0748

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val target = licensePlate.toLowerCase()
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
            if (matches(word.toLowerCase(), freqs) && lenW < minLen) {
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