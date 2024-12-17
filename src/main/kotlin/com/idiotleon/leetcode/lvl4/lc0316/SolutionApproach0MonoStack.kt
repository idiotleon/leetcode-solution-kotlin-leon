package com.idiotleon.leetcode.lvl4.lc0316

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * To main a "strictly increasing" stack
 *  1. The contents are actual characters
 *  2. The order of characters is maintained in strictly increasing order, if possible
 *      by "if possible", it rather depends on the given String sequence,
 *      in another word, how many letters left, and what they are
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun removeDuplicateLetters(s: String): String {
        val lenS = s.length

        val remaining = IntArray(26) { 0 }.also {
            for (ch in s) {
                ++it[ch - 'a']
            }
        }
        val used = IntArray(26) { 0 }

        val builder = StringBuilder(lenS)
        for (ch in s) {
            if (used[ch - 'a'] == 0) {
                while (builder.isNotEmpty() && ch <= builder.last() && remaining[builder.last() - 'a'] > 0) {
                    --used[builder.last() - 'a']
                    builder.deleteCharAt(builder.length - 1)
                }

                builder.append(ch)
                ++used[ch - 'a']
            }

            --remaining[ch - 'a']
        }

        return builder.toString()
    }
}