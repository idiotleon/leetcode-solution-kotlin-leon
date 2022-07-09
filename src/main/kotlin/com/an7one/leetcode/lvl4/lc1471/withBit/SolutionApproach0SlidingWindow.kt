package com.an7one.leetcode.lvl4.lc1471.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    private companion object {
        private val VOWELS = charArrayOf('a', 'e', 'i', 'o', 'u')
    }

    fun findTheLongestSubstring(str: String): Int {
        // val lenS = str.length
        val firstIndices = IntArray(1 shl 5) { Int.MAX_VALUE }.also {
            it[0] = -1
        }

        var bitMask = 0
        var longest = 0

        for (idx in str.indices) {
            for (idxVowel in VOWELS.indices) {
                if (str[idx] == VOWELS[idxVowel]) {
                    bitMask = bitMask xor (1 shl idxVowel)
                }
            }

            if (firstIndices[bitMask] == Int.MAX_VALUE) firstIndices[bitMask] = idx
            longest = maxOf(longest, idx - firstIndices[bitMask])
        }

        return longest
    }
}