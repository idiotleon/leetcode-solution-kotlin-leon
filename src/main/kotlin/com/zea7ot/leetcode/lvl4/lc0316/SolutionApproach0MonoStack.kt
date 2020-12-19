/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * to main a "strickly increasing" stack
 *  1. the contents are actual characters
 *  2. the order of characters is maintained in strictly increasing order, if possible
 *      by "if possible", it rather depends on the given String sequence,
 *      in another words, how many letters left, and what they are
 */
package com.zea7ot.leetcode.lvl4.lc0316

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun removeDuplicateLetters(s: String): String {
        // not used
        // val lenS = s.length

        val remaining = IntArray(26) { 0 }
        val used = IntArray(26) { 0 }
        for (ch in s) {
            ++remaining[ch - 'a']
        }

        val builder = StringBuilder()
        for (ch in s) {
            if (used[ch - 'a'] == 0) {
                while (builder.isNotEmpty()
                        && builder.last() >= ch
                        && remaining[builder.last() - 'a'] > 0) {

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